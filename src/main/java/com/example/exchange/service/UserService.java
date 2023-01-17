package com.example.exchange.service;

import com.example.exchange.entity.User;
import com.example.exchange.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {


    User login(String email, String password);
    void regist(User user);


}
