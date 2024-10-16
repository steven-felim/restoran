public class Room {
    String roomID;
    RoomType type;
    Table[] tables;

    public Room(String roomID, RoomType type, Table[] tables) {
        this.roomID = roomID;
        this.type = type;
        this.tables = tables;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public Table[] getTables() {
        return tables;
    }

    public void setTables(Table[] tables) {
        this.tables = tables;
    }
}


