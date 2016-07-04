//package com.gmc.controller.admin;
//
//import com.gmc.dto.User;
//import com.gmc.service.UserManageSrv;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.sql.Driver;
//import java.util.List;
//
///**
// * Created by 顾梦超 on 2016/4/23.
// */
//@Controller
//public class UserManageCon {
//    @Autowired
//    UserManageSrv userManageSrv;
//
//    /*
//   * 管理员
//   * 返回个人用户信息
//   * */
//    @RequestMapping(value = "/admin/editpersoninfo/{account}", method = RequestMethod.GET)
//    public String getInfo(@PathVariable String account, Model model) {
//        User user = userManageSrv.getUserInfo(account);
//        model.addAttribute("user", user);
//        model.addAttribute("result", "");
//        return "/admin/editPersonInfo";
//    }
//
//    /*
//    * 管理员
//    * 更新个人用户信息
//    * */
//    @RequestMapping(value = "/admin/updateUser/{account}", method = RequestMethod.POST)
//    public String updatePersonInfo(User user, @PathVariable String account, Model model) {
//        model.addAttribute("user", user);
//        if (userManageSrv.updateUserInfo(user, account)) {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改成功\");\n" +
//                    "</script>");
//
//            return "/admin/editPersonInfo";
//        } else {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改失败\");\n" +
//                    "</script>");
//            return "/admin/editPersonInfo";
//        }
//
//    }
//
//
//    /*
//    * 管理员
//    * 返回分类的用户信息
//    * */
//    @RequestMapping(value = "/admin/userinformation/{group}/{index}", method = RequestMethod.GET)
//    public String allUserInfo(Model model, @PathVariable String index, @PathVariable String group, HttpSession session) {
//        String account_Prefix = (String) session.getAttribute("account_Prefix");
//        System.out.println(account_Prefix);
//        List<User> users = userManageSrv.allUserInfo(Integer.parseInt(index), group, account_Prefix);
//        model.addAttribute("users", users);
//        model.addAttribute("group", group);
//        model.addAttribute("page", index);
//        int t = userManageSrv.getCount(group, account_Prefix);
//        if (t % 15 == 0) {
//            t = t / 15;
//        } else t = t / 15 + 1;
//        model.addAttribute("count", t);
//        return "/admin/allUserInfo";
//
//
//    }
//
//    /*
//  * 管理员
//  * 更改密码
//  * */
//    @RequestMapping(value = "/admin/changepassword/{account}", method = RequestMethod.GET)
//    public String getchangepwd(@PathVariable String account, Model model) {
//        model.addAttribute("account", account);
//        return "/admin/changePwd";
//
//    }
//
//    @RequestMapping(value = "/admin/changepassword/{account}", method = RequestMethod.POST)
//    public String changePws(@PathVariable String account, @RequestParam("password") String pwd, @RequestParam("re_password") String repwd, Model model) {
//        model.addAttribute("account", account);
//        if (pwd != null && !pwd.equals("") && repwd != null && !repwd.equals("") && pwd.equals(repwd) && userManageSrv.changePwd(account, pwd)) {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改成功\");\n" +
//                    "</script>");
//            model.addAttribute("url", "/admin/editpersoninfo/" + account);
//        } else {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改失败\");\n" +
//                    "</script>");
//            model.addAttribute("url", "/admin/changepassword/" + account);
//        }
//
//
//        return "/redirect";
//    }
//
//    @RequestMapping(value = "/admin/handover/{userID}", method = RequestMethod.GET)
//    public String handover(@PathVariable String userID, Model model, HttpSession session) {
//        model.addAttribute("userID",userID);
//        String account_Prefix = (String) session.getAttribute("account_Prefix");
//        return "/admin/handover";
//    }
//
//    @RequestMapping(value = "/admin/handover/{userID}", method = RequestMethod.POST)
//    public String handover(@PathVariable String userID, Model model, HttpSession session, String account) {
//        String account_Prefix = (String) session.getAttribute("account_Prefix");
//        if (userManageSrv.handover(account_Prefix, userID, account.substring(account.indexOf("_")+1))) {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改成功\");\n" +
//                    "</script>");
//            model.addAttribute("url", "/admin/userinformation/all/1");
//        } else {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改失败\");\n" +
//                    "</script>");
//            model.addAttribute("url", "/admin/handover/" + userID);
//        }
//        return "/redirect";
//    }
//
//
//    /*
//   * 管理员
//   * 修改用户状态
//   * */
//    @RequestMapping(value = "/admin/changestatus/{account}/{status}", method = RequestMethod.GET)
//    public String changeStatus(@PathVariable String account, @PathVariable String status, Model model) {
//        Driver driver;
//        System.out.println(account);
//        System.out.println(status);
//        if (status.equals("1"))
//            status = "0";
//        else status = "1";
//        if (userManageSrv.updateStatus(account, status)) {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改成功\");\n" +
//                    "</script>");
//
//        } else {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改失败\");\n" +
//                    "</script>");
//        }
//        model.addAttribute("url", "/admin/userinformation/all/1");
//        return "/redirect";
//    }
//
//
//    /*
//      * 管理员
//      * 模糊查询
//      * */
//    @RequestMapping(value = "/admin/fuzzyquery", method = RequestMethod.POST)
//    public String fuzzyQuery(String find, Model model, HttpSession session) {
//        String account_Prefix = (String) session.getAttribute("account_Prefix");
//        model.addAttribute("users", userManageSrv.fuzzyQuery(find, account_Prefix));
//        model.addAttribute("page", 1);
//        return "/admin/allUserInfo";
//    }
//
//}
