package com.gmc.dto;

import org.hibernate.annotations.BatchSize;
import org.hibernate.ejb.criteria.expression.function.AggregationFunction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 戴王炯 on 2016/3/31.
 */
@Component
public class User implements Serializable {
    private String username;
    private String password;
    private String libraryCard;
    private String realName;
    private String phoneNumber;
    private String role;
    private String email;
    private int rentNumber;
    private int credit;
    private int reserveNumber;

    public int getReserveNumber() {
        return reserveNumber;
    }

    public void setReserveNumber(int reserveNumber) {
        this.reserveNumber = reserveNumber;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(String libID) {
        this.libraryCard = libID;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRentNumber() {
        return rentNumber;
    }

    public void setRentNumber(int rentNumber) {
        this.rentNumber = rentNumber;
    }
}
