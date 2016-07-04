package com.gmc.dao;

import com.gmc.dto.Book;
import com.gmc.dto.BorrowList;
import com.gmc.dto.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dwj on 7/2/16.
 */
@Repository
public class BookManageDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> search(String sql,Object[] objects){

        return jdbcTemplate.query(sql, objects, new RowMapper<Book>() {
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {

                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBook_name(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setVersion(resultSet.getString("version"));
                book.setPress(resultSet.getString("press"));
                book.setPlace(resultSet.getString("place"));
                book.setState(resultSet.getString("state"));
                return book;
            }
        });
    }

    public Boolean reserve(String sql, Object[] objects){

        return jdbcTemplate.update(sql,objects) > 0;
    }
    public Boolean update(String sql, Object[] objects){
        return jdbcTemplate.update(sql,objects) > 0;
    }
    public Boolean rent(String sql, Object[] objects){

        return jdbcTemplate.update(sql,objects) > 0;
    }
    public Book searchByID(String sql,Object[] objects){
        final Book book = new Book();
        jdbcTemplate.query(sql, objects, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                book.setState(resultSet.getString("state"));
                book.setBook_name(resultSet.getString("book_name"));
            }
        });
        return book;
    }

    public List<Reservations> reservationsList(String sql, final Object[] objects){

        return jdbcTemplate.query(sql, objects, new RowMapper<Reservations>() {
            public Reservations mapRow(ResultSet resultSet, int i) throws SQLException {
                Reservations reserve = new Reservations();
                reserve.setBookName(resultSet.getString("book_name"));
                reserve.setReservationsTime(resultSet.getString("reservationsTime"));
                return reserve;
            }
        });
    }
    public List<BorrowList> borrowList(String sql, final Object[] objects){

        return jdbcTemplate.query(sql, objects, new RowMapper<BorrowList>() {
            public BorrowList mapRow(ResultSet resultSet, int i) throws SQLException {
                BorrowList borrowList = new BorrowList();
                borrowList.setBookName(resultSet.getString("book_name"));
                borrowList.setBorrowTime(resultSet.getString("borrowTime"));
                borrowList.setReturnTime(resultSet.getString("returnTime"));
                return borrowList;
            }
        });
    }
}
