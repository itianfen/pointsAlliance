package com.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Calendar;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/21 17:06
 */
public class UploadUtils {
    /**
     * 默认上传路径
     */
    public static final String PATH = "D:/test/uploads/";

    /**
     *
     */
    private static final String SUFFIX = ".";

    /**
     * 单文件上传
     *
     * @param file 文件
     * @return 文件uri
     */
    public static String upload(MultipartFile file) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        String newFileName = UUIDUtils.generate();
        // 获取文件的后缀名
        assert fileName != null;
        if (fileName.contains(SUFFIX)) {
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            newFileName += suffixName;
        }
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String newPath = "" + year + "/" + month + "/" + day + "/";
        File dest = new File(PATH + newPath + newFileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            boolean mkdirs = dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "uploads/" + newPath + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    /**
     * 多文件上传
     *
     * @param files 多个文件
     * @return 文件uri字符串数组
     */
    public static String[] uploadMore(MultipartFile[] files) {
        String[] result = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            String uploadResult = upload(files[i]);
            result[i] = uploadResult;
        }
        return result;
    }
}
