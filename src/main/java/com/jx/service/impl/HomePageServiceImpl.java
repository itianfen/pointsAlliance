package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jx.entity.*;
import com.jx.service.*;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/20 10:08
 */
@Service
public class HomePageServiceImpl implements HomePageService {
    /**
     * 轮播图服务对象
     */
    @Resource
    private SwiperService swiperService;
    /**
     * 公告服务对象
     */
    @Resource
    private NoticeService noticeService;
    /**
     * 文章服务对象
     */
    @Resource
    private ArticleService articleService;
    /**
     * 银行服务对象
     */
    @Resource
    private BankService bankService;
    /**
     * 签到服务对象
     */
    @Resource
    private SignService signService;

    @Resource
    private NoticeTanService noticeTanService;

    @Override
    public Map<String, Object> getHome(String token) {
        Map<String, Object> result = Response.success();
        String companyId = ConstantPool.PLATFORM_COMPANY_ID;
        if (!StringUtils.isEmpty(token)) {
            //通过token获取对象
            Token tokenObj = Objects.requireNonNull(TokenUtils.getTokenObj(token));
            //获取盟主ID
            companyId = tokenObj.getCompanyId();
            boolean sign = signService.checkSign(token);
            result.put("sign", sign);
        }
        if (companyId == null || StringUtils.isEmpty(companyId)) {
            companyId = ConstantPool.PLATFORM_COMPANY_ID;
        }
        //轮播图列表封装
        QueryWrapper<Swiper> swiperQueryWrapperWrapper = new QueryWrapper<>();
        swiperQueryWrapperWrapper.eq(Article.COL_COMPANY_ID, companyId).eq(Article.COL_DELETED, 0);
        List<Swiper> swiperList = swiperService.list(swiperQueryWrapperWrapper);
        result.put("swiperList", swiperList == null || swiperList.isEmpty() ? new Swiper[0] : swiperList);
        //公告列表封装
        QueryWrapper<Notice> noticeQueryWrapperWrapper = new QueryWrapper<>();
        noticeQueryWrapperWrapper.eq(Article.COL_COMPANY_ID, companyId).eq(Article.COL_DELETED, 0).eq(Article.COL_SPARE1, 0);
        List<Notice> noticeList = noticeService.list(noticeQueryWrapperWrapper);
        result.put("noticeList", noticeList == null || noticeList.isEmpty() ? new Notice[0] : noticeList);
        //文章列表封装
        QueryWrapper<Article> articleQueryWrapper = new QueryWrapper<>();
        articleQueryWrapper.eq(Article.COL_COMPANY_ID, companyId).eq(Article.COL_DELETED, 0);
        List<Article> articleList = articleService.list(articleQueryWrapper);
        result.put("articleList", articleList == null || articleList.isEmpty() ? new Article[0] : articleList);
        //银行列表封装
        List<Bank> bankList = bankService.list(new QueryWrapper<Bank>().eq(Bank.COL_DELETED, 0).orderByAsc(Bank.COL_ORDER_ID));
        BatchListUtil<Bank> bankBatchListUtil = new BatchListUtil<>();
        result.put("bankList", bankList == null || bankList.isEmpty() ? new Bank[0] : bankBatchListUtil.batchToList(bankList, 10));
        return result;
    }

    @Override
    public Map<String, Object> tan(String token) {
        Map<String, Object> result = Response.success();
        Notice notice = noticeService.getOne(new QueryWrapper<Notice>().eq(Article.COL_SPARE1, "1").eq(Article.COL_DELETED, 0));
        if (!StringUtils.isEmpty(token)) {
            //通过token获取对象
            Token tokenObj = Objects.requireNonNull(TokenUtils.getTokenObj(token));
            //查询用户是否看过
            List<NoticeTan> list = noticeTanService.list(new QueryWrapper<NoticeTan>().eq(NoticeTan.COL_NOTICE_ID, notice.getId()).eq(NoticeTan.COL_USER_ID, tokenObj.getUserId()));
            if (list.isEmpty()) {
                result.put("tan", notice);
                NoticeTan noticeTan = new NoticeTan();
                noticeTan.setId(UUIDUtils.generate());
                noticeTan.setCreatedTime(DateFormatUtils.getCurrentDate());
                noticeTan.setCreator(tokenObj.getUserName());
                noticeTan.setCreatorId(tokenObj.getUserId());
                noticeTan.setLastUpdater(tokenObj.getUserName());
                noticeTan.setLastUpdateId(tokenObj.getUserId());
                noticeTan.setLastUpdateTime(DateFormatUtils.getCurrentDate());
                noticeTan.setUserId(tokenObj.getUserId());
                noticeTan.setNoticeId(notice.getId());
                noticeTan.insert();
            }
        } else {
            result.put("tan", notice);
        }
        return result;
    }
}
