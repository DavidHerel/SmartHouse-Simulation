/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Furniture;

import Room.Room;
import Room.RoomType;

/**
 *
 * @author fuji
 */
public class Furniture {

    public FurnitureType getType() {
        return type;
    }

    public Room getRoom() {
        return room;
    }
    private FurnitureType type;

    public void setType(FurnitureType type) {
        this.type = type;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    private Room room;

    public Furniture(FurnitureType type, Room room) {
        this.type = type;
        this.room = room;
    }
    
    
}
