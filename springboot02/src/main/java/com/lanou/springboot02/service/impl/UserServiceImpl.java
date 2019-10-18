package com.lanou.springboot02.service.impl;

import com.lanou.springboot02.bean.Emp;
import com.lanou.springboot02.bean.User;
import com.lanou.springboot02.mapper.UserMapper;
import com.lanou.springboot02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Emp> listAll() {
        return userMapper.listAll();
    }

    @Override
    public List<User> allUser() {
        return userMapper.allUser();
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public User findUser(Integer id) {
        return userMapper.findUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int daleteUser(Integer id) {
        return userMapper.daleteUser(id);
    }

}
