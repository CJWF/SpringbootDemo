package com.cj.demo.sys.page;

import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("login")
public class Login {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("todo")
    public String todo(Map<String, Object> map) {
        if (map.get("userName") == null || !(map.get("userName") instanceof String)){
            map.put("status","-1");
            map.put("errorMsg","用户名为空或格式不正确");
            return "/login";
        }
        if (map.get("userPass") == null || !(map.get("userPass") instanceof String)){
            return "/login";
        }
        String userName = (String) map.get("userName");
        String userPass = (String) map.get("userPass");
        User user = userMapper.userLogin(userName, userPass);

        return "/sys/user";
    }
}
