package com.cj.demo.sys.mapper;

import com.cj.demo.sys.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("userMapper")
public interface UserMapper {
    public void insertUser(User user);

    public void deleteUser(String userId);

    public void updateUser(User user);

    public User selectUser(String userId);

    /**
     * 根据条件查询用户
     * @param user
     * @return
     */
    public List<User> getUser(User user);


    /**
     * 用户登录查询
     * @param userName  用户名
     * @param userPass  密码
     */
    public User userLogin(String userName, String userPass);
}
