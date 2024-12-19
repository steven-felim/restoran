package model.classes;

public class Table {
    String tableID;
    int tableNo;

    public Table(String tableID, int tableNo) {
        this.tableID = tableID;
        this.tableNo = tableNo;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
}