package com.lanou.springboot02.mapper;

import com.lanou.springboot02.bean.Emp;
import com.lanou.springboot02.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    public List<Emp> listAll();

    public List<User> allUser();

    public void saveUser(User user);

    public User findUser(Integer id);

    public int updateUser(User user);

    public int daleteUser(@Param("id") Integer id);

}
