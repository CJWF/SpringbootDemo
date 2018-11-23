package com.cj.demo.sys.page;

import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("sys")
public class SysPage {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("user")
    public String getView(Map<String,Object> map) {
        User user = userMapper.getUserByUserId("1");
        System.out.println(user);
        return "/sys/user";
    }
}
