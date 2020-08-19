package com.jx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jx.entity.SysUser;
import com.jx.entity.Token;
import com.jx.service.SysUserService;
import com.jx.service.WxBaseService;
import com.utils.ErrorItem;
import com.utils.GetImg;
import com.utils.Response;
import com.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/22 9:56
 */
@Service
public class WxBaseServiceImpl implements WxBaseService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public Map<String, Object> wxBind(String token, JSONObject userInfo) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.PLEASE_LOGIN_AGAIN);
        }
        String userId = tokenObj.getUserId();
        SysUser sysUser = sysUserService.getById(userId);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("OPEN_ID", userInfo.getString("openid"));
        SysUser sysUser1 = sysUserService.getOne(queryWrapper);
        if (sysUser1 != null) {
            return Response.fail(ErrorItem.WX_IS_USED);
        }
        sysUser.setOpenId(userInfo.getString("openid"));
        sysUser.setName(userInfo.getString("nickname"));
        String headimgurl = GetImg.getImg(userInfo.getString("headimgurl"));
        sysUser.setHeadUrl(headimgurl);
        sysUser.updateById();
        tokenObj.setOpenId(sysUser.getOpenId());
        TokenUtils.updateOnlineToken(tokenObj);
        return Response.success();
    }

    @Override
    public Map<String, Object> wxLogin(String openId) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("OPEN_ID", openId);
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        if (sysUser != null) {
            return sysUserService.loginUtil(sysUser);
        } else {
            return Response.fail(ErrorItem.USER_NOT_BIND_WX);
        }
    }
}
