package com.gmc.dto;

/**
 * Created by dwj on 7/2/16.
 */
public class Reservations {
    private int id;
    private int bookID;
    private String libraryCard;
    private String reservationsTime;
    private String bookName;

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", bookID=" + bookID +
                ", libraryCard='" + libraryCard + '\'' +
                ", reservationsTime='" + reservationsTime + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(String libraryCard) {
        this.libraryCard = libraryCard;
    }

    public String getReservationsTime() {
        return reservationsTime;
    }

    public void setReservationsTime(String reservationsTime) {
        this.reservationsTime = reservationsTime;
    }
}
