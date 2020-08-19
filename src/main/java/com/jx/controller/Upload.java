package com.jx.controller;

import com.utils.ErrorItem;
import com.utils.Response;
import com.utils.UploadUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yangyantong
 */
@RestController
public class Upload {
    /**
     * 文件上传返回uri
     */
    @ResponseBody
    @RequestMapping("/upload")
    public Map<String, Object> uploadPicture(MultipartFile[] file, HttpServletRequest request) {
        String[] upload = UploadUtils.uploadMore(file);
        return request == null ? Response.fail(ErrorItem.SYSTEM_ERROR_MSG) : Response.success(upload);
    }
}
