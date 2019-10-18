package com.lanou.springboot02.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.springboot02.bean.Emp;
import com.lanou.springboot02.bean.User;
import com.lanou.springboot02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*

缓存
添加两个方法，

    当执行新增或删除时，清空缓存区数据（清空列表缓存区中数据）

    根据用户编号查询当前用户，并将当前用户添加到缓存区中

    修改用户，同步该用户信息至缓存

    删除用户，从缓存区中删除当前用户信息

1.将数据放到缓存区，再次使用时从缓存区中查询
2.当数据修改时，修改缓存区中数据   @CachePut
3.清空缓存区中数据   @CacheEvict

*/

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("listAll")
    //开启缓存 value="名称"
    @Cacheable(value = "listAll")
    public String listAll(){
        System.out.println("-----------");
        List<Emp> userList = userService.listAll();
        return JSON.toJSONString(userList);
    }

    @RequestMapping("userAll")
    @Cacheable(value = "userAll")
    public String userAll(){
        System.out.println("-----------");
        List<User> userList = userService.allUser();
        return JSON.toJSONString(userList);
    }

    @RequestMapping("addUser")
    @CacheEvict(value = "userAll",allEntries = true)
    public ModelAndView addUser(User user){
        userService.saveUser(user);
        System.out.println(user);
        return null;
    }

    @RequestMapping("findUser")
    @Cacheable(value = "oneUser")
    public String findUser(Integer id){
        System.out.println("-----1----");
        User user = userService.findUser(id);
        return JSON.toJSONString(user);
    }

    @CachePut(value = "oneUser",key = "#user.id")
    @RequestMapping("updateUser")
    public String updateUser(User user){
        int i = userService.updateUser(user);
        return JSON.toJSONString(userService.findUser(user.getId()));
    }

    @CacheEvict(value = "oneUser",key = "#p0")
    @RequestMapping("daleteUser")
    public String daleteUser(Integer id){
        int i = userService.daleteUser(id);
        return JSON.toJSONString(i);
    }

}
