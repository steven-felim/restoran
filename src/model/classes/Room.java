package model.classes;

import model.enums.RoomType;

public class Room {
    String roomID;
    RoomType type;

    public Room(String roomID, RoomType type) {
        this.roomID = roomID;
        this.type = type;
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

}


