package com.cj.demo.test;

import com.cj.demo.sys.mapper.SwitchGroupMapper;
import com.cj.demo.sys.mapper.UserMapper;
import com.cj.demo.sys.model.SwitchGroup;
import com.cj.demo.sys.model.User;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 持久层测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SwitchGroupMapper switchGroupMapper;

    @Test
    public void getUserById() {
        User user = userMapper.selectUser("1");
        System.out.println(user);
        User user1 = new User();
//        user.setUserId("4");
//        user.setUserName("lily");
//        userMapper.insertUser(user);
        User user2 = new User();
        user2.setUserId("2");
        PageHelper.startPage(1, 2);
        List<User> userList = userMapper.getUser(user2);
        for (User user3: userList){
            System.out.println(user3);
        }

    }

    @Test
    public void getSwitchGroup() {
        SwitchGroup switchGroup1 = new SwitchGroup();
        switchGroup1.setgId("333");
        switchGroup1.setgName("333");
        switchGroup1.setpId("111");
        switchGroup1.setSortNum(2);
        switchGroupMapper.insertSwitchGroup(switchGroup1);
        switchGroupMapper.deleteSwitchGroup("222");

        List<SwitchGroup> switchGroupList = switchGroupMapper.getSwitchGroup();
        for (SwitchGroup switchGroup : switchGroupList){
            System.out.println(switchGroup);
        }
    }

    @Test
    public  void test(){
        System.out.println("1234");
    }


}
