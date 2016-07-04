package com.gmc.dto;

import java.util.Date;

/**
 * Created by dwj on 7/2/16.
 */
public class Book {
    private int id;
    private String book_name;
    private String type;
    private String bookType;
    private String publicationDate;
    private String author;
    private String press;
    private String price;
    private String version;
    private String state;
    private String purchaseDate;
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", type='" + type + '\'' +
                ", bookType='" + bookType + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", price='" + price + '\'' +
                ", version='" + version + '\'' +
                ", state='" + state + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
