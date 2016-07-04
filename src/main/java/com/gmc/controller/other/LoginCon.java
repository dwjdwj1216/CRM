package com.gmc.controller.other;

import com.gmc.dto.User;
import com.gmc.service.LoginSrv;
//import com.google.code.kaptcha.Constants;
//import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by 顾梦超 on 2016/3/31.
 */

@Controller
public class LoginCon {


    @Autowired
    private LoginSrv loginSrv;

    //    @Autowired
//    private Producer captchaProducer = null;
    /*
    * 返回注册页面
    * */
    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        return "index";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)

    /*
    * 登陆检查
    * */
    public String loginCheck(User user, Model model, HttpSession httpSession) {
        httpSession.setMaxInactiveInterval(60*60*24);
        User u = loginSrv.Login(user);
        if (u == null) {
            model.addAttribute("error", "用户名或密码错误");
            return "/index";
        } else {

            model.addAttribute("role", u.getRole());
            httpSession.setAttribute("role", u.getRole());
            httpSession.setAttribute("credit",u.getCredit());
            httpSession.setAttribute("rentNumber",u.getRentNumber());
            httpSession.setAttribute("libraryCard",u.getLibraryCard());
            httpSession.setAttribute("reserveNumber",u.getReserveNumber());
            httpSession.setAttribute("name", u.getRealName());
            model.addAttribute("name", u.getRealName());
            httpSession.setAttribute("username",u.getUsername());
            if (u.getRole().equals("学生")||u.getRole().equals("教师")) {
                return "/user/index";
            }else if (u.getRole().equals("admin")) {
                return "/admin/index";
            }
            return "index";
        }


    }


}
