package com.po.passwordonline.controller;

import com.po.passwordonline.mapper.UsersMapper;
import com.po.passwordonline.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTests {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void loginTEst() {
//        LearnResource learnResource=learnService.selectByKey(1001L);
//        Assert.assertThat(learnResource.getAuthor(),is("嘟嘟MD独立博客"));
        Users users = usersMapper.userVerify("jing", "jing");
        Assert.assertEquals("jing", users.getUserName());
        String userName = "jing";
        Assert.assertSame(userName, users.getUserName());
    }
}
