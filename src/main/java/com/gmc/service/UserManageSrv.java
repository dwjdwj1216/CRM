package com.gmc.service;

import com.gmc.dao.UserManageDao;
import com.gmc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 顾梦超 on 2016/4/23.
 */
@Service
public class UserManageSrv {

    @Autowired
    UserManageDao userManageDao;

    public User getInfo(HttpSession httpSession){
        String sql = null;
        Object[] objects = null;
        sql = "select * from user where libraryCard=?";
        objects = new Object[]{httpSession.getAttribute("libraryCard")};


        return userManageDao.getUser(sql,objects);

    }
    public String editInfo(String newPassword,String email,String phoneNumber,HttpSession httpSession){
        Object [] objects = null;
        String sql = null;
        if(!phoneNumber.matches("[0-9]*")){
            return "联系方式错误";
        }
        if(phoneNumber.length()!=11){
            return "联系方式错误";
        }
        if(!email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")){
            return "邮箱错误";
        }
        if(newPassword.length()<=6){
            return "密码长度必须大于6";
        }
        sql = "update user set email = ?,phoneNumber=?,password = ? where libraryCard = ?";
        objects = new Object[]{email,phoneNumber,newPassword,httpSession.getAttribute("libraryCard")};
        if (userManageDao.updateUser(sql,objects)){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }


}