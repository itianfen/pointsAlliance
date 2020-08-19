package com.intercept;

import com.utils.ErrorItem;
import com.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Garen 2019/5/17
 */
@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) {
        StringBuilder printE = new StringBuilder();
        printE.append(e).append("\r\n");
        StackTraceElement[] trace = e.getStackTrace();
        for (StackTraceElement s : trace) {
            printE.append("\tat ").append(s).append("\r\n");
        }
        log.error(printE.toString());

        if (e instanceof MaxUploadSizeExceededException) {
            return Response.fail(ErrorItem.FILE_TO_LARGE);
        }
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put("state", false);
        result.put("msg", "操作失败");
        return result;
    }

}
