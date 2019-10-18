package com.lanou.springboot02.service;

import com.lanou.springboot02.bean.Emp;
import com.lanou.springboot02.bean.User;

import java.util.List;

public interface UserService {

    public List<Emp> listAll();

    public List<User> allUser();

    public void saveUser(User user);

    public User findUser(Integer id);

    public int updateUser(User user);

    public int daleteUser(Integer id);

}
