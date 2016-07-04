package com.gmc.dao;

import com.gmc.dto.User;
import com.gmc.service.EncryptionSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 顾梦超 on 2016/3/31.
 */
@Repository
public class LoginDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * 验证登录信息，成功并返回用户信息
    * */
    public User loginCheck(final User user) {
        final User u = new User();
        final String username = user.getUsername();

        String sql = "SELECT count(*) from user where username=? and password=?";
        if (jdbcTemplate.queryForInt(sql, new Object[]{user.getUsername(),user.getPassword()}) > 0) {
            sql = "SELECT realName,role,credit,rentNumber,libraryCard,email,phoneNumber,reserveNumber FROM `user` WHERE username=?";
            jdbcTemplate.query(sql, new Object[]{username}, new RowCallbackHandler() {
                public void processRow(ResultSet resultSet) throws SQLException {
                    u.setUsername(username);
                    u.setCredit(resultSet.getInt("credit"));
                    u.setEmail(resultSet.getString("email"));
                    u.setRole(resultSet.getString("role"));
                    u.setLibraryCard(resultSet.getString("libraryCard"));
                    u.setPhoneNumber(resultSet.getString("phoneNumber"));
                    u.setRentNumber(resultSet.getInt("rentNumber"));
                    u.setRealName(resultSet.getString("realName"));
                    u.setReserveNumber(resultSet.getInt("reserveNumber"));
                }
            });
            return u;
        }
        return null;

    }

}
