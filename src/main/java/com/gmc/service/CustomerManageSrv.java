package com.gmc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 顾梦超 on 2016/5/22.
 */
@Repository
public class CustomerManageSrv {
    /*
    @Autowired
    private CustomerManageDao customerManageDao;

    public List<Customer> adminOrSaleGetCustomerList(int index, String group, String state, String account_Prefix) {
        return customerManageDao.adminOrSaleGetCustomerList(index, group, state, account_Prefix);
    }

    public List<Customer> clientGetCustomerList(int index, String group, String state, String account_Prefix, String account_suffix) {
        return customerManageDao.clientGetCustomerList(index, group, state, account_Prefix, account_suffix);
    }
    public Customer getMoreInfo(String customerID) {
        return customerManageDao.getMoreInfo(customerID);
    }
    public List<Customer> adminOrSalefuzzyQuery(String find,String account_Prefix) {
        return customerManageDao.adminOrSalefuzzyQuery(find,account_Prefix);
    }
    public List<Customer> clientFuzzyQuery(String find,String account_Prefix,String account_suffix) {
        return customerManageDao.clientFuzzyQuery(find,account_Prefix,account_suffix);
    }
    public boolean clientOrSaleUpdateCustomer(String customerID, Customer customer) {
        return customerManageDao.clientOrSaleUpdateCustomer(customerID,customer);
    }
    public boolean adminUpdateCustomer(String customerID, Customer customer){
        return customerManageDao.adminUpdateCustomer(customerID,customer);
    }
    public boolean addCustomer(Customer customer, String account_Prefix, String account_suffix, String type) {
        return customerManageDao.addCustomer(customer,account_Prefix,account_suffix,type);
    }
    public boolean delectCustomer(String customerID){
        return customerManageDao.delectCustomer(customerID);
    }
    public int clientGetCount(String group, String state, String account_Prefix, String account_suffix) {
        return customerManageDao.clientGetCount(group,state,account_Prefix,account_suffix);
    }
    public int saleOrAdminGetCount(String group, String state, String account_Prefix) {
        return customerManageDao.saleOrAdminGetCount(group,state,account_Prefix);
    }

    public List<Customer> getAllCustomer(String account_Prefix){
        return customerManageDao.getAllCustomer(account_Prefix);
    }
    public List<Customer> getAllCustomer(String account_Prefix,String account_suffix){
        return customerManageDao.getAllCustomer(account_Prefix,account_suffix);
    }
    public boolean changeState(String customerID,String state){
        return customerManageDao.changeState(customerID,state);
    }
    */
}
