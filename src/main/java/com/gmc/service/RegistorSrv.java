package com.gmc.service;

import com.gmc.dao.RegistorDao;
import com.gmc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 顾梦超 on 2016/5/7.
 */
@Service
public class RegistorSrv {
    @Autowired
    private RegistorDao registorDao;
    public String registor(User user) {
        return registorDao.registor(user);

    }
}
