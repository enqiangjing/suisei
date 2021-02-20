package com.po.passwordonline.controller;


import com.po.passwordonline.mapper.AccountInfoMapper;
import com.po.passwordonline.model.AccountInfo;
import com.po.passwordonline.utils.ResMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登录控制器
 *
 * @author eq
 * @version 1.0.0
 */
@Slf4j
@Controller
@RequestMapping("api")
public class AccountInfoController {

    /**
     * 用户查询接口
     */
    private AccountInfoMapper accountInfoMapper;

    @Autowired
    public void setAccountInfoMapper(AccountInfoMapper accountInfoMapper) {
        this.accountInfoMapper = accountInfoMapper;
    }

    /**
     * 用户登录
     *
     * @param request     请求信息
     * @param accountInfo 查询条件
     * @return 返回结果值
     * @apiNote 登录入口
     */
    @RequestMapping("getList")
    @ResponseBody
    public String main(HttpServletRequest request, @RequestBody AccountInfo accountInfo) {
        // 参数
        ResMessage resMessage = new ResMessage();

        HttpSession session = request.getSession(); // 获取浏览器Session
        String userInfo = (String) session.getAttribute("userInfo"); // 取的userInfo中的用户信息
        String[] users = userInfo.split(",");

        List<AccountInfo> accountInfoList = accountInfoMapper.getAccountsList(accountInfo);
        log.info(users[1]);
        return resMessage.sysSuccess(accountInfoList);
    }

    /**
     * 账号新增
     *
     * @param request     请求
     * @param accountInfo 账号信息
     * @return 结果
     */
    @RequestMapping("insertData")
    @ResponseBody
    public String insertData(HttpServletRequest request, @RequestBody AccountInfo accountInfo) {
        ResMessage resMessage = new ResMessage();

        HttpSession session = request.getSession(); // 获取浏览器Session
        String userInfo = (String) session.getAttribute("userInfo"); // 取的userInfo中的用户信息
        String[] users = userInfo.split(",");

        accountInfoMapper.insertData(accountInfo);

        log.info("插入id：{}", accountInfo.getId());

        return resMessage.sysSuccess();
    }

    /**
     * 更新面膜
     *
     * @param request     请求
     * @param accountInfo 更新数据
     * @return 结果
     */
    @RequestMapping("upDateInfo")
    @ResponseBody
    public String upDateInfo(HttpServletRequest request, @RequestBody AccountInfo accountInfo) {
        ResMessage resMessage = new ResMessage();

        HttpSession session = request.getSession(); // 获取浏览器Session
        String userInfo = (String) session.getAttribute("userInfo"); // 取的userInfo中的用户信息
        String[] users = userInfo.split(",");

        accountInfoMapper.upDateInfo(accountInfo);

        log.info("更新id：{}", accountInfo.getId());

        return resMessage.sysSuccess();
    }
}
