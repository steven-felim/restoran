package model.classes;

import java.util.Calendar;

abstract class Scedule {
    private int roomID;
    private int tableNo;
    private Calendar bookDate;

    public Scedule(int roomID, int tableNo, Calendar bookDate) {
        this.roomID = roomID;
        this.tableNo = tableNo;
        this.bookDate = bookDate;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public Calendar getBookDate() {
        return bookDate;
    }

    public void setBookDate(Calendar bookDate) {
        this.bookDate = bookDate;
    }
}
