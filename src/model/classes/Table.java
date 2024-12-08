package model.classes;

import java.util.Calendar;

public class Table {
    int tableID;
    int tableNo;
    Room room;

    public Table(int tableID, int tableNo, Room room) {
        this.tableID = tableID;
        this.tableNo = tableNo;
        this.room = room;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}