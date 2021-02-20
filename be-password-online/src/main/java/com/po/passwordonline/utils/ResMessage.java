package com.po.passwordonline.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResMessage {
    public String sysError() {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", "999");
        msg.put("errMsg", "交易失败！");
        return JSONObject.toJSONString(msg);
    }

    public String resError(String errCode) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", errCode);
        msg.put("errMsg", "交易失败！");
        return JSONObject.toJSONString(msg);
    }

    public String resError(String errCode, String errMsg) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", errCode);
        msg.put("errMsg", errMsg);
        return JSONObject.toJSONString(msg);
    }

    public String sysSuccess() {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", "success");
        msg.put("errMsg", "交易成功！！");
        return JSONObject.toJSONString(msg);
    }

    public String sysSuccess(Object object) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", "success");
        msg.put("errMsg", "交易成功！！");
        msg.put("data", object);
        return JSONObject.toJSONString(msg);
    }
}
