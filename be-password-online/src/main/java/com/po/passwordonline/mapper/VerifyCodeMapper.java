package com.po.passwordonline.mapper;

import com.po.passwordonline.model.VerifyCode;
import org.springframework.stereotype.Component;

@Component
public interface VerifyCodeMapper {

    public void insertCode(VerifyCode vc);

    public VerifyCode findById(int id);

    public VerifyCode findByIpAndTime(String findIp);

    public void updateStatus(int id);
}
