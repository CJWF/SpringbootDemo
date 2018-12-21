package com.cj.demo.sys.controller;

import com.cj.demo.common.Util.ErrorUtil;
import com.cj.demo.common.Util.RequestResultUtil;
import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("loginAction")
public class LoginAction {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/toLogin")
    public Object toLogin(String userName, String userPass){
//        String userName = (String) map.get("userName");     //用户名
//        String userPass = (String) map.get("userPass");     //用户密码
        User user = userMapper.userLogin(userName, userPass);
        if (user == null) {
            return RequestResultUtil.fail(ErrorUtil.normalError("用户名或密码错误"));
        }else if (!user.getUserStatus().equals("111111")){
            return RequestResultUtil.fail(ErrorUtil.normalError("用户状态异常，请联系管理员"));
        }


        return RequestResultUtil.success(null);
    }
}
