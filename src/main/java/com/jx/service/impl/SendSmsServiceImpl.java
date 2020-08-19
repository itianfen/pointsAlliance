package com.jx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.SendSmsDao;
import com.jx.entity.SendSms;
import com.jx.entity.SysUser;
import com.jx.service.SendSmsService;
import com.jx.service.SysUserService;
import com.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yangyantong
 */
@Service
@Slf4j
public class SendSmsServiceImpl extends ServiceImpl<SendSmsDao, SendSms> implements SendSmsService {
    @Resource
    private SendSmsDao sendSmsDao;
    @Resource
    private SysUserService sysUserService;

    @Override
    public Map<String, Object> verificationCode(JSONObject params) {
        //手机号
        String phone = params.getString(ConstantPool.PHONE_NUMBER);
        //code码
        String code = params.getString(ConstantPool.PHONE_CODE);

        String state = params.getString(ConstantPool.PHONE_CODE_STATE);
        if (com.utils.StringUtils.isEmpty(phone, code, state)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        //当前时间
        String submitTime = DateFormatUtils.getCurrentDateString();
        if (StringUtils.isAnyBlank(phone, code, state)) {
            log.error(ErrorItem.MAST_PARAM_NOT_SET);
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }

        try {
            SendSms sendSms = new SendSms();
            SendSms correctSms = null;
            sendSms.setCode(code);
            sendSms.setPhone(phone);
            sendSms.setState(state);
            List<SendSms> sendSmsList = sendSmsDao.queryAll(sendSms);
            if (sendSmsList != null && sendSmsList.size() > 0) {
                correctSms = sendSmsList.get(0);
            } else {
                log.error("验证码[{}]错误", code);
                return Response.fail(ErrorItem.VALIDATE_CODE_ERROR);
            }
            String endTime = correctSms.getEndTime();
            if (DateUtil.compare_date(submitTime, endTime) > 0) {
                log.error("验证时间[{}]超时", endTime);
                return Response.fail(ErrorItem.VALIDATE_CODE_TIME_OUT);
            }
            return Response.success(ErrorItem.VALIDATE_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(ErrorItem.VALIDATE_CODE_ERROR);
            return Response.fail(ErrorItem.VALIDATE_CODE_ERROR);
        }
    }

    @Override
    public Map<String, Object> getPhoneCode(JSONObject params) {
        String phone = params.getString(ConstantPool.PHONE_NUMBER);
        String state = params.getString(ConstantPool.PHONE_CODE_STATE);
        if (com.utils.StringUtils.isEmpty(phone, state)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        if (state.equals(SmsCode.REGISTRATION.getState())) {
            List<SysUser> list = sysUserService.list(new QueryWrapper<SysUser>().eq(SysUser.COL_PHONE, phone));
            if (!list.isEmpty()) {
                return Response.fail(ErrorItem.SYSTEM_ACCOUNT_IS_USED);
            }
        }
        //状态1登录2注册3修改登录密码4修改交易密码5设置交易密码
        String templateCode = SmsCode.getTemplateByState(state);
        Objects.requireNonNull(templateCode);
        //查询该手机号验证码在两分钟之内是否发送过
        QueryWrapper<SendSms> queryWrapper = new QueryWrapper<>();
        //当前时间的两分钟前
        String twoMinutesAgo = DateFormatUtils.addMinutes(DateFormatUtils.getCurrentDateString(), -2);
        queryWrapper.eq("PHONE", phone).gt("CREATED_TIME", twoMinutesAgo).eq("state", state);
        SendSms one = getOne(queryWrapper);
        //如果两分钟前有发送的验证码，就不进行操作
        //判断是否2分钟内发送过
        if (one != null) {
            log.error("[{}]验证码发送时间[{}]未超过两分钟", phone, twoMinutesAgo);
            return Response.fail(ErrorItem.VALIDATE_CODE_FREQUENTLY);
        }
        //生成验证码
        Integer code1 = (int) ((Math.random() * 9 + 1) * 1000);
        String code = code1.toString();
        if (StringUtils.isAnyBlank(phone)) {
            log.error("手机号[{}]格式错误", phone);
        }
        SendSms sendSms = new SendSms();
        sendSms.setId(UUIDUtils.generate());
        sendSms.setPhone(phone);
        sendSms.setState(state);
        sendSms.setCode(code);
        sendSms.setCreatedTime(DateFormatUtils.getCurrentDate());
        sendSms.setEndTime(DateUtil.getDateMin(new Date(), 5));
        //发送验证码
        boolean smsResult = AliyunSmsUtil.sendSms(phone, code, templateCode);
        if (smsResult) {
            sendSms.insert();
            return Response.success(ErrorItem.GET_PHONE_CODE_SUCCESS);
        } else {
            return Response.fail(ErrorItem.GET_PHONE_CODE_ERROR);
        }
    }
}

