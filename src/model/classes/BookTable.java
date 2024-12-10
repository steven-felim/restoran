package model.classes;

import model.enums.BookStatus;
import java.util.Date;

public class BookTable {
    private int bookID;
    private Table table;
    private User user;
    private Date date;
    private BookStatus status;

    
    public BookTable(int bookID, Table table, User user, Date date, BookStatus status) {
        this.bookID = bookID;
        this.table = table;
        this.user = user;
        this.date = date;
        this.status = status;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}