package com.gmc.service;

import com.gmc.dao.BookManageDao;
import com.gmc.dto.Book;
import java.lang.*;

import com.gmc.dto.BorrowList;
import com.gmc.dto.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by dwj on 7/2/16.
 */
@Service
public class BookManageSrv {
    @Autowired
    private BookManageDao bookManageDao;
    public List<Book> search(String type,String text){

        String find = "%" + text +"%";
        String sql = null;
        Object[] objects = null;
        if (type.equals("all")){
            sql = "select * from book where book_name like ? or author like ? or bookType like ?";
            objects = new Object[]{find,find,find};
        }else if (type.equals("bookName")){
            sql = "select * from book where book_name like ?";
            objects = new Object[]{find};

        }else if (type.equals("author")){
            sql = "select * from book where author like ?";
            objects = new Object[]{find};
        }else if (type.equals("bookType")){
            sql = "select * from book where bookType like ?";
            objects = new Object[]{find};
        }

        return bookManageDao.search(sql,objects);

    }
    public String reserve(int id,HttpSession httpSession){
        Object [] objects = null;
        String sql = null;
        int credit = (int) httpSession.getAttribute("credit");
        if (credit < 60){
            return "信誉值不够,预订失败";
        }else {
            sql = "insert into reservations(bookID,libraryCard,reservationsTime) values(?,?,?)";
            objects = new Object[]{id, httpSession.getAttribute("libraryCard"), new Date()};
            if (bookManageDao.reserve(sql, objects)) {
                return "预订成功";
            } else
                return "未知错误";
        }
    }
    public String rent(int id,HttpSession httpSession){
        Object [] objects = null;
        String sql = null;
        int credit = (int) httpSession.getAttribute("credit");
        if (credit < 90){
            return "信誉值不够,租用失败";
        }else {
            sql = "insert into borrowList(bookID,libraryCard,borrowTime) values(?,?,?)";
            objects = new Object[]{id, httpSession.getAttribute("libraryCard"), new Date()};
            if (bookManageDao.rent(sql, objects)) {
                sql = "update book set state = ? where id = ?";
                objects = new Object[]{"不可借",id};
                if (bookManageDao.update(sql,objects)) {
                    return "结束成功";
                }
            }
        }
        return "未知错误";
    }
    public List<Reservations> reservetionsList(HttpSession httpSession){
        String sql = null;
        Object[] objects = null;
        sql = "select book.book_name,reservations.reservationsTime from book,reservations where book.id=reservations.bookID and reservations.libraryCard = ?";
        objects = new Object[]{httpSession.getAttribute("libraryCard")};

        return bookManageDao.reservationsList(sql,objects);
    }
    public List<BorrowList> borrowList(HttpSession httpSession){
        String sql = null;
        Object[] objects = null;
        sql = "select book.book_name,borrowList.borrowTime,borrowList.returnTime from book,borrowList where book.id=borrowList.bookID and borrowList.libraryCard = ?";
        objects = new Object[]{httpSession.getAttribute("libraryCard")};

        return bookManageDao.borrowList(sql,objects);
    }
}
