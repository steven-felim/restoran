package model.classes;

public class Table {
    int tableID;
    int tableNo;

    public Table(int tableID, int tableNo) {
        this.tableID = tableID;
        this.tableNo = tableNo;
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
}