package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jx.entity.Card;
import com.jx.entity.OrderForm;
import com.jx.entity.SysUser;
import com.jx.entity.SystemSet;
import com.jx.service.*;
import com.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/27 9:47
 */
@Service
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {
    private final CapitalUtils capitalUtils = new CapitalUtils();
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SystemSetService systemSetService;
    @Resource
    private CardService cardService;
    @Resource
    private BankService bankService;
    @Resource
    private OrderFormService orderFormService;

    /**
     * 积分兑换分成
     *
     * @param orderId 订单ID
     * @return 兑换结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> exchangePoint(String orderId) {
        log.info("orderId" + orderId);
        BigDecimal pointCount = BigDecimal.ONE;
        OrderForm orderForm = orderFormService.getById(orderId);
        //初始化orderDetail
        StringBuilder orderDetail = new StringBuilder();
        //获取用户信息
        SysUser correctUser = sysUserService.getById(orderForm.getUserId());
        Card cardInfo = cardService.getById(orderForm.getCardId());
        SystemSet systemSet = systemSetService.getOne(new QueryWrapper<SystemSet>().eq(SystemSet.COL_COMPANY_ID, ConstantPool.PLATFORM_COMPANY_ID));
        //判断自己是不是盟主
        String selfCompanyId = correctUser.getCompanyId();
        if (ConstantPool.COMPANY_ROLE_ID.equals(correctUser.getRoleId())) {
            //如果自己是盟主
            //获取自己定义的价格
            //计算自己的兑换收益
            BigDecimal companyExchangeProfit = cardInfo.getMemberDiamond().setScale(2, BigDecimal.ROUND_DOWN).multiply(pointCount);
            orderForm.setGetMoney(companyExchangeProfit);
            orderForm.setUnitPrice(cardInfo.getMemberDiamond());
            //生成流水
            String companyExchangeMessage = DetailTemplate.getDetail(correctUser.getName(), correctUser.getId(), "盟主直接兑换", companyExchangeProfit, BigDecimal.ZERO);
            capitalUtils.addCapital(correctUser, correctUser.getId(), ConstantPool.POINT_EXCHANGE, cardInfo.getLimitLine().multiply(pointCount).negate(), companyExchangeProfit, orderForm.getId(), companyExchangeMessage);
            orderDetail.append(companyExchangeMessage).append("\n");
            //计算自己的盟主收益
            //拿到平台的底价
            BigDecimal platformFloorPrice = cardInfo.getPlatformFloorPrice();
            //拿到自己的底价
            BigDecimal selfFloorPrice = RateJudge.getCompanyFloorPrice(correctUser, cardInfo);
            //盟主永久收益
            BigDecimal companyForeverRate = RateJudge.getCompanyForeverRate(correctUser, systemSet);
            BigDecimal selfAndPlatformDiff = platformFloorPrice.subtract(selfFloorPrice).multiply(pointCount);
            BigDecimal companyForeverProfit = companyForeverRate.multiply(selfAndPlatformDiff).setScale(2, BigDecimal.ROUND_DOWN);
            //生成流水
            String companyForeverMessage = DetailTemplate.getDetail(correctUser.getName(), correctUser.getId(), "盟主永久收益", companyForeverProfit, BigDecimal.ZERO);
            capitalUtils.addCapital(correctUser, correctUser.getId(), ConstantPool.COMPANY_FOREVER_PROFIT, BigDecimal.ZERO, companyForeverProfit, orderForm.getId(), companyForeverMessage);
            orderDetail.append(companyForeverMessage).append("\n");
            //盟主差价收益
            BigDecimal companyPriceDiffProfit = pointCount.multiply(selfFloorPrice.subtract(cardInfo.getMemberDiamond())).setScale(2, BigDecimal.ROUND_DOWN);
            //生成流水
            String companyPriceDiffMessage = DetailTemplate.getDetail(correctUser.getName(), correctUser.getId(), "盟主差价收益", companyPriceDiffProfit, BigDecimal.ZERO);
            capitalUtils.addCapital(correctUser, correctUser.getId(), ConstantPool.COMPANY_PRICE_DIFFERENT_PROFIT, BigDecimal.ZERO, companyPriceDiffProfit, orderForm.getId(), companyPriceDiffMessage);
            orderDetail.append(companyPriceDiffMessage).append("\n");
            //盟主团队奖收益
            BigDecimal companyTeamRate = RateJudge.getCompanyTeamRate(correctUser, systemSet);
            BigDecimal companyTeamProfit = selfAndPlatformDiff.multiply(companyTeamRate).setScale(2, BigDecimal.ROUND_DOWN);
            //生成流水
            String companyTeamProfitMessage = DetailTemplate.getDetail(correctUser.getName(), correctUser.getId(), "盟主团队奖收益", companyTeamProfit, BigDecimal.ZERO);
            capitalUtils.addCapital(correctUser, correctUser.getId(), ConstantPool.COMPANY_TEAM_PROFIT, BigDecimal.ZERO, companyTeamProfit, orderForm.getId(), companyTeamProfitMessage);
            orderDetail.append(companyTeamProfitMessage).append("\n");
            //总收益
            BigDecimal allProfit = companyExchangeProfit.add(companyForeverProfit).add(companyPriceDiffProfit).add(companyTeamProfit);
            //更新自己的余额
            correctUser.setBalance(correctUser.getBalance().add(allProfit));
            correctUser.setCumulativeProfit(correctUser.getCumulativePoint().add(allProfit));
            correctUser.setCumulativePoint(correctUser.getCumulativePoint().add(pointCount));
            correctUser.updateById();
            //查同级兑换奖
            //自己是盟主 上级必须是盟主 且 等级大于等于自己 否则没有同级兑换奖
            SysUser sysUser;
            //上级ID不为空 盟主ID不为空
            if (!StringUtils.isEmpty(correctUser.getParentId(), correctUser.getCompanyId())) {
                SysUser parentUser = sysUserService.getById(correctUser.getParentId());
                if (ConstantPool.COMPANY_ROLE_ID.equals(parentUser.getRoleId()) && parentUser.getCompanyLevel() >= correctUser.getCompanyLevel()) {
                    //上级获得同级兑换奖
                    //查同级兑换奖比例
                    BigDecimal companyPeerExchangeRate = RateJudge.getCompanyPeerExchangeRate(parentUser, systemSet);
                    //计算同级兑换收益
                    BigDecimal companyPeerExchangeProfit = selfAndPlatformDiff.multiply(companyPeerExchangeRate).setScale(2, BigDecimal.ROUND_DOWN);
                    //生成流水
                    String companyPeerExchangeMessage = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "盟主同级兑换", companyPeerExchangeProfit, BigDecimal.ZERO);
                    capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.COMPANY_PEER_EXCHANGE_PROFIT, BigDecimal.ZERO, companyPeerExchangeProfit, orderForm.getId(), companyPeerExchangeMessage);
                    orderDetail.append(companyPeerExchangeMessage).append("\n");
                    //
                    parentUser.setBalance(parentUser.getBalance().add(companyPeerExchangeProfit));
                    parentUser.setCumulativeProfit(parentUser.getCumulativeProfit().add(companyPeerExchangeProfit));
                    parentUser.updateById();
                }
            }
        } else {
            //如果自己不是盟主
            //判断是否有盟主ID
            if (!StringUtils.isEmpty(selfCompanyId)) {
                //如果有盟主ID 查询盟主的价格 查询自己会员等级
                //计算兑换人应得利益
                BigDecimal exchangeRate = RateJudge.getExchangeRate(cardInfo, correctUser);
                BigDecimal correctExchangeProfit = pointCount.multiply(exchangeRate).setScale(2, BigDecimal.ROUND_DOWN);
                orderForm.setGetMoney(correctExchangeProfit);
                orderForm.setUnitPrice(exchangeRate);
                correctUser.setBalance(correctUser.getBalance().add(correctExchangeProfit));
                correctUser.setCumulativeProfit(correctUser.getCumulativePoint().add(correctExchangeProfit));
                correctUser.setCumulativePoint(correctUser.getCumulativePoint().add(cardInfo.getLimitLine()));
                correctUser.updateById();
                //判断上级
                SysUser parentUser = sysUserService.getById(correctUser.getParentId());
                if (parentUser != null) {
                    //根据上级等级获得直推收益
                    //如果上级是盟主
                    if (ConstantPool.COMPANY_ROLE_ID.equals(String.valueOf(parentUser.getRoleId()))) {
                        //上级是盟主 盟主永久收益 盟主差价收益 盟主团队奖
                        //拿到平台的底价
                        BigDecimal platformFloorPrice = cardInfo.getPlatformFloorPrice();
                        //拿到自己的底价
                        BigDecimal selfFloorPrice;
                        if (ConstantPool.MEMBER_NORMAL_LEVEL.equals(String.valueOf(correctUser.getMemberLevel()))) {
                            selfFloorPrice = exchangeRate;
                        } else {
                            selfFloorPrice = RateJudge.getCompanyFloorPrice(parentUser, cardInfo);
                        }
                        //盟主永久收益
                        BigDecimal companyForeverRate = RateJudge.getCompanyForeverRate(parentUser, systemSet);
                        BigDecimal selfAndPlatformDiff = platformFloorPrice.subtract(selfFloorPrice).multiply(pointCount);
                        BigDecimal companyForeverProfit = companyForeverRate.multiply(selfAndPlatformDiff).setScale(2, BigDecimal.ROUND_DOWN);
                        //生成流水
                        String companyForeverMessage = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "盟主永久收益", companyForeverProfit, BigDecimal.ZERO);
                        capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.COMPANY_FOREVER_PROFIT, BigDecimal.ZERO, companyForeverProfit, orderForm.getId(), companyForeverMessage);
                        orderDetail.append(companyForeverMessage).append("\n");
                        //盟主差价收益
                        BigDecimal companyPriceDiffProfit = BigDecimal.ZERO;
                        if (!ConstantPool.MEMBER_NORMAL_LEVEL.equals(String.valueOf(correctUser.getMemberLevel()))) {
                            companyPriceDiffProfit = pointCount.multiply(selfFloorPrice.subtract(exchangeRate)).setScale(2, BigDecimal.ROUND_DOWN);
                            //生成流水
                            String companyPriceDiffMessage = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "盟主差价收益", companyPriceDiffProfit, BigDecimal.ZERO);
                            capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.COMPANY_PRICE_DIFFERENT_PROFIT, BigDecimal.ZERO, companyPriceDiffProfit, orderForm.getId(), companyPriceDiffMessage);
                            orderDetail.append(companyPriceDiffMessage).append("\n");
                        }
                        //盟主团队奖收益
                        BigDecimal companyTeamRate = RateJudge.getCompanyTeamRate(parentUser, systemSet);
                        BigDecimal companyTeamProfit = selfAndPlatformDiff.multiply(companyTeamRate).setScale(2, BigDecimal.ROUND_DOWN);
                        //生成流水
                        String companyTeamProfitMessage = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "盟主团队奖收益", companyTeamProfit, BigDecimal.ZERO);
                        capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.COMPANY_TEAM_PROFIT, BigDecimal.ZERO, companyTeamProfit, orderForm.getId(), companyTeamProfitMessage);
                        orderDetail.append(companyTeamProfitMessage).append("\n");
                        BigDecimal allProfit = companyForeverProfit.add(companyPriceDiffProfit).add(companyTeamProfit);
                        parentUser.setCumulativeProfit(parentUser.getCumulativeProfit().add(allProfit));
                        parentUser.setBalance(parentUser.getBalance().add(allProfit));
                        parentUser.updateById();
                        //上上级是盟主且等级大于等于上级盟主 有同级兑换奖
                        // 否则盟主没有上级
                        //上级ID不为空 盟主ID不为空
                        if (!StringUtils.isEmpty(parentUser.getParentId())) {
                            SysUser grandparentUser = sysUserService.getById(parentUser.getParentId());
                            if (ConstantPool.COMPANY_ROLE_ID.equals(grandparentUser.getRoleId()) && grandparentUser.getCompanyLevel() >= parentUser.getCompanyLevel()) {
                                //上级获得同级兑换奖
                                //查同级兑换奖比例
                                BigDecimal companyPeerExchangeRate = RateJudge.getCompanyPeerExchangeRate(grandparentUser, systemSet);
                                //计算同级兑换收益
                                BigDecimal companyPeerExchangeProfit = selfAndPlatformDiff.multiply(companyPeerExchangeRate).setScale(2, BigDecimal.ROUND_DOWN);
                                //生成流水
                                String companyPeerExchangeMessage = DetailTemplate.getDetail(grandparentUser.getName(), grandparentUser.getId(), "盟主同级兑换", companyPeerExchangeProfit, BigDecimal.ZERO);
                                capitalUtils.addCapital(correctUser, grandparentUser.getId(), ConstantPool.COMPANY_PEER_EXCHANGE_PROFIT, BigDecimal.ZERO, companyPeerExchangeProfit, orderForm.getId(), companyPeerExchangeMessage);
                                orderDetail.append(companyPeerExchangeMessage).append("\n");
                                grandparentUser.setBalance(grandparentUser.getBalance().add(companyPeerExchangeProfit));
                                grandparentUser.setCumulativeProfit(grandparentUser.getCumulativeProfit().add(companyPeerExchangeProfit));
                                grandparentUser.updateById();
                            }
                        }
                    } else {
                        //上级不是盟主
                        //获取会员直推奖励比例
                        BigDecimal parentDirectRecommendRate = RateJudge.exchangeRecommendRate(systemSet, parentUser, true);
                        //计算会员直推奖兑换
                        //(平台底价-兑换价格)*兑换数量*直推比例
                        BigDecimal platformFloorPrice = cardInfo.getPlatformFloorPrice();
                        BigDecimal parentDirectRecommendProfit = parentDirectRecommendRate.multiply(platformFloorPrice.subtract(exchangeRate).multiply(pointCount)).setScale(2, BigDecimal.ROUND_DOWN);
                        //生成流水
                        String parentDirectRecommendMessage = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "会员直接推荐", parentDirectRecommendProfit, BigDecimal.ZERO);
                        capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.MEMBER_EXCHANGE_RECOMMEND_DIRECT, BigDecimal.ZERO, parentDirectRecommendProfit, orderForm.getId(), parentDirectRecommendMessage);
                        orderDetail.append(parentDirectRecommendMessage).append("\n");
                        parentUser.setCumulativeProfit(parentUser.getCumulativeProfit().add(parentDirectRecommendProfit));
                        parentUser.setBalance(parentUser.getBalance().add(parentDirectRecommendProfit));
                        parentUser.updateById();
                        //判断是否有上上级
                        if (!StringUtils.isEmpty(parentUser.getParentId())) {
                            SysUser grandParentUser = sysUserService.getById(parentUser.getParentId());
                            //判断上上级是不是盟主
                            if (ConstantPool.COMPANY_ROLE_ID.equals(grandParentUser.getRoleId())) {
                                //上上级是盟主
                                //计算盟主的三大项收益
                                //拿到自己的底价
                                BigDecimal selfFloorPrice;
                                if (ConstantPool.MEMBER_NORMAL_LEVEL.equals(String.valueOf(correctUser.getMemberLevel()))) {
                                    selfFloorPrice = exchangeRate;
                                } else {
                                    selfFloorPrice = RateJudge.getCompanyFloorPrice(grandParentUser, cardInfo);
                                }
                                //盟主永久收益
                                BigDecimal companyForeverRate = RateJudge.getCompanyForeverRate(grandParentUser, systemSet);
                                BigDecimal selfAndPlatformDiff = platformFloorPrice.subtract(selfFloorPrice).multiply(pointCount);
                                BigDecimal companyForeverProfit = companyForeverRate.multiply(selfAndPlatformDiff).setScale(2, BigDecimal.ROUND_DOWN);
                                //生成流水
                                String companyForeverMessage = DetailTemplate.getDetail(grandParentUser.getName(), grandParentUser.getId(), "盟主永久收益", companyForeverProfit, BigDecimal.ZERO);
                                capitalUtils.addCapital(correctUser, grandParentUser.getId(), ConstantPool.COMPANY_FOREVER_PROFIT, BigDecimal.ZERO, companyForeverProfit, orderForm.getId(), companyForeverMessage);
                                orderDetail.append(companyForeverMessage).append("\n");
                                //盟主差价收益
                                BigDecimal companyPriceDiffProfit = BigDecimal.ZERO;
                                if (!ConstantPool.MEMBER_NORMAL_LEVEL.equals(String.valueOf(correctUser.getMemberLevel()))) {
                                    companyPriceDiffProfit = pointCount.multiply(selfFloorPrice.subtract(exchangeRate)).setScale(2, BigDecimal.ROUND_DOWN);
                                    //生成流水
                                    String companyPriceDiffMessage = DetailTemplate.getDetail(grandParentUser.getName(), grandParentUser.getId(), "盟主差价收益", companyPriceDiffProfit, BigDecimal.ZERO);
                                    capitalUtils.addCapital(correctUser, grandParentUser.getId(), ConstantPool.COMPANY_PRICE_DIFFERENT_PROFIT, BigDecimal.ZERO, companyPriceDiffProfit, orderForm.getId(), companyPriceDiffMessage);
                                    orderDetail.append(companyPriceDiffMessage).append("\n");
                                }
                                //盟主团队奖收益
                                BigDecimal companyTeamRate = RateJudge.getCompanyTeamRate(grandParentUser, systemSet);
                                BigDecimal companyTeamProfit = selfAndPlatformDiff.multiply(companyTeamRate).setScale(2, BigDecimal.ROUND_DOWN);
                                //生成流水
                                String companyTeamProfitMessage = DetailTemplate.getDetail(grandParentUser.getName(), grandParentUser.getId(), "盟主团队奖收益", companyTeamProfit, BigDecimal.ZERO);
                                capitalUtils.addCapital(correctUser, grandParentUser.getId(), ConstantPool.COMPANY_TEAM_PROFIT, BigDecimal.ZERO, companyTeamProfit, orderForm.getId(), companyTeamProfitMessage);
                                orderDetail.append(companyTeamProfitMessage).append("\n");
                                BigDecimal allProfit = companyForeverProfit.add(companyPriceDiffProfit).add(companyTeamProfit);
                                grandParentUser.setBalance(grandParentUser.getBalance().add(allProfit));
                                grandParentUser.setCumulativeProfit(grandParentUser.getCumulativeProfit().add(allProfit));
                            } else {
                                //上上级不是盟主
                                //获取会员间推奖励比例
                                BigDecimal grandParentIndirectRecommendRate = RateJudge.exchangeRecommendRate(systemSet, grandParentUser, false);
                                //会员间推收益计算
                                //(平台底价-兑换价格)*兑换数量*直推比例
                                BigDecimal grandParentIndirectRecommendProfit = grandParentIndirectRecommendRate.multiply(platformFloorPrice.subtract(exchangeRate).multiply(pointCount)).setScale(2, BigDecimal.ROUND_DOWN);
                                //生成流水
                                String grandParentDirectRecommendMessage = DetailTemplate.getDetail(grandParentUser.getName(), grandParentUser.getId(), "会员间接推荐", grandParentIndirectRecommendProfit, BigDecimal.ZERO);
                                capitalUtils.addCapital(correctUser, grandParentUser.getId(), ConstantPool.MEMBER_EXCHANGE_RECOMMEND_INDIRECT, BigDecimal.ZERO, grandParentIndirectRecommendProfit, orderForm.getId(), grandParentDirectRecommendMessage);
                                orderDetail.append(grandParentDirectRecommendMessage).append("\n");
                                grandParentUser.setCumulativeProfit(grandParentUser.getCumulativeProfit().add(grandParentIndirectRecommendProfit));
                                grandParentUser.setBalance(grandParentUser.getBalance().add(grandParentIndirectRecommendProfit));
                                grandParentUser.updateById();
                                //给盟主ID计算三大项收益
                                SysUser companyUser = sysUserService.getById(correctUser.getCompanyId());
                                BigDecimal selfFloorPrice;
                                if (ConstantPool.MEMBER_NORMAL_LEVEL.equals(String.valueOf(correctUser.getMemberLevel()))) {
                                    selfFloorPrice = exchangeRate;
                                } else {
                                    selfFloorPrice = RateJudge.getCompanyFloorPrice(companyUser, cardInfo);
                                }

                                //盟主永久收益
                                BigDecimal companyForeverRate = RateJudge.getCompanyForeverRate(companyUser, systemSet);
                                BigDecimal selfAndPlatformDiff = platformFloorPrice.subtract(selfFloorPrice).multiply(pointCount);
                                BigDecimal companyForeverProfit = companyForeverRate.multiply(selfAndPlatformDiff).setScale(2, BigDecimal.ROUND_DOWN);
                                //生成流水
                                String companyForeverMessage = DetailTemplate.getDetail(companyUser.getName(), companyUser.getId(), "盟主永久收益", companyForeverProfit, BigDecimal.ZERO);
                                capitalUtils.addCapital(correctUser, companyUser.getId(), ConstantPool.COMPANY_FOREVER_PROFIT, BigDecimal.ZERO, companyForeverProfit, orderForm.getId(), companyForeverMessage);
                                orderDetail.append(companyForeverMessage).append("\n");
                                //盟主差价收益
                                BigDecimal companyPriceDiffProfit = BigDecimal.ZERO;
                                if (!ConstantPool.MEMBER_NORMAL_LEVEL.equals(String.valueOf(correctUser.getMemberLevel()))) {
                                    companyPriceDiffProfit = pointCount.multiply(selfFloorPrice.subtract(exchangeRate)).setScale(2, BigDecimal.ROUND_DOWN);
                                    //生成流水
                                    String companyPriceDiffMessage = DetailTemplate.getDetail(companyUser.getName(), companyUser.getId(), "盟主差价收益", companyPriceDiffProfit, BigDecimal.ZERO);
                                    capitalUtils.addCapital(correctUser, companyUser.getId(), ConstantPool.COMPANY_PRICE_DIFFERENT_PROFIT, BigDecimal.ZERO, companyPriceDiffProfit, orderForm.getId(), companyPriceDiffMessage);
                                    orderDetail.append(companyPriceDiffMessage).append("\n");
                                }
                                //盟主团队奖收益
                                BigDecimal companyTeamRate = RateJudge.getCompanyTeamRate(companyUser, systemSet);
                                BigDecimal companyTeamProfit = selfAndPlatformDiff.multiply(companyTeamRate).setScale(2, BigDecimal.ROUND_DOWN);
                                //生成流水
                                String companyTeamProfitMessage = DetailTemplate.getDetail(companyUser.getName(), companyUser.getId(), "盟主团队奖收益", companyTeamProfit, BigDecimal.ZERO);
                                capitalUtils.addCapital(correctUser, companyUser.getId(), ConstantPool.COMPANY_TEAM_PROFIT, BigDecimal.ZERO, companyTeamProfit, orderForm.getId(), companyTeamProfitMessage);
                                orderDetail.append(companyTeamProfitMessage).append("\n");
                                BigDecimal allProfit = companyForeverProfit.add(companyPriceDiffProfit).add(companyTeamProfit);
                                companyUser.setBalance(companyUser.getBalance().add(allProfit));
                                companyUser.setCumulativeProfit(companyUser.getCumulativeProfit().add(allProfit));
                                companyUser.updateById();
                            }
                        }
                    }
                }
            } else {
                //如果没有则获得平台给的价格
                //计算本人兑换收益
                BigDecimal exchangeRate = RateJudge.getExchangeRate(cardInfo, correctUser);
                BigDecimal exchangeProfit = exchangeRate.multiply(pointCount).setScale(2, BigDecimal.ROUND_DOWN);
                orderForm.setGetMoney(exchangeProfit);
                orderForm.setUnitPrice(exchangeRate);
                correctUser.setCumulativeProfit(correctUser.getCumulativePoint().add(exchangeProfit));
                correctUser.setBalance(correctUser.getBalance().add(exchangeProfit));
                correctUser.setCumulativePoint(correctUser.getCumulativePoint().add(cardInfo.getLimitLine()).multiply(pointCount));
                correctUser.updateById();
                //生成流水
                String correctExchangeMessage = DetailTemplate.getDetail(correctUser.getName(), correctUser.getId(), "会员直接兑换", exchangeProfit, BigDecimal.ZERO);
                capitalUtils.addCapital(correctUser, correctUser.getId(), ConstantPool.POINT_EXCHANGE, cardInfo.getLimitLine().multiply(pointCount).negate(), exchangeProfit, orderForm.getId(), correctExchangeMessage);
                orderDetail.append(correctExchangeMessage).append("\n");
                //有上级拿平台设置算上级直推
                if (!StringUtils.isEmpty(correctUser.getParentId())) {
                    SysUser parentUser = sysUserService.getById(correctUser.getParentId());
                    //获取会员直推奖励比例
                    BigDecimal parentDirectRecommendRate = RateJudge.exchangeRecommendRate(systemSet, parentUser, true);
                    //计算会员直推奖兑换
                    //(平台底价-兑换价格)*兑换数量*直推比例
                    BigDecimal platformFloorPrice = cardInfo.getPlatformFloorPrice();
                    BigDecimal parentDirectRecommendProfit = parentDirectRecommendRate.multiply(platformFloorPrice.subtract(exchangeRate).multiply(pointCount)).setScale(2, BigDecimal.ROUND_DOWN);
                    parentUser.setBalance(parentUser.getBalance().add(parentDirectRecommendProfit));
                    parentUser.setCumulativeProfit(parentUser.getCumulativeProfit().add(parentDirectRecommendProfit));
                    parentUser.updateById();
                    //生成流水
                    String parentDirectRecommendMessage = DetailTemplate.getDetail(parentUser.getName(), parentUser.getId(), "会员直接推荐", parentDirectRecommendProfit, BigDecimal.ZERO);
                    capitalUtils.addCapital(correctUser, parentUser.getId(), ConstantPool.MEMBER_EXCHANGE_RECOMMEND_DIRECT, BigDecimal.ZERO, parentDirectRecommendProfit, orderForm.getId(), parentDirectRecommendMessage);
                    orderDetail.append(parentDirectRecommendMessage).append("\n");
                    if (!StringUtils.isEmpty(parentUser.getParentId())) {
                        SysUser grandParentUser = sysUserService.getById(parentUser.getParentId());
                        //获取会员间推奖励比例
                        BigDecimal grandParentIndirectRecommendRate = RateJudge.exchangeRecommendRate(systemSet, grandParentUser, false);
                        //会员间推收益计算
                        //(平台底价-兑换价格)*兑换数量*直推比例
                        BigDecimal grandParentIndirectRecommendProfit = grandParentIndirectRecommendRate.multiply(platformFloorPrice.subtract(exchangeRate).multiply(pointCount)).setScale(2, BigDecimal.ROUND_DOWN);
                        //生成流水
                        String grandParentDirectRecommendMessage = DetailTemplate.getDetail(grandParentUser.getName(), grandParentUser.getId(), "会员直接推荐", grandParentIndirectRecommendProfit, BigDecimal.ZERO);
                        capitalUtils.addCapital(correctUser, grandParentUser.getId(), ConstantPool.MEMBER_EXCHANGE_RECOMMEND_INDIRECT, BigDecimal.ZERO, grandParentIndirectRecommendProfit, orderForm.getId(), grandParentDirectRecommendMessage);
                        orderDetail.append(grandParentDirectRecommendMessage).append("\n");
                        grandParentUser.setBalance(grandParentUser.getBalance().add(grandParentIndirectRecommendProfit));
                        grandParentUser.setCumulativeProfit(grandParentUser.getCumulativeProfit().add(grandParentIndirectRecommendProfit));
                        grandParentUser.updateById();
                    }
                }
            }
        }
        //更新插入订单
        orderForm.setOderDetail(orderDetail.toString());
        orderForm.setAuditState(Integer.parseInt(ConstantPool.ORDER_FORM_REVIEW_SUCCESS));
        orderForm.setSpendPoint(cardInfo.getLimitLine().multiply(pointCount));
        orderForm.insertOrUpdate();
        return Response.success();
    }

}
