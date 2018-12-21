package com.cj.demo.sys.page;

import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginPage {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("page")
    public String action(Map<String, Object> map) {
        return "login";
    }

}
