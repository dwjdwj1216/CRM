package com.gmc.dao;

import com.gmc.dto.User;
import com.gmc.service.EncryptionSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 顾梦超 on 2016/4/23.
 */
@Repository
public class UserManageDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * 管理员
    * 返回个人信息
    * */
    public User getUser(String sql, Object[] objects) {
        final User user = new User();

        jdbcTemplate.query(sql, objects, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setRealName(resultSet.getString("realName"));
                user.setUsername(resultSet.getString("username"));
                user.setLibraryCard(resultSet.getString("libraryCard"));
                user.setRole(resultSet.getString("role"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setCredit(resultSet.getInt("credit"));
                user.setRentNumber(resultSet.getInt("rentNumber"));
                user.setReserveNumber(resultSet.getInt("reserveNumber"));
                user.setPassword(resultSet.getString("password"));
            }
        });
        return user;
    }

    /*
    * 管理员
    * 修改个人信息
    * */
    public boolean updateUser(String sql, Object[] objects) {
        return jdbcTemplate.update(sql,objects) > 0;
    }


    /*
   * 管理员
   * 模糊查询
   * */
//    public List<User> fuzzyQuery(String find, String account_Prefix) {
//
//        String s = "%" + find + "%";
//        String sql = "select * from staff where account_Prefix=? and (name like ? or account_Prefix like ? or account_suffix like ? or role like ?)";
//        List<User> users = jdbcTemplate.query(sql, new Object[]{account_Prefix, s, s, s, s}, new RowMapper<User>() {
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                User user = new User();
//                user.setRole(rs.getString("role"));
//                user.setAccount_suffix(rs.getString("account_suffix"));
//                user.setAccount_Prefix(rs.getString("account_Prefix"));
//                user.setAccount(user.getAccount_Prefix() + "_" + user.getAccount_suffix());
//                user.setName(rs.getString("name"));
//                return user;
//            }
//        });
//        return users;
//
//    }
//
//    public boolean editUser(User user, String account_Prefix, String account_suffix) {
//        String sql = "update staff set phone=?,email=? where account_Prefix=? and account_suffix=?";
//        return jdbcTemplate.update(sql, new Object[]{user.getPhone(), user.getEmail(), account_Prefix, account_suffix}) > 0;
//    }

}
