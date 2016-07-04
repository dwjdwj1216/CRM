package com.gmc.controller.other;

import com.gmc.dto.User;
import com.gmc.service.RegistorSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 顾梦超 on 2016/5/7.
 */
@Controller
public class Registor {
    @Autowired
    private RegistorSrv registorSrv;
    @RequestMapping(value = "/registor",method = RequestMethod.GET)
    public String resgitor(Model model){
        model.addAttribute("User",new User());
        return "/registor";
    }
    @RequestMapping(value = "/registor",method = RequestMethod.POST)
    public String registor(Model model,User user) {
        String error= registorSrv.registor(user);
        if(error.equals("注册成功")){
            model.addAttribute("account",error);
            return "/index";
        }
        System.out.println("dsfasdkfjlasfjalsf");
        System.out.println(error);
        model.addAttribute("error",error);
        return "/registor";
    }
}
