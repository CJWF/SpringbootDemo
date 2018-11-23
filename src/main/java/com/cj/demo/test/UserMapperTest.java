package com.cj.demo.test;

import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 持久层测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetById() {
        User user = userMapper.getUserByUserId("1");
        System.out.println(user);
    }

    @Test
    public  void test(){
        System.out.println("1234");
    }
}
