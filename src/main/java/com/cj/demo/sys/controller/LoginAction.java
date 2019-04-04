package com.cj.demo.sys.controller;

import com.cj.demo.common.Result.Result;
import com.cj.demo.common.Result.ResultType;
import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.User;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("loginAction")
public class LoginAction {
    @Autowired
    private UserMapper userMapper;

    @Valid
    @PostMapping("/toLogin")
    public Object toLogin(@NotBlank(message = "{user.name.notBlank}") String userName, @NotBlank(message = "{user.pass.notBlank}") String userPass, HttpSession session){
        User loginUser = new User();
        loginUser.setUserName(userName);
        loginUser.setUserPass(userPass);
        List<User> userList = userMapper.getUser(loginUser);
        if (userList == null || userList.size() == 0){
            return new Result(ResultType.BUSINESS_ERROR, "用户名或密码错误！");
        }
        User user = userList.get(0);
        if (user == null) {
            return new Result(ResultType.BUSINESS_ERROR, "用户名或密码错误！");
        }else if (!user.getUserStatus().equals("111111")){
            return new Result(ResultType.BUSINESS_ERROR, "用户状态异常，请联系管理员！");
        }
        session.setAttribute("user",user);
        return new Result(ResultType.SUCCESS, "登录成功！");
    }
}
