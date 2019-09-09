package com.liuyuan.gmall.user.controller;


import com.liuyuan.gmall.bean.UserInfo;
import com.liuyuan.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//这个注解的作用相当于@RequestBody和@Controller两个共同使用
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("allusers")
    /**
     * 查询用户列表的方法
     */
    public List<UserInfo> getAllUsers(){
       return   userService.getUserInfoListAll();
    }
    /**
     * 新增用户方法
     */
    @PostMapping("addUser")
    public String addUser(UserInfo userInfo){
        userService.addUser(userInfo);
        return  "success";
    }
    /**
     * 更新用户方法
     */
    @PostMapping("updateUser")
    public String updateUser(UserInfo userInfo){
        userService.updateUser(userInfo);
        return "success";
    }
    /**
     * 通过用户名更新用户方法
     */
    @PostMapping("updateUserByName")
    public String updateUserByName(UserInfo userInfo){
        userService.updateUserByName(userInfo.getName(),userInfo);
        return "success";
    }
    /**
     * 删除用户方法
     */
    @PostMapping("delUser")
    public String delUser(UserInfo userInfo){
        userService.delUser(userInfo);
        return "success";
    }

    /**
     * 通过用户ID获取用户信息方法
     */
    @GetMapping("getUser")
    public UserInfo getUser(String id){
        return userService.getUserInfoById(id);

    }


}
