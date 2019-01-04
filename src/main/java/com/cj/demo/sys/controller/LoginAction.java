package com.cj.demo.sys.controller;

import com.cj.demo.common.Util.ErrorUtil;
import com.cj.demo.common.Util.RequestResultUtil;
import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("loginAction")
public class LoginAction {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/toLogin")
    public Object toLogin(String userName, String userPass, HttpSession session){
        User loginUser = new User();
        loginUser.setUserName(userName);
        loginUser.setUserPass(userPass);
        List<User> userList = userMapper.getUser(loginUser);
        if (userList == null || userList.size() == 0){
            return RequestResultUtil.fail(ErrorUtil.normalError("用户名或密码错误"));
        }
        User user = userList.get(0);
        if (user == null) {
            return RequestResultUtil.fail(ErrorUtil.normalError("用户名或密码错误"));
        }else if (!user.getUserStatus().equals("111111")){
            return RequestResultUtil.fail(ErrorUtil.normalError("用户状态异常，请联系管理员"));
        }
        session.setAttribute("user",user);
        return RequestResultUtil.success("登录成功");
    }
}
