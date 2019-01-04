package com.cj.demo.sys.controller;

import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/userAction")
public class UserAction {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/getAllUser")
    public Object getAllUser(String userName, String userPass, int currentPage, int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        return userMapper.getUser(null);
    }
}
