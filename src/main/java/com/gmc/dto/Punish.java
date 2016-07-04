package com.gmc.dto;

/**
 * Created by dwj on 7/2/16.
 */
public class Punish {
    private int id;
    private String type;
    private int bookID;
    private String description;
    private double punishAmount;
    private String libraryCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPunishAmount() {
        return punishAmount;
    }

    public void setPunishAmount(double punishAmount) {
        this.punishAmount = punishAmount;
    }

    public String getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(String libraryCard) {
        this.libraryCard = libraryCard;
    }
}
