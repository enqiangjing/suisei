package com.po.passwordonline.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 建立请求拦截器
 *
 * @author eq
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 登录拦截器
     *
     * @param request  请求
     * @param response 响应
     * @param handler  拦截
     * @return {boolean} true-已登录
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession(); // 获取浏览器Session
        String userInfo = (String) session.getAttribute("userInfo"); // 取的userInfo中的用户信息
        if (userInfo == null) {
            throw new UserLoginException("001", "未登录"); // 抛出异常
        }
        return true;
    }

    /**
     * 生成视图时执行，用于处理异常
     *
     * @param request   请求
     * @param response  响应
     * @param object    对象
     * @param exception 异常
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
                                Exception exception) {
        // ------------- //
    }

    /**
     * 生成视图之前执行
     *
     * @param request      请求
     * @param response     响应
     * @param object       对象
     * @param modelAndView 视图
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) {
        // ------------- //
    }

}
