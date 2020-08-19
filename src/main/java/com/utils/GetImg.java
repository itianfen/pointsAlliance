package com.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/21 16:56
 */
public class GetImg {
    public static String getImg(String imgUrl) {
        String fileName = UUIDUtils.generate() + ".jpg";
        String filePath = "D:/test/head/";
        URL url;
        BufferedInputStream in;
        FileOutputStream file;
        try {
            url = new URL(imgUrl);
            in = new BufferedInputStream(url.openStream());
            File file1 = new File(filePath + fileName);
            if (!file1.getParentFile().exists()) {
                boolean mkdirs = file1.getParentFile().mkdirs();
            }
            file = new FileOutputStream(file1);

            int t;
            while ((t = in.read()) != -1) {
                file.write(t);
            }
            file.close();
            in.close();
            return "head/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}