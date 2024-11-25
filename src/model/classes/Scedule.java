package model.classes;

import java.util.Calendar;

abstract class Scedule {
    private Room roomID;
    private Table tableNo;
    private Calendar bookDate;

    public Scedule(Room roomID, Table tableNo, Calendar bookDate) {
        this.roomID = roomID;
        this.tableNo = tableNo;
        this.bookDate = bookDate;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public Table getTableNo() {
        return tableNo;
    }

    public void setTableNo(Table tableNo) {
        this.tableNo = tableNo;
    }

    public Calendar getBookDate() {
        return bookDate;
    }

    public void setBookDate(Calendar bookDate) {
        this.bookDate = bookDate;
    }
}
