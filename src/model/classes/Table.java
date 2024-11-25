package model.classes;

import java.util.Calendar;

public class Table {
    int tableID;
    Room room;

    public Table(int tableID, Room room) {
        this.tableID = tableID;
        this.room = room;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}