package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //注入userMapper
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //通过User的用户账号和用户密码查询用户信息
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}

