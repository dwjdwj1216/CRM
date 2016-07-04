package com.gmc.controller.user;

import com.gmc.dto.Book;
import com.gmc.dto.BorrowList;
import com.gmc.dto.Reservations;
import com.gmc.service.BookManageSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dwj on 7/2/16.
 */
@Controller
public class BookManage {

    @Autowired
    private BookManageSrv bookManageSrv;
    @RequestMapping(value = "/user/search",method = RequestMethod.POST)
    public String loginCheck(String type,String text, Model model, HttpSession httpSession) {
        List<Book> books = bookManageSrv.search(type,text);
        model.addAttribute("books",books);
        model.addAttribute("findResult","1");
        model.addAttribute("type",type);
        model.addAttribute("text",text);
        return "/user/search";
    }
    @RequestMapping(value = "/user/reserveList",method = RequestMethod.GET)
    public String reserveList(Model model, HttpSession httpSession) {
        List<Reservations> reservationses = bookManageSrv.reservetionsList(httpSession);
        model.addAttribute("reserveList",reservationses);
        return "/user/reserveList";
    }

    @RequestMapping(value = "/user/rentList",method = RequestMethod.GET)
    public String rentList(Model model, HttpSession httpSession) {
        List<BorrowList> borrowList = bookManageSrv.borrowList(httpSession);
        model.addAttribute("borrowList",borrowList);
        return "/user/rentList";
    }
    @RequestMapping(value = "/user/search",method = RequestMethod.GET)
    public String loginCheck(String type,String text, Model model) {
        return "/user/search";
    }
    @RequestMapping(value = "/user/reserve/{id}",method = RequestMethod.GET)
    public String reserve(@PathVariable int id, Model model, HttpSession httpSession){
        String message = bookManageSrv.reserve(id,httpSession);
        model.addAttribute("reserveBackMessage",message);
        List<Reservations> reservationses = bookManageSrv.reservetionsList(httpSession);
        System.out.println(reservationses);
        model.addAttribute("reserveList",reservationses);
        return "/user/reserveList";
    }
    @RequestMapping(value = "/user/rent/{id}",method = RequestMethod.GET)
    public String rent(@PathVariable int id, Model model, HttpSession httpSession){
        String message = bookManageSrv.rent(id,httpSession);
        model.addAttribute("rentBackMessage",message);
        List<BorrowList> borrowList = bookManageSrv.borrowList(httpSession);
        System.out.println(borrowList);
        model.addAttribute("borrowList",borrowList);
        return "/user/rentList";
    }
}
