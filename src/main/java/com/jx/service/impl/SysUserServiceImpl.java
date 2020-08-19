package com.jx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.SysUserDao;
import com.jx.entity.*;
import com.jx.service.*;
import com.utils.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * 系统用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 11:50:41
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
    /**
     * 引入订单工具
     */
    private final CapitalUtils capitalUtils = new CapitalUtils();
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SendSmsService sendSmsService;
    @Resource
    private SystemSetService systemSetService;
    @Resource
    private CardService cardService;
    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private SwiperService swiperService;
    @Resource
    private NoticeService noticeService;
    @Resource
    private OrderFormService orderFormService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Map<String, Object> queryById(String id) {
        if (StringUtils.isEmpty(id)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        SysUser sysUser = this.sysUserDao.queryById(id);
        if (sysUser == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(sysUser);
    }

    /**
     * 查询多条数据
     *
     * @param sysUser        实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(SysUser sysUser, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
        if (page == null || limit == null) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        if (preciseOrFuzzy == null) {
            preciseOrFuzzy = 1;
        }
        if (page < 1) {
            page = 1;
        }
        long offset = (page - 1) * limit;
        //时间范围
        Date begin = null, end = null;
        if (StringUtils.isNotEmpty(timeArea)) {
            String[] times = timeArea.split("~");
            begin = DateFormatUtils.parseDateString(times[0], DateFormatUtils.defaultFormat);
            end = DateFormatUtils.parseDateString(times[1], DateFormatUtils.defaultFormat);
        }
        if (sysUser == null) {
            sysUser = new SysUser();
        }
        sysUser.setDeleted(0);
        //列表
        List<SysUser> list = this.sysUserDao.queryAllByLimit(sysUser, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.sysUserDao.countByParam(sysUser, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 查询多条数据
     *
     * @param sysUser        实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimitNot(SysUser sysUser, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
        if (page == null || limit == null) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        if (preciseOrFuzzy == null) {
            preciseOrFuzzy = 1;
        }
        if (page < 1) {
            page = 1;
        }
        long offset = (page - 1) * limit;
        //时间范围
        Date begin = null, end = null;
        if (StringUtils.isNotEmpty(timeArea)) {
            String[] times = timeArea.split("~");
            begin = DateFormatUtils.parseDateString(times[0], DateFormatUtils.defaultFormat);
            end = DateFormatUtils.parseDateString(times[1], DateFormatUtils.defaultFormat);
        }
        if (sysUser == null) {
            sysUser = new SysUser();
        }
        sysUser.setDeleted(0);
        //列表
        List<SysUser> list = this.sysUserDao.queryAllByLimitNot(sysUser, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.sysUserDao.countByParamNot(sysUser, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, SysUser sysUser) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        sysUser.setId(UUIDUtils.generate());
        sysUser.setCreatedTime(now);
        sysUser.setLastUpdateTime(now);
        sysUser.setCreator(tokenObj.getUserName());
        sysUser.setCreatorId(tokenObj.getUserId());
        sysUser.setLastUpdater(tokenObj.getUserName());
        sysUser.setLastUpdateId(tokenObj.getUserId());
        sysUser.setInviteCode(inviteCodeGenerate());
        sysUser.setPassword(CipherUtils.passwordSalt(sysUser.getPassword()));
        sysUser.setName(RandomStringUtils.randomAlphabetic(8).toLowerCase());
        sysUser.setDeleted(0);
        if (this.sysUserDao.insert(sysUser) > 0) {
            return Response.success(sysUser);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, SysUser sysUser) {
        if (StringUtils.isEmpty(token, sysUser.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        sysUser.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        sysUser.setLastUpdater(tokenObj.getUserName());
        sysUser.setLastUpdateId(tokenObj.getUserId());
        sysUser.setDeleted(0);
        if (this.sysUserDao.update(sysUser) > 0) {
            updateOnlineToken(sysUser);
            return this.queryById(sysUser.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, SysUser sysUser) {
        if (StringUtils.isEmpty(token, sysUser.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        sysUser.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        sysUser.setLastUpdater(tokenObj.getUserName());
        sysUser.setLastUpdateId(tokenObj.getUserId());
        sysUser.setDeleted(0);
        if (this.sysUserDao.updateAllColumn(sysUser) > 0) {
            updateOnlineToken(sysUser);
            return Response.success(this.queryById(sysUser.getId()));
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 更新在线token
     *
     * @param sysUser 更新后的用户
     */
    private void updateOnlineToken(SysUser sysUser) {
        Token onlineToken = TokenUtils.getOnlineToken(sysUser.getId());
        if (onlineToken != null) {
            onlineToken.setUserName(sysUser.getName());
            onlineToken.setUserId(sysUser.getId());
            onlineToken.setRoleId(sysUser.getRoleId());
            onlineToken.setPhone(sysUser.getPhone());
            onlineToken.setInvalidateTime(DateFormatUtils.parseDateString(DateFormatUtils.addDays(DateFormatUtils.getCurrentDateString(), 15), DateFormatUtils.defaultFormat));
            onlineToken.setCompanyId(sysUser.getCompanyId());
            onlineToken.setAccount(sysUser.getAccount());
            onlineToken.setUserRole(sysUser.getRoleName());
            onlineToken.setAuth(getAuth(sysUser));
            TokenUtils.updateOnlineToken(onlineToken);
        }
    }

    /**
     * 通过实体获取Auth
     *
     * @param sysUser 实体
     * @return auth
     */
    private String getAuth(SysUser sysUser) {
        String roleId = sysUser.getRoleId();
        if (StringUtils.isEmpty(roleId)) {
            return "unlogin";
        }
        String auth;
        switch (roleId) {
            case "1":
                auth = "admin";
                break;
            case "2":
                auth = "member";
                break;
            case "3":
                auth = "company";
                break;
            default:
                auth = "unlogin";
        }
        return auth;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键列表 字符串根据,分隔
     * @return 是否成功
     */
    @Override
    public Map<String, Object> deleteById(String token, String id) {
        if (StringUtils.isEmpty(token, id)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        //转为换维数组格式
        String[] idArr = id.split(",");
        List<String> idList = new ArrayList<>();
        Collections.addAll(idList, idArr);
        //逻辑删除
        if (this.sysUserDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 根据账号查询
     *
     * @param account 账号
     * @return 对象
     */
    @Override
    public SysUser queryByAccount(String account) {
        return this.sysUserDao.queryByAccount(account);
    }

    /**
     * 注册方法
     *
     * @param param 前台数据{"phoneNumber","password","parentId","phoneCode"}
     * @return 注册结果
     */
    @Override
    public Map<String, Object> register(JSONObject param) {
        String[] openIds = new String[2];
        String phone = param.getString(ConstantPool.PHONE_NUMBER);
        String password = param.getString(ConstantPool.PASSWORD);
        String parentId = param.getString(ConstantPool.PARENT_ID);
        if (StringUtils.isEmpty(phone, password)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        //判断手机号是否已经被注册
        Map<String, Object> phoneInfo = checkPhone(phone);
        if (!(Boolean) phoneInfo.get(ConstantPool.RESPONSE_STATE)) {
            return phoneInfo;
        }
        param.put(ConstantPool.PHONE_CODE_STATE, SmsCode.REGISTRATION.getState());
        Map<String, Object> smsVerification = sendSmsService.verificationCode(param);
        if (!(boolean) smsVerification.get(ConstantPool.RESPONSE_STATE)) {
            return smsVerification;
        }
        SysUser sysUser = new SysUser();
        if (!StringUtils.isEmpty(parentId)) {
            SysUser parentUser = checkParent(parentId);
            //如果查询不到推荐人信息
            if (parentUser == null) {
                //报错
                return Response.fail(ErrorItem.PARENT_ID_NOT_FOUND);
            } else {
                //设置上级ID
                sysUser.setParentId(parentUser.getId());
                openIds[0] = parentUser.getOpenId();
            }
            //查询推荐人的推荐人
            SysUser parentParUser = sysUserDao.queryById(parentUser.getParentId());
            //如果是盟主
            if (ConstantPool.COMPANY_ROLE_ID.equals(parentUser.getRoleId())) {
                //设置盟主ID
                sysUser.setCompanyId(parentUser.getId());
                //如果上上级是盟主
            } else if (parentParUser != null && ConstantPool.COMPANY_ROLE_ID.equals(parentParUser.getRoleId())) {
                sysUser.setCompanyId(parentParUser.getId());
                openIds[1] = parentParUser.getOpenId();
            } else {
                //否则盟主为空
                sysUser.setCompanyId(parentUser.getCompanyId());
            }
        } else {
            return Response.fail(ErrorItem.PARENT_ID_NOT_FOUND);
        }
        Date now = DateFormatUtils.getCurrentDate();
        sysUser.setAccount(phone);
        sysUser.setPhone(phone);
        sysUser.setPassword(CipherUtils.passwordSalt(password));
        sysUser.setName(RandomStringUtils.randomAlphabetic(8).toLowerCase());
        sysUser.setUserState(1);
        sysUser.setId(UUIDUtils.generate());
        sysUser.setCreatedTime(now);
        sysUser.setCreator("register");
        sysUser.setCreatorId("register");
        sysUser.setLastUpdateId("register");
        sysUser.setLastUpdater("register");
        sysUser.setLastUpdateTime(now);
        sysUser.setRoleId("2");
        sysUser.setRoleName("会员");
        sysUser.setCompanyLevel(0);
        sysUser.setMemberLevel(1);
        sysUser.setDeleted(0);
        sysUser.setCumulativePoint(new BigDecimal("0.0"));
        sysUser.setCumulativeProfit(new BigDecimal("0.0"));
        sysUser.setBalance(new BigDecimal("0.0"));
        sysUser.setOpenId("");
        sysUser.setInviteCode(inviteCodeGenerate());
        sysUser.setHeadUrl("");
        WeiXinSendMsg.registerMsgBatch(sysUser.getName(), openIds);
        if (this.sysUserDao.insert(sysUser) > 0) {
            return Response.success(sysUser);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 邀请码生成
     *
     * @return 邀请码
     */
    private String inviteCodeGenerate() {
        String s = RandomStringUtils.random(6, false, true).toUpperCase();
        if (!inviteCodeCheck(s)) {
            inviteCodeGenerate();
        }
        return s;
    }

    /**
     * 邀请码重复验证
     *
     * @param inviteCode 邀请码
     * @return 是否重复
     */
    private boolean inviteCodeCheck(String inviteCode) {
        SysUser sysUser = sysUserDao.queryByInviteCode(inviteCode);
        return sysUser == null;
    }

    /**
     * 登陆逻辑
     *
     * @param param 前台数据
     * @return 返回参数
     */
    @Override
    public Map<String, Object> login(JSONObject param) {
        String account = param.getString(ConstantPool.ACCOUNT);
        String password = param.getString(ConstantPool.PASSWORD);

        if (StringUtils.isEmpty(account, password)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        SysUser sysUser = queryByAccount(account);
        if (sysUser == null) {
            //账号不存在
            return Response.fail(ErrorItem.SYSTEM_ACCOUNT_CANNOT_USE);
        } else if (!CipherUtils.passwordSalt(password).equals(sysUser.getPassword())) {
            //密码验证
            return Response.fail(ErrorItem.LOGIN_ERROR);
        } else if (sysUser.getUserState() == 0) {
            //账号已被锁定
            return Response.fail(ErrorItem.ACCOUNT_HAS_BEEN_LOCK);
        }
        return loginUtil(sysUser);
    }

    @Override
    public Map<String, Object> loginUtil(SysUser sysUser) {
        Token token = new Token();
        token.setUserName(sysUser.getName());
        token.setUserId(sysUser.getId());
        //十五天失效
        token.setInvalidateTime(DateFormatUtils.parseDateString(DateFormatUtils.addDays(DateFormatUtils.getCurrentDateString(), 15), DateFormatUtils.defaultFormat));
        token.setAuth(getAuth(sysUser));
        token.setRoleId(sysUser.getRoleId());
        token.setUserRole(sysUser.getRoleName());
        token.setPhone(sysUser.getPhone());
        token.setAccount(sysUser.getAccount());
        token.setCompanyId(sysUser.getCompanyId());
        token.setOpenId(sysUser.getOpenId());

        String tokenKey = TokenUtils.getTokenKey(sysUser.getId());
        TokenUtils.addToken(tokenKey, token);

        Map<String, Object> result = Response.success();
        result.put("token", tokenKey);
        String unEnPhone = sysUser.getPhone();
        if (!StringUtils.isEmpty(unEnPhone) && unEnPhone.length() == 11) {
            unEnPhone = unEnPhone.substring(0, 3) + "****" + unEnPhone.substring(7);
            result.put("phoneNumber", unEnPhone);
        }
        result.put("roleName", sysUser.getRoleName() == null ? "" : sysUser.getRoleName());
        result.put("memberLevel", sysUser.getMemberLevel() == null ? "" : sysUser.getMemberLevel());
        result.put("companyLevel", sysUser.getCompanyLevel() == null ? "" : sysUser.getCompanyLevel());
        result.put("headUrl", sysUser.getHeadUrl() == null ? "" : sysUser.getHeadUrl());
        result.put("name", sysUser.getName() == null ? "" : sysUser.getName());
        result.put("roleId", sysUser.getRoleId() == null ? "" : sysUser.getRoleId());
        if (!StringUtils.isEmpty(sysUser.getOpenId())) {
            WeiXinSendMsg.loginMsg(unEnPhone, sysUser.getOpenId());
        }
        return result;
    }

    /**
     * 找回密码
     *
     * @param param {"phoneNumber","password","phoneCode"}
     * @return 返回参数
     */
    @Override
    public Map<String, Object> findPassword(JSONObject param) {
        param.put(ConstantPool.PHONE_CODE_STATE, SmsCode.FIND_PASSWORD.getState());
        Map<String, Object> smsVerification = sendSmsService.verificationCode(param);
        if (!(boolean) smsVerification.get(ConstantPool.RESPONSE_STATE)) {
            return smsVerification;
        }
        String account = param.getString(ConstantPool.PHONE_NUMBER);
        String password = param.getString(ConstantPool.PASSWORD);
        SysUser sysUser = sysUserDao.queryByAccount(account);
        sysUser.setPassword(CipherUtils.passwordSalt(password));
        if (this.sysUserDao.updateAllColumn(sysUser) > 0) {
            return this.queryById(sysUser.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 累计积分兑换升级
     *
     * @param token token
     * @return 升级结果
     */
    @Override
    public Map<String, Object> pointUpgrade(String token) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("ID", Objects.requireNonNull(tokenObj).getUserId());
        SysUser sysUser = getOne(wrapper);
        switch (sysUser.getMemberLevel()) {
            case 1:
                if (sysUser.getCumulativePoint().compareTo(new BigDecimal(ConstantPool.UPGRADE_GOLD_POINT)) >= 0) {
                    sysUser.setMemberLevel(2);
                    sysUser.updateById();
                    return Response.success(ErrorItem.UPGRADE_SUCCESS);
                } else {
                    return Response.fail(ErrorItem.POINT_NOT_ENOUGH);
                }
            case 2:
                if (sysUser.getCumulativePoint().compareTo(new BigDecimal(ConstantPool.UPGRADE_DIAMOND_POINT)) >= 0) {
                    sysUser.setMemberLevel(3);
                    sysUser.updateById();
                    return Response.success(ErrorItem.UPGRADE_SUCCESS);
                } else {
                    return Response.fail(ErrorItem.POINT_NOT_ENOUGH);
                }
            case 3:
                return Response.fail(ErrorItem.ARRIVE_HIGHEST_LEVEL);
            default:
                return Response.fail(ErrorItem.SYSTEM_ERROR_MSG);
        }
    }

    /**
     * 会员充值升级 假定已经支付成功
     *
     * @param orderForm       不完整的订单
     * @param wxPaymentId     微信支付订单号
     * @param wxPaymentAmount 支付钱数
     * @param userId          userId
     * @param level           要到达的等级
     * @return 升级结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> moneyUpgradeMember(OrderForm orderForm, String wxPaymentId, BigDecimal wxPaymentAmount, String userId, String level) {
        //继续完善订单字段
        //引入订单工具
        //订单具体牵扯受益详情
        StringBuilder orderDetail = new StringBuilder();
        //获取会员信息
        //当前会员信息
        SysUser correctUser = getById(userId);
        //获取上级
        SysUser parentUser = getById(correctUser.getParentId());

        BigDecimal parentRate;
        BigDecimal grandParentRate;
        SystemSet systemSet;
        systemSet = systemSetService.getOne(new QueryWrapper<SystemSet>().eq(SystemSet.COL_COMPANY_ID, ConstantPool.PLATFORM_COMPANY_ID));
        //如果有直接推荐人
        if (parentUser != null) {
            parentRate = RateJudge.getMemberUpgradeRate(systemSet, parentUser, true);
            BigDecimal parentMoneyDetail = wxPaymentAmount.multiply(parentRate);
            String parentDetail = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "会员直推", parentMoneyDetail, BigDecimal.ZERO);
            capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.MONEY_UPGRADE_DIRECT, BigDecimal.ZERO, parentMoneyDetail, orderForm.getId(), parentDetail);
            orderDetail.append(parentDetail).append("\n");
            //获取上上级
            SysUser grandParentUser = getById(parentUser.getParentId());
            if (grandParentUser != null) {
                grandParentRate = RateJudge.getMemberUpgradeRate(systemSet, grandParentUser, false);
                BigDecimal grandParentMoneyDetail = wxPaymentAmount.multiply(grandParentRate);
                String grandParentDetail = DetailTemplate.getDetail(grandParentUser.getName(), grandParentUser.getId(), "会员间推", grandParentMoneyDetail, BigDecimal.ZERO);
                capitalUtils.addCapital(correctUser, grandParentUser.getId(), ConstantPool.MONEY_UPGRADE_INDIRECT, BigDecimal.ZERO, grandParentMoneyDetail, orderForm.getId(), grandParentDetail);
                orderDetail.append(grandParentDetail).append("\n");
            }
        }
        if (StringUtils.isEmpty(orderDetail.toString())) {
            orderDetail.append("没有人获得收益");
        }
        orderForm.setOderDetail(orderDetail.toString());
        orderForm.setWxPaymentId(wxPaymentId);
        orderForm.setWxPaymentAmount(wxPaymentAmount);
        orderForm.setAuditState(Integer.parseInt(ConstantPool.ORDER_FORM_REVIEW_SUCCESS));
        capitalUtils.addCapital(correctUser, correctUser.getId(), ConstantPool.MEMBER_UPGRADE, BigDecimal.ZERO, wxPaymentAmount.negate(), orderForm.getId(), "会员升级");
        orderForm.insertOrUpdate();
        //更新会员等级
        correctUser.setMemberLevel(Integer.parseInt(level));
        correctUser.updateById();
        //更新在线token
        updateOnlineToken(correctUser);
        return Response.success();
    }

    /**
     * 盟主充值升级 假定已经支付成功
     *
     * @param orderForm       不完整的订单
     * @param wxPaymentId     微信支付订单号
     * @param wxPaymentAmount 支付钱数
     * @param userId          userId
     * @param level           要到达的等级
     * @return 升级结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> moneyUpgradeCompany(OrderForm orderForm, String wxPaymentId, BigDecimal wxPaymentAmount, String userId, String level) {
        //初始化orderDetail
        StringBuilder orderDetail = new StringBuilder();
        //判断是否第一次升级盟主
        SysUser correctUser = getById(userId);
        //取roleId判断是否第一次升级
        String correctUserRoleId = correctUser.getRoleId();
        //用户字段更新
        correctUser.setRoleId(ConstantPool.COMPANY_ROLE_ID);
        correctUser.setCompanyLevel(Integer.parseInt(level));
        correctUser.setRoleName("盟主");
        correctUser.updateById();
        //如果是第一次升级为盟主
        boolean isFirst = false;
        if (ConstantPool.MEMBER_ROLE_ID.equals(correctUserRoleId)) {
            isFirst = true;
            //复制平台所有的商品价格表
            List<Card> cards = cardService.list(new QueryWrapper<Card>().eq(SystemSet.COL_COMPANY_ID, ConstantPool.PLATFORM_COMPANY_ID));
            List<Card> newCards = new ArrayList<>(cards.size());
            cards.forEach(card -> {
                card.setCompanyId(correctUser.getId());
                card.setId(UUIDUtils.generate());
                card.setCreatedTime(DateFormatUtils.getCurrentDate());
                card.setCreator(correctUser.getName());
                card.setCreatorId(correctUser.getId());
                card.setLastUpdater(correctUser.getName());
                card.setLastUpdateId(correctUser.getId());
                card.setLastUpdateTime(DateFormatUtils.getCurrentDate());
                newCards.add(card);
            });
            cardService.saveBatch(newCards);
            //检索所有他的用户进行修改
            List<SysUser> allChild = findAllChildById(correctUser.getId());
            List<SysUser> newChild = new ArrayList<>(allChild.size());
            allChild.forEach(sysUser -> {
                sysUser.setCompanyId(correctUser.getId());
                newChild.add(sysUser);
            });
            updateBatchById(newChild);
            //复制平台的所有文章
            List<Article> articles = articleService.list(new QueryWrapper<Article>().eq(Article.COL_COMPANY_ID, ConstantPool.PLATFORM_COMPANY_ID));
            List<Article> newArticles = new ArrayList<>(articles.size());
            articles.forEach(article -> {
                article.setCompanyId(correctUser.getId());
                article.setId(UUIDUtils.generate());
                article.setCreatedTime(DateFormatUtils.getCurrentDate());
                article.setCreator(correctUser.getName());
                article.setCreatorId(correctUser.getId());
                article.setLastUpdater(correctUser.getName());
                article.setLastUpdateId(correctUser.getId());
                article.setLastUpdateTime(DateFormatUtils.getCurrentDate());
                newArticles.add(article);
            });
            articleService.updateBatchById(newArticles);
            //分类
            List<Category> categories = categoryService.list(new QueryWrapper<Category>().eq(Article.COL_COMPANY_ID, ConstantPool.PLATFORM_COMPANY_ID));
            List<Category> newCategories = new ArrayList<>(categories.size());
            categories.forEach(category -> {
                category.setCompanyId(correctUser.getId());
                category.setId(UUIDUtils.generate());
                category.setCreatedTime(DateFormatUtils.getCurrentDate());
                category.setCreator(correctUser.getName());
                category.setCreatorId(correctUser.getId());
                category.setLastUpdater(correctUser.getName());
                category.setLastUpdateId(correctUser.getId());
                category.setLastUpdateTime(DateFormatUtils.getCurrentDate());
                newCategories.add(category);
            });
            categoryService.updateBatchById(newCategories);
            //轮播图
            List<Swiper> swipers = swiperService.list(new QueryWrapper<Swiper>().eq(Article.COL_COMPANY_ID, ConstantPool.PLATFORM_COMPANY_ID));
            List<Swiper> newSwipers = new ArrayList<>(swipers.size());
            swipers.forEach(swiper -> {
                swiper.setCompanyId(correctUser.getId());
                swiper.setId(UUIDUtils.generate());
                swiper.setCreatedTime(DateFormatUtils.getCurrentDate());
                swiper.setCreator(correctUser.getName());
                swiper.setCreatorId(correctUser.getId());
                swiper.setLastUpdater(correctUser.getName());
                swiper.setLastUpdateId(correctUser.getId());
                swiper.setLastUpdateTime(DateFormatUtils.getCurrentDate());
                newSwipers.add(swiper);
            });
            swiperService.updateBatchById(newSwipers);
            //公告
            List<Notice> notices = noticeService.list(new QueryWrapper<Notice>().eq("COMPANY_ID", ConstantPool.PLATFORM_COMPANY_ID));
            List<Notice> newNotices = new ArrayList<>(notices.size());
            notices.forEach(notice -> {
                notice.setCompanyId(correctUser.getId());
                notice.setId(UUIDUtils.generate());
                notice.setCreatedTime(DateFormatUtils.getCurrentDate());
                notice.setCreator(correctUser.getName());
                notice.setCreatorId(correctUser.getId());
                notice.setLastUpdater(correctUser.getName());
                notice.setLastUpdateId(correctUser.getId());
                notice.setLastUpdateTime(DateFormatUtils.getCurrentDate());
                newNotices.add(notice);
            });
            noticeService.updateBatchById(newNotices);
            //盟主表单初始化完成
        }
        //开始计算盟主升级收益
        //盟主升级奖 只奖励一个人
        //取自己的盟主设置 没有就返回平台
        BigDecimal rate;
        String correctUserCompanyId = correctUser.getCompanyId();
        if (!StringUtils.isEmpty(correctUserCompanyId)) {
            QueryWrapper<SystemSet> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SystemSet.COL_COMPANY_ID, correctUserCompanyId);
            SystemSet systemSet = systemSetService.getOne(queryWrapper);
            //取自己上级
            SysUser parentUser = getById(correctUser.getParentId());
            //直接推荐人是盟主才会有收益
            if (ConstantPool.COMPANY_ROLE_ID.equals(parentUser.getRoleId())) {
                rate = RateJudge.getCompanyUpgradeRate(systemSet, parentUser, correctUser, isFirst);
                //如果是第一次直接给推荐佣金
                if (isFirst) {
                    String capitalDetail = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "第一次推荐盟主", rate, BigDecimal.ZERO);
                    //生成流水
                    capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.FIRST_RECOMMEND_COMPANY, BigDecimal.ZERO, rate, orderForm.getId(), capitalDetail);
                    orderDetail.append(capitalDetail).append("\n");
                } else {
                    //否则进行比例计算
                    BigDecimal recommendProfit = wxPaymentAmount.multiply(rate);
                    String capitalDetail = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "盟主二次升级", rate, BigDecimal.ZERO);
                    //生成流水
                    capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.TWICE_RECOMMEND_COMPANY, BigDecimal.ZERO, rate, orderForm.getId(), capitalDetail);
                    orderDetail.append(capitalDetail).append("\n");
                }
            }
        }
        if (StringUtils.isEmpty(orderDetail.toString())) {
            orderDetail.append("没有人获得收益");
        }

        //更新订单信息
        orderForm.setWxPaymentAmount(wxPaymentAmount);
        orderForm.setWxPaymentId(wxPaymentId);
        orderForm.setOderDetail(orderDetail.toString());
        orderForm.setAuditState(2);
        capitalUtils.addCapital(correctUser, correctUser.getId(), ConstantPool.COMPANY_UPGRADE, BigDecimal.ZERO, wxPaymentAmount.negate(), orderForm.getId(), "盟主升级");
        orderForm.insertOrUpdate();
        //更新在线token
        updateOnlineToken(correctUser);
        return Response.success();
    }

    /**
     * 核心算法 找出所有的下级
     *
     * @param all    临时数组
     * @param result 最终结果
     */
    private void findChild(List<SysUser> all, List<SysUser> result) {
        result.addAll(all);
        //别听编译器的 foreach算法会死循环
        for (int i = 0; i < all.size(); i++) {
            SysUser sysUser = all.get(i);
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SysUser.COL_PARENT_ID, sysUser.getId());
            findChild(list(queryWrapper), result);
        }
    }

    /**
     * 找出id的所有的下级
     *
     * @param id id
     * @return List<SysUser> 所有下级
     */
    private List<SysUser> findAllChildById(String id) {
        List<SysUser> all = new ArrayList<>();
        List<SysUser> result = new ArrayList<>();
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        all.add(sysUser);
        findChild(all, result);
        result.remove(0);
        return result;
    }

    /**
     * 检测推荐手机号是否存在以及所有信息
     *
     * @param phone 推荐人手机号码
     * @return 返回所有信息
     */
    private SysUser checkParent(String phone) {
        return sysUserDao.queryByInviteCodeOrPhoneNumber(phone);
    }

    /**
     * 检测手机号是否重复
     *
     * @param phone 注册人手机号码
     * @return 返回是否
     */
    private Map<String, Object> checkPhone(String phone) {
        SysUser sysUser = queryByAccount(phone);
        if (sysUser == null) {
            return Response.success();
        } else {
            return Response.fail(ErrorItem.SYSTEM_ACCOUNT_IS_USED);
        }
    }

    /**
     * 根据token获取直接下级
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    @Override
    public List<SysUser> getLowLevelByPage(String token, Integer currentPage, Integer pageSize) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        SysUser sysUser = getById(Objects.requireNonNull(tokenObj).getUserId());
        List<SysUser> list = list(new QueryWrapper<SysUser>().eq(SysUser.COL_PARENT_ID, sysUser.getId()));
        ListPageUtil<SysUser> listPageUtil = new ListPageUtil<>();
        if (currentPage == null || pageSize == null) {
            return list;
        } else {
            return listPageUtil.startPage(list, currentPage, pageSize);
        }
    }

    /**
     * 根据token获取直接下级
     *
     * @param token token
     * @return list
     */
    public List<SysUser> getLowLevelByPage(String token) {
        return getLowLevelByPage(token, null, null);
    }

    /**
     * 根据token获取间接下级
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    @Override
    public List<SysUser> getSubLowLevelByPage(String token, Integer currentPage, Integer pageSize) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        SysUser sysUser = getById(Objects.requireNonNull(tokenObj).getUserId());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysUser.COL_PARENT_ID, sysUser.getId());
        List<SysUser> result = new ArrayList<>();
        //一级下级
        List<SysUser> list = list(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            SysUser sysUser1 = list.get(i);
            QueryWrapper<SysUser> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq(SysUser.COL_PARENT_ID, sysUser1.getId());
            result.addAll(list(queryWrapper1));
        }
        ListPageUtil<SysUser> listPageUtil = new ListPageUtil<>();
        if (currentPage == null || pageSize == null) {
            return result;
        } else {
            return listPageUtil.startPage(result, currentPage, pageSize);
        }
    }

    /**
     * 通过token获取所有间接下级
     *
     * @param token token
     * @return list
     */
    public List<SysUser> getSubLowLevelByPage(String token) {
        return getSubLowLevelByPage(token, null, null);
    }

    /**
     * 用户升级微信回调接口
     *
     * @param pcbrs 微信支付结果
     */
    @Override
    public void memberUpgradeWxCallback(TreeMap<String, String> pcbrs) {
        //商户订单号
        String orderId = pcbrs.get("out_trade_no");
        OrderForm orderForm = orderFormService.getById(orderId);
        //微信订单号
        String wxOrderId = pcbrs.get("transaction_id");
        //微信支付金额
        String wxPaymentAmount = pcbrs.get("cash_fee");
        String attach = pcbrs.get("attach");
        String targetLevel = attach.substring(attach.length() - 1);
        String userId = orderForm.getUserId();
        moneyUpgradeMember(orderForm, wxOrderId, new BigDecimal(wxPaymentAmount).divide(new BigDecimal("100")), userId, targetLevel);
    }

    @Override
    public void companyUpgradeWxCallback(TreeMap<String, String> pcbrs) {
        //商户订单号
        String orderId = pcbrs.get("out_trade_no");
        OrderForm orderForm = orderFormService.getById(orderId);
        //微信订单号
        String wxOrderId = pcbrs.get("transaction_id");
        //微信支付金额
        String wxPaymentAmount = pcbrs.get("cash_fee");
        String attach = pcbrs.get("attach");
        String userId = orderForm.getUserId();
        String targetLevel = attach.substring(attach.length() - 1);
        moneyUpgradeCompany(orderForm, wxOrderId, new BigDecimal(wxPaymentAmount).divide(new BigDecimal("100")), userId, targetLevel);
    }

    /**
     * 重置密码
     *
     * @param userId   用户ID
     * @param password 新密码
     * @return 结果
     */
    @Override
    public Map<String, Object> resetPass(String userId, String password) {
        SysUser user = getOne(new QueryWrapper<SysUser>().eq(SysUser.COL_ID, userId));
        user.setPassword(CipherUtils.passwordSalt(password));
        user.updateById();
        return Response.success();
    }

    /**
     * 获取我的推荐码
     *
     * @param token token
     * @return 二维码地址以及 推荐码
     */
    @Override
    public Map<String, Object> getMyQrCode(String token) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        SysUser sysUser = getById(Objects.requireNonNull(tokenObj).getUserId());
        Map<String, Object> result = Response.success(sysUser.getInviteCode());
        String fileDir = UploadUtils.PATH + "qrCode/" + sysUser.getId() + "/";
        File file = new File(fileDir + sysUser.getId() + ".JPG");
        if (!file.exists()) {
            try {
                QRCodeUtils.encode(WxUtils.QR_CODE_URL + sysUser.getInviteCode(), fileDir, sysUser.getId());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String base64 = ImageUtils.getImgStr(fileDir + sysUser.getId() + ".JPG");
        result.put("qrCode", "data:image/jpeg;base64," + base64);

        return result;
    }


    /**
     * 创建升级订单
     *
     * @param order       订单对象
     * @param targetLevel 目标等级
     * @param type        1会员 2盟主
     * @return 订单对象
     */
    @Override
    public OrderForm createdUpGrade(OrderForm order, String targetLevel, Integer type) {

        SysUser user = sysUserDao.queryById(order.getUserId());
        Integer targetMember = Integer.valueOf(targetLevel);
        SystemSet systemSet = (SystemSet) systemSetService.queryById("1").get("data");
        if (type == 1) {
            Integer thisMember = user.getMemberLevel();
            if (targetMember.compareTo(thisMember) <= 0) {
                order.setAuditState(4);
                order.setAuditContent("无法购买低等级的会员");
            } else {

                BigDecimal level2 = systemSet.getMemberUpgradeGoldPrice();
                BigDecimal level3 = systemSet.getMemberUpgradeDiamondPrice();
                BigDecimal wxPaymentAmount;
                if (thisMember == 1) {
                    wxPaymentAmount = targetMember == 2 ? level2 : level3;
                    //设置为0即为尚未付款
                    order.setAuditState(0);
                    order.setWxPaymentAmount(wxPaymentAmount);
                } else {
                    wxPaymentAmount = level3.subtract(level2);
                    //设置为0即为尚未付款
                    order.setAuditState(0);
                    order.setWxPaymentAmount(wxPaymentAmount);
                }
            }
        } else {
            Integer thisMember = user.getCompanyLevel();
            if (targetMember.compareTo(thisMember) <= 0) {
                order.setAuditState(4);
                order.setAuditContent("无法购买低等级的盟主");
            } else {
                BigDecimal level1 = systemSet.getCompanyNormalUpgradePrice();
                BigDecimal level2 = systemSet.getCompanyAdvancedUpgradePrice();
                BigDecimal level3 = systemSet.getCompanySuperUpgradePrice();
                BigDecimal wxPaymentAmount;
                if (thisMember != 1 && thisMember != 2 && thisMember != 3) {
                    wxPaymentAmount = targetMember == 1 ? level1 : targetMember == 2 ? level2 : level3;
                    //设置为0即为尚未付款
                    order.setAuditState(0);
                    order.setWxPaymentAmount(wxPaymentAmount);
                } else {
                    BigDecimal payed = thisMember == 1 ? level1 : level2;
                    wxPaymentAmount = (targetMember == 2 ? level2 : level3).subtract(payed);
                    //设置为0即为尚未付款
                    order.setAuditState(0);
                    order.setWxPaymentAmount(wxPaymentAmount);
                }
            }
        }
        return order;
    }
}


