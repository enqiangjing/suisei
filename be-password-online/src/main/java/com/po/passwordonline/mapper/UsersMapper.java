package com.po.passwordonline.mapper;

import com.po.passwordonline.model.Users;
import org.springframework.stereotype.Component;

@Component
public interface UsersMapper {

    Users userVerify(String userName, String password);  // 用户验证：账号+密码

    void upDateUser(Users users);
}
