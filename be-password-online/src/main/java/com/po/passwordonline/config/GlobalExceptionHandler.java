package com.po.passwordonline.config;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常统一输出
 *
 * @author eq
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * userLoginHandle && 用户登录异常
     *
     * @return ｛json｝ error message
     */
    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public String userLoginHandle() {
        return UserLoginException.getResMsg();
    }

    /**
     * handleException && 异常
     *
     * @param e 异常信息
     * @return ｛json｝ error message
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e) {
        Map<String, Object> resMsg = new HashMap<>();
        resMsg.put("errCode", "UNKNOWN_ERROR");
        resMsg.put("errMsg", e);
        log.info("[UNKNOWN_ERROR: {}]", e);
        return JSONObject.toJSONString(resMsg);
    }
}
