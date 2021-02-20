package com.po.passwordonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.po.passwordonline.mapper.UsersMapper;
import com.po.passwordonline.model.Users;
import com.po.passwordonline.utils.CreateJpgToVerify;
import com.po.passwordonline.utils.ResMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 登录控制器
 *
 * @author eq
 * @version 1.0.0
 */
@Slf4j
@Controller
public class LoginController {

    /**
     * 用户查询接口
     */
    private UsersMapper usersMapper;

    @Autowired
    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    /**
     * 登录首页
     *
     * @return mav 首页视图
     */
    @RequestMapping("/")
    public ModelAndView indexPage() {
        // 加载视图
        ModelAndView mav = new ModelAndView();
        mav.addObject("key", "value");
        mav.setViewName("/index.html");
        return mav;
    }

    /**
     * 用户登录
     *
     * @param request   请求信息
     * @param response  响应信息
     * @param userLogin 用户登录信息
     * @return 返回结果值
     * @apiNote 登录入口
     */
    @RequestMapping("login")
    @ResponseBody
    public String main(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject userLogin) {
        // 参数
        ResMessage resMessage = new ResMessage();
        String userName = userLogin.getString("userName");
        String password = userLogin.getString("password");
        String verifyCode = userLogin.getString("verifyCode");
        // 待补充验证码判断逻辑
        log.info(verifyCode);
        // 数据库查询
        try {
            Users users = usersMapper.userVerify(userName, password);
            if (StringUtils.isEmpty(users)) {
                return resMessage.resError("002");
            }
            users.setPassword(""); // 清空密码
            request.getSession().setAttribute("userInfo", users.toStringBy()); // 设置redis session
            log.info("[用户{}-{}登录成功：sessionId:{}]", userName, users.getUserName(), request.getSession().getId()); // 打印登录日志
            return resMessage.sysSuccess(users); // 返回用户信息
        } catch (Exception e) {
            e.printStackTrace();
            log.error("[用户{}查询失败]", userName);
            return resMessage.sysError();
        }
    }

    /**
     * 获取验证码
     *
     * @param request  请求信息
     * @param response 响应信息
     * @apiNote 获取图片验证码
     */
    @RequestMapping("getVerifyCode")
    @ResponseBody
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) {
        CreateJpgToVerify createJpgToVerify = new CreateJpgToVerify();
        String roundNum = String.valueOf(System.currentTimeMillis());
        BufferedImage image = createJpgToVerify.createImg(request, roundNum);

        response.setContentType("image/jpeg");
        ImageIO.setUseCache(false);
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
