package com.jx.controller;

import com.jx.service.SysUserService;
import com.utils.StringUtils;
import com.utils.WxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/1 9:43
 */
@Slf4j
@RestController
@RequestMapping("wxPaymentCallback")
public class WxPaymentCallback {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/callback")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void callback(HttpServletRequest req, HttpServletResponse resp) {
        TreeMap<String, String> pcbrs = null;
        try {
            BufferedReader reader;
            reader = req.getReader();
            StringBuilder sb = new StringBuilder();
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
            log.info("XML文件内容:" + sb.toString());
            pcbrs = WxUtils.parserPaymentCallBack(sb.toString());
            log.info("XML解析后:" + pcbrs.toString());
            if (pcbrs != null && !pcbrs.isEmpty()) {
                log.info(pcbrs.get("return_code"));
                // 如果 订单成功 return_code=SUCCESS
                if ("SUCCESS".equals(pcbrs.get("return_code"))) {
                    // 订单号码
                    String wxOrderId = pcbrs.get("out_trade_no");
                    // 订单标记 (类型)
                    String attach = pcbrs.get("attach");
                    if (StringUtils.isNotEmpty(wxOrderId)) {
                        boolean checkState = true;
                        // 验证签名是否成功
                        if (true) {
                            // 支付成功
                            //TODO:判断attach来进行充值或升级
                            if (attach.trim().contains("member_upgrade")) {
                                sysUserService.memberUpgradeWxCallback(pcbrs);
                            } else if (attach.trim().contains("company_upgrade")) {
                                sysUserService.companyUpgradeWxCallback(pcbrs);
                            }
                        } else {
                            log.error("微信订单验证签名报错---ERROR——orderID: " + wxOrderId + "  attach: " + attach);
                        }
                        resp.getWriter().write(WxUtils.paymentCallBackResponse(checkState, checkState ? "ok" : "fail"));
                    }
                } else {
                    // log return_msg
                    log.error("微信订单报错---ERROR: " + pcbrs.get("return_msg"));
                }
            } else {
                resp.getWriter().write(WxUtils.paymentCallBackResponse(false, "fail"));
            }
        } catch (IOException e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(this.getClass().getName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
    }
}
