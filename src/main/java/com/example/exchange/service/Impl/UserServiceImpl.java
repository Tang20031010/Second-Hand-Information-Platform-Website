package com.example.exchange.service.Impl;

import com.example.exchange.entity.User;
import com.example.exchange.mapper.UserMapper;
import com.example.exchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String email, String password) {
        return userMapper.getUser(email,password);
    }

    @Override
    public void regist(User user) {
        userMapper.addUser(user);
    }


}
