//package com.gmc.dao;
//
//import com.gmc.service.Format;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowCallbackHandler;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by 顾梦超 on 2016/5/22.
// */
///*
//* 管理员：查询所有客户，查询客户详细信息，增加客户，修改客户，删除客户，查询客户总数,修改状态
//* 销售经理：查询所有客户，查询客户详细信息，增加客户，修改客户，查询客户总数，修改状态
//* 客户经理：查询自己管理的客户，查询客户详细信息，增加客户，修改客户，查询客户总数，修改状态
//* */
//@Repository
//public class CustomerManageDao {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    /*
//    * 管理员/销售经理
//    *
//    * 查询客户列表
//    * */
//    public List<Customer> adminOrSaleGetCustomerList(int index, String group, String state, String account_Prefix) {
//        final int count = 15;//每一页数目
//        String sql = null;
//        List<Customer> customers = null;
//        Object[] objects = null;
//        if (group.equals("all") && state.equals("all")) {
//            sql = "select staff.name,customer.customerNumber,customer.customerName,customer.companyName,customer.money,customer.type,customer.state,customer.latestTime,customer.customerLevel from customer,staff where customer.account_Prefix=? and customer.account_suffix=staff.account_suffix and customer.account_Prefix=staff.account_Prefix  limit ?,?";
//            objects = new Object[]{account_Prefix, (index - 1) * count, (index) * count};
//
//        }
//        if (!group.equals("all") && state.equals("all")) {
//            sql = "select staff.name,customer.customerNumber,customer.customerName,customer.companyName,customer.money,customer.type,customer.state,customer.latestTime,customer.customerLevel from customer,staff where customer.type=? and customer.account_Prefix=? and customer.account_suffix=staff.account_suffix and customer.account_Prefix=staff.account_Prefix limit ?,?";
//            objects = new Object[]{group, account_Prefix, (index - 1) * count, (index) * count};
//        }
//        if (group.equals("all") && !state.equals("all")) {
//            sql = "select staff.name,customer.customerNumber,customer.customerName,customer.companyName,customer.money,customer.type,customer.state,customer.latestTime,customer.customerLevel from customer,staff where customer.state=? and customer.account_Prefix=? and customer.account_suffix=staff.account_suffix and customer.account_Prefix=staff.account_Prefix limit ?,?";
//            objects = new Object[]{state, account_Prefix, (index - 1) * count, (index) * count};
//        }
//        if (!group.equals("all") && !state.equals("all")) {
//            sql = "select staff.name,customer.customerNumber,customer.customerName,customer.companyName,customer.money,customer.type,customer.state,customer.latestTime,customer.customerLevel from customer,staff where customer.state=? and customer.type=? and customer.account_Prefix=? and customer.account_suffix=staff.account_suffix and customer.account_Prefix=staff.account_Prefix limit ?,?";
//            objects = new Object[]{state, group, account_Prefix, (index - 1) * count, (index) * count};
//        }
//        customers = jdbcTemplate.query(sql, objects, new RowMapper<Customer>() {
//            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
//                Customer customer = new Customer();
//                customer.setClientManageName(resultSet.getString("name"));
//                customer.setCustomerNumber(resultSet.getString("customerNumber"));
//                customer.setCustomerName(resultSet.getString("customerName"));
//                customer.setCompanyName(resultSet.getString("companyName"));
//                customer.setMoney(Format.doubleToString(resultSet.getDouble("money")));
//                customer.setState(resultSet.getString("state"));
//                customer.setType(resultSet.getString("type"));
//                customer.setLatestTime(resultSet.getString("latestTime"));
//                customer.setCustomerLevel(resultSet.getString("customerLevel"));
//                return customer;
//            }
//        });
//        return customers;
//    }
//
//    /*
//  * 客户经理
//  *
//  * 查询客户列表
//  * */
//    public List<Customer> clientGetCustomerList(int index, String group, String state, String account_Prefix, String account_suffix) {
//        final int count = 15;//每一页数目
//        String sql = null;
//        List<Customer> customers = null;
//        Object[] objects = null;
//        if (group.equals("all") && state.equals("all")) {
//            sql = "select customerNumber,customerName,companyName,money,type,state,latestTime,customerLevel from customer where account_Prefix=? and account_suffix=? limit ?,?";
//            objects = new Object[]{account_Prefix, account_suffix, (index - 1) * count, (index) * count};
//
//        }
//        if (!group.equals("all") && state.equals("all")) {
//            sql = "select customerNumber,customerName,companyName,money,type,state,latestTime,customerLevel from customer where type=? and account_Prefix=? and account_suffix=? limit ?,?";
//            objects = new Object[]{group, account_Prefix, account_suffix, (index - 1) * count, (index) * count};
//        }
//        if (group.equals("all") && !state.equals("all")) {
//            sql = "select customerNumber,customerName,companyName,money,type,state,latestTime,customerLevel from customer where state=? and account_Prefix=? and account_suffix=? limit ?,?";
//            objects = new Object[]{state, account_Prefix, account_suffix, (index - 1) * count, (index) * count};
//        }
//        if (!group.equals("all") && !state.equals("all")) {
//            sql = "select customerNumber,customerName,companyName,money,type,state,latestTime,customerLevel from customer where state=? and type=? and account_Prefix=? and account_suffix=? limit ?,?";
//            objects = new Object[]{state, group, account_Prefix, account_suffix, (index - 1) * count, (index) * count};
//        }
//        customers = jdbcTemplate.query(sql, objects, new RowMapper<Customer>() {
//            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
//                Customer customer = new Customer();
//                customer.setCustomerNumber(resultSet.getString("customerNumber"));
//                customer.setCustomerName(resultSet.getString("customerName"));
//                customer.setCompanyName(resultSet.getString("companyName"));
//                customer.setMoney(Format.doubleToString(resultSet.getDouble("money")));
//                customer.setState(resultSet.getString("state"));
//                customer.setType(resultSet.getString("type"));
//                customer.setLatestTime(resultSet.getString("latestTime"));
//                customer.setCustomerLevel(resultSet.getString("customerLevel"));
//                return customer;
//            }
//        });
//        return customers;
//    }
//
//    /*
//  * 管理员/销售经理/客户经理
//  *
//  * 查看客户详细信息
//  * */
//    public Customer getMoreInfo(String customerID) {
//        final Customer customer = new Customer();
//        String sql = "select * from customer where customerNumber=?";
//        jdbcTemplate.query(sql, new Object[]{customerID}, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet rs) throws SQLException {
//                customer.setCustomerNumber(rs.getString("customerNumber"));
//                customer.setState(rs.getString("state"));
//                customer.setCustomerLevel(rs.getString("customerLevel"));
//                customer.setLatestTime(rs.getString("latestTime"));
//                customer.setAddress(rs.getString("address"));
//                customer.setArea(rs.getString("area"));
//                customer.setType(rs.getString("type"));
//                customer.setRegisterTime(rs.getString("registerTime"));
//                customer.setState(rs.getString("state"));
//                customer.setMoney(Format.doubleToString(rs.getDouble("money")));
//                customer.setCustomerName(rs.getString("customerName"));
//                customer.setContact(rs.getString("contact"));
//                customer.setRemark(rs.getString("remark"));
//                customer.setCuetomerQQ(rs.getString("customerQQ"));
//                customer.setEmail(rs.getString("email"));
//                customer.setCustomerSex(rs.getString("customerSex"));
//                customer.setCompanyTel(rs.getString("companyTel"));
//            }
//        });
//        return customer;
//    }
//
//    /*
//      * 管理员/销售经理
//      *
//      * 模糊查询客户列表
//      * */
//    public List<Customer> adminOrSalefuzzyQuery(String find, String account_Prefix) {
//        String s = "%" + find + "%";
//        String sql = "select * from customer where (customerNumber like ? or customerName like ? or companyName like ?) and account_Prefix=?";
//        return jdbcTemplate.query(sql, new Object[]{s, s, s, account_Prefix}, new RowMapper<Customer>() {
//            @Override
//            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Customer customer = new Customer();
//                customer.setCustomerNumber(rs.getString("customerNumber"));
//                customer.setCustomerName(rs.getString("customerName"));
//                customer.setCompanyName(rs.getString("companyName"));
//                customer.setMoney(Format.doubleToString(rs.getDouble("money")));
//                customer.setState(rs.getString("state"));
//                customer.setType(rs.getString("type"));
//                customer.setLatestTime(rs.getString("latestTime"));
//                customer.setCustomerLevel(rs.getString("customerLevel"));
//                return customer;
//            }
//        });
//    }
//
//    /*
//  * 客户经理
//  *
//  * 模糊查询客户列表
//  * */
//    public List<Customer> clientFuzzyQuery(String find, String account_Prefix, String account_suffix) {
//        String s = "%" + find + "%";
//        String sql = "select * from customer,staff where staff.account_Prefix=customer.account_Prefix and staff.account_suffix=customer.account_suffix and customer.account_Prefix=? and customer.account_suffix=? and (customer.customerNumber like ? or customer.customerName like ? or customer.companyName like ?)";
//        return jdbcTemplate.query(sql, new Object[]{account_Prefix, account_suffix, s, s, s}, new RowMapper<Customer>() {
//            @Override
//            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Customer customer = new Customer();
//                customer.setClientManageName(rs.getString("name"));
//                customer.setCustomerNumber(rs.getString("customerNumber"));
//                customer.setCustomerName(rs.getString("customerName"));
//                customer.setCompanyName(rs.getString("companyName"));
//                customer.setMoney(Format.doubleToString(rs.getDouble("money")));
//                customer.setState(rs.getString("state"));
//                customer.setType(rs.getString("type"));
//                customer.setLatestTime(rs.getString("latestTime"));
//                customer.setCustomerLevel(rs.getString("customerLevel"));
//                return customer;
//            }
//        });
//    }
//
//    /*
//  * 客户经理/销售经理
//  *
//  * 修改客户信息
//  * */
//    public boolean clientOrSaleUpdateCustomer(String customerID, Customer customer) {
//
//        String sql = "update customer set email=?,contact=?,area=?,address=?,customerQQ=?,remark=? where customerNumber=?";
//        if (jdbcTemplate.update(sql, new Object[]{customer.getEmail(), customer.getContact(), customer.getArea(), customer.getAddress(), customer.getCuetomerQQ(), customer.getRemark(), customerID}) > 0)
//            return true;
//        return false;
//    }
//
//    /*
//  * 管理员
//  *
//  * 修改客户信息
//  * */
//    public boolean adminUpdateCustomer(String customerID, Customer customer) {
//        String sql = "update customer set customerSex=?,companyTel=?,money=?,type=?,state=?,registerTime=?,customerName=?,customerLevel=?,companyName=?, email=?,contact=?,area=?,address=?,customerQQ=?,remark=? where customerNumber=?";
//        if (jdbcTemplate.update(sql, new Object[]{customer.getCustomerSex(), customer.getCompanyTel(), customer.getMoney(), customer.getType(), customer.getState(), customer.getRegisterTime(), customer.getCustomerName(), customer.getCustomerLevel(), customer.getCompanyName(), customer.getEmail(), customer.getContact(), customer.getArea(), customer.getAddress(), customer.getCuetomerQQ(), customer.getRemark(), customerID}) > 0)
//            return true;
//        return false;
//    }
//
//    /*
//  * 管理员/销售经理
//  *
//  * 增加客户
//  * */
//    public boolean addCustomer(Customer customer, String account_Prefix, String account_suffix, String type) {
//        String sql;
//        Object[] objects;
//        if (type.equals("company")) {
//            if (customer.getCompanyTel() == null || customer.getCompanyTel().trim().equals("") || customer.getCompanyName() == null || customer.getCompanyName().trim().equals("") || customer.getCustomerName() == null || customer.getCustomerName().trim().equals("") || customer.getContact() == null || customer.getContact().trim().equals("") || customer.getArea() == null || customer.getArea().trim().equals("") || customer.getAddress() == null || customer.getAddress().trim().equals("") || customer.getEmail() == null || customer.getEmail().trim().equals("") || customer.getCustomerSex() == null || customer.getCustomerSex().trim().equals("")) {
//                return false;
//            }
//            if (!customer.getContact().matches("[0-9]*")) {
//                return false;
//            }
//            if ((customer.getContact().length() != 11)) {
//                return false;
//            }
//            if (!customer.getCompanyTel().matches("[0-9]*")) {
//                return false;
//            }
//            if ((customer.getCompanyTel().length() != 11)) {
//                return false;
//            }
//            if (!customer.getEmail().matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"))
//                return false;
//
//            sql = "insert into customer(account_Prefix,account_suffix,companyName,contact,customerLevel,type,area,registerTime,customerName,companyTel,customerSex,email,customerQQ,remark) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            objects = new Object[]{account_Prefix, account_suffix, customer.getCompanyName(), customer.getContact(), customer.getCustomerLevel(), customer.getType(), customer.getArea(), Format.dateTOString2(new Date()), customer.getCustomerName(), customer.getCompanyTel(), customer.getCustomerSex(), customer.getEmail(), customer.getCuetomerQQ(), customer.getRemark()};
//        } else {
//
//            if (customer.getCustomerName() == null || customer.getCustomerName().trim().equals("") || customer.getContact() == null || customer.getContact().trim().equals("") || customer.getArea() == null || customer.getArea().trim().equals("") || customer.getAddress() == null || customer.getAddress().trim().equals("") || customer.getEmail() == null || customer.getEmail().trim().equals("") || customer.getCustomerSex() == null || customer.getCustomerSex().trim().equals("")) {
//                return false;
//            }
//            if (!customer.getContact().matches("[0-9]*")) {
//                return false;
//            }
//            if ((customer.getContact().length() != 11)) {
//                return false;
//            }
//            if (!customer.getEmail().matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"))
//                return false;
//            sql = "insert into customer(account_Prefix,account_suffix,contact,customerLevel,type,area,registerTime,customerName,customerSex,email,customerQQ,remark) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
//            objects = new Object[]{account_Prefix, account_suffix, customer.getContact(), customer.getCustomerLevel(), customer.getType(), customer.getArea(), Format.dateTOString(new Date()), customer.getCustomerName(), customer.getCustomerSex(), customer.getEmail(), customer.getCuetomerQQ(), customer.getRemark()};
//        }
//        return jdbcTemplate.update(sql, objects) > 0;
//    }
//
//    /*
//  * 管理员
//  *
//  * 删除客户
//  * */
//    public boolean delectCustomer(String customerID) {
//        String sql = "delect customer where customerID=?";
//        return jdbcTemplate.update(sql, new Object[]{customerID}) > 0;
//    }
//
//    /*
//  * 客户经理
//  *
//  * 得到客户总数
//  * */
//    public int clientGetCount(String group, String state, String account_Prefix, String account_suffix) {
//        String sql = null;
//        Object[] objects = null;
//        if (group.equals("all") && state.equals("all")) {
//            sql = "select count(*) from customer where account_Prefix=? and account_suffix=?";
//            objects = new Object[]{account_Prefix, account_suffix};
//
//        }
//        if (!group.equals("all") && state.equals("all")) {
//            sql = "select count(*) from customer where type=? and account_Prefix=? and account_suffix=?";
//            objects = new Object[]{group, account_Prefix, account_suffix};
//        }
//        if (group.equals("all") && !state.equals("all")) {
//            sql = "select count(*) from customer where state=? and account_Prefix=? and account_suffix=?";
//            objects = new Object[]{state, account_Prefix, account_suffix};
//        }
//        if (!group.equals("all") && !state.equals("all")) {
//            sql = "select count(*) from customer where type=? and state=? and account_Prefix=? and account_suffix=?";
//            objects = new Object[]{state, group, account_Prefix, account_suffix};
//        }
//        return jdbcTemplate.queryForInt(sql, objects);
//    }
//
//    /*
//      * 管理员/销售经理
//      *
//      * 得到客户总数
//      * */
//    public int saleOrAdminGetCount(String group, String state, String account_Prefix) {
//        String sql = null;
//        Object[] objects = null;
//        if (group.equals("all") && state.equals("all")) {
//            sql = "select count(*) from customer where account_Prefix=? ";
//            objects = new Object[]{account_Prefix};
//
//        }
//        if (!group.equals("all") && state.equals("all")) {
//            sql = "select count(*) from customer where type=? and account_Prefix=?";
//            objects = new Object[]{group, account_Prefix};
//        }
//        if (group.equals("all") && !state.equals("all")) {
//            sql = "select count(*) from customer where state=? and account_Prefix=?";
//            objects = new Object[]{state, account_Prefix};
//        }
//        if (!group.equals("all") && !state.equals("all")) {
//            sql = "select count(*) from customer where type=? and state=? and account_Prefix=?";
//            objects = new Object[]{state, group, account_Prefix};
//        }
//        return jdbcTemplate.queryForInt(sql, objects);
//    }
//
//    public boolean changeState(String customerID, String state) {
//        String sql = "update customer set state=? where customerNumber=?";
//        Object[] objects = new Object[]{state, customerID};
//        return jdbcTemplate.update(sql, objects) > 0;
//    }
//
//    public List<Customer> getAllCustomer(String account_Prefix) {
//        String sql = "select * from customer where account_Prefix=? and state=?";
//        return jdbcTemplate.query(sql, new Object[]{account_Prefix, "1"}, new RowMapper<Customer>() {
//            @Override
//            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Customer customer = new Customer();
//                customer.setCustomerName(rs.getString("customerName"));
//                customer.setCustomerNumber(rs.getString("customerNumber"));
//                return customer;
//            }
//        });
//    }
//
//    public List<Customer> getAllCustomer(String account_Prefix, String account_suffix) {
//        String sql = "select * from customer where account_Prefix=? and state=? and account_suffix=?";
//        return jdbcTemplate.query(sql, new Object[]{account_Prefix, "1", account_suffix}, new RowMapper<Customer>() {
//            @Override
//            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Customer customer = new Customer();
//                customer.setCustomerName(rs.getString("customerName"));
//                customer.setCustomerNumber(rs.getString("customerNumber"));
//                return customer;
//            }
//        });
//    }
//
//}
