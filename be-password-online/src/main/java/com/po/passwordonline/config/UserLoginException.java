package com.po.passwordonline.config;


/**
 * 抛出登录异常
 *
 * @author eq
 */
public class UserLoginException extends RuntimeException {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    /**
     * errCode
     */
    private static String errCode;
    /**
     * errMsg
     */
    private static String errMsg;

    public UserLoginException(String errCode, String errMsg) {
        super("[errCode: " + errCode + ", errMsg: " + errMsg + "]");
        UserLoginException.errCode = errCode;
        UserLoginException.errMsg = errMsg;
    }

    public static String getResMsg() {
        return "{errCode:'" + errCode + '\'' + ",errMsg:'" + errMsg + '\'' + '}';
    }
}
