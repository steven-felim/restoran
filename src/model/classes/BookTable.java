import java.util.Calendar;

public class BookTable {
    private int bookID;
    private Room room;
    private User user;
    private Date date;
    private BookStatus status;

    
    public BookTable(int bookID, Room room, User user, Date date, BookStatus status) {
        this.bookID = bookID;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
