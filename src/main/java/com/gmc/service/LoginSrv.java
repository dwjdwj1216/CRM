package com.gmc.service;

import com.gmc.dao.LoginDao;
import com.gmc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 顾梦超 on 2016/3/31.
 */
@Service
public class LoginSrv {
    @Autowired
    private LoginDao loginDao;
    /*
    * 检查登陆并返回用户信息
    * */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
    public User Login(User user) {
        return loginDao.loginCheck(user);
    }
}
