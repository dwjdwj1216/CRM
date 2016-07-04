package com.gmc.dao;

import com.gmc.dto.User;
import com.gmc.service.EncryptionSrv;
import com.gmc.service.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by 顾梦超 on 2016/5/7.
 */
@Repository
public class RegistorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String registor(final User user) {
        String  sql;

        if(user.getUsername()==null || user.getUsername().trim().equals("")||user.getPassword()==null ||user.getPhoneNumber()==null || user.getPhoneNumber().trim().equals("")||user.getEmail()==null || user.getEmail().trim().equals("")||user.getLibraryCard()==null || user.getLibraryCard().trim().equals("")||user.getRealName()==null || user.getRealName().trim().equals("")||user.getRole().equals("")||user.getRole().trim().equals(""))
            return "请填写全相关信息";
        if(!user.getPhoneNumber().matches("[0-9]*")){
            return "联系方式错误";
        }
        if(user.getPhoneNumber().length()!=11){
            return "联系方式错误";
        }
        if(!user.getEmail().matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")){
            return "邮箱错误";
        }
        if(user.getPassword().length()<=6){
            return "密码长度必须大于6";
        }
        sql = "select count(*) from user where libraryCard=?";
        int count = jdbcTemplate.queryForInt(sql, new Object[]{user.getLibraryCard()});
        if (count == 1) {
            return "该图书证已被注册";
        }
        sql = "select count(*) from user where username=?";
        int count1 = jdbcTemplate.queryForInt(sql, new Object[]{user.getUsername()});
        if (count1 == 1) {
            return "该用户名已被注册";
        }
        sql = "insert into user(username,password,credit,rentNumber,realName,email,phoneNumber,role,libraryCard,reserveNumber) VALUES (?,?,?,?,?,?,?,?,?,?)";
        if (jdbcTemplate.update(sql, new Object[]{user.getUsername(), user.getPassword(),100,0, user.getRealName(), user.getEmail(),user.getPhoneNumber(),user.getRole(),user.getLibraryCard(),0}) > 0)    {

            return "注册成功";
        }
        return "未知错误,请重新注册";
    }

}

