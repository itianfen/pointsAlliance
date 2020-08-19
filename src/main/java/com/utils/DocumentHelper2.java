package com.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/31 17:45
 */
public class DocumentHelper2 {
    private static final Logger log = LoggerFactory.getLogger(DocumentHelper2.class);

    public static Document parseText(String text) throws DocumentException {
        Document result = null;
        try {
            SAXReader reader = new SAXReader();
            filtXXE(reader);
            String encoding = getEncoding(text);

            InputSource source = new InputSource(new StringReader(text));
            source.setEncoding(encoding);

            result = reader.read(source);

            // if the XML parser doesn't provide a way to retrieve the encoding,
            // specify it manually
            if (result.getXMLEncoding() == null) {
                result.setXMLEncoding(encoding);
            }
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return result;
    }

    private static String getEncoding(String text) {
        String result = null;
        try {
            String xml = text.trim();
            if (xml.startsWith("<?xml")) {
                int end = xml.indexOf("?>");
                String sub = xml.substring(0, end);
                StringTokenizer tokens = new StringTokenizer(sub, " =\"'");

                while (tokens.hasMoreTokens()) {
                    String token = tokens.nextToken();
                    if ("encoding".equals(token)) {
                        if (tokens.hasMoreTokens()) {
                            result = tokens.nextToken();
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return result;
    }

    private static void filtXXE(SAXReader reader) {
        String FEATURE = null;
        try {
            FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
            reader.setFeature(FEATURE, true);

            FEATURE = "http://xml.org/sax/features/external-general-entities";
            reader.setFeature(FEATURE, false);

            FEATURE = "http://xml.org/sax/features/external-parameter-entities";
            reader.setFeature(FEATURE, false);

            FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
            reader.setFeature(FEATURE, false);
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
    }
}

