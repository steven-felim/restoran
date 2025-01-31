package model.classes;

import model.enums.BookStatus;

import java.sql.Time;
import java.util.Date;

public class BookTable {
    private int bookID;
    private String tableID;
    private int userID;
    private int guestID;
    private Date date;
    private Time time;
    private BookStatus status;

    public BookTable(int bookID, String tableID, int userID, int guestID, Date date, Time time, BookStatus status) {
        this.bookID = bookID;
        this.tableID = tableID;
        this.userID = userID;
        this.guestID = guestID;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}