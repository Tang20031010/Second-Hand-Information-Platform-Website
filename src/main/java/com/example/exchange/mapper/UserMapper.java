package com.example.exchange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exchange.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{

    @Select("select * from user where email=#{email} and password=#{password} ")
    public User getUser(String email,String password );

    @Insert("insert into user values(0,#{email},#{name},#{password})")
    public void addUser(User user);


}
