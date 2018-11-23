package com.cj.demo.sys.mapper;

import com.cj.demo.sys.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("userMapper")
public interface UserMapper {
    public void insertUser(User user);

    /**
     * 根据用户id获取用户信息
     * @param userId    用户
     * @return
     */
    public User getUserByUserId(String userId);

    public void updateUser(User user);

    public void deleteUserByUserId(String userId);

    /**
     * 用户登录查询
     * @param userName  用户名
     * @param userPass  密码
     */
    public User userLogin(String userName, String userPass);
}
