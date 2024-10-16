public class Table {
    private int tableNum;
    private SeatCapacity seats;

    public Table(int tableNum, SeatCapacity seats) {
        this.tableNum = tableNum;
        this.seats = seats;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public SeatCapacity getSeats() {
        return seats;
    }

    public void setSeats(SeatCapacity seats) {
        this.seats = seats;
    }
}
