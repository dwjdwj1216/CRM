package com.gmc.controller.other;

import com.gmc.dto.User;
import com.gmc.service.UserManageSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by 顾梦超 on 2016/6/4.
 */
@Controller
public class PersonInfo {
    @Autowired
    UserManageSrv userManageSrv;
    @RequestMapping(value = "/user/selfInfo",method = RequestMethod.GET)
    public String getPersonInfo(HttpSession session, Model model){
        User user =userManageSrv.getInfo(session);
        model.addAttribute("user",user);
        return "/user/selfInfo";
    }
    @RequestMapping(value = "/user/editInfo",method = RequestMethod.POST)
    public String editInfo(String password,String email,String phoneNumber,HttpSession session, Model model){
        if (userManageSrv.editInfo(password,email,phoneNumber,session).equals("修改成功")){
            User user =userManageSrv.getInfo(session);
            model.addAttribute("user",user);
        }
        return "/user/selfInfo";
    }
}
