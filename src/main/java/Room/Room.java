/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Room;

import Furniture.Furniture;
import Room.RoomType;
import Appliance.Appliance;
import House.Measurable;
import java.util.ArrayList;

/**
 * Added floorNumber and furnitures
 * Inhabitans removed -> class Creature will have atribute where he is
 * @author Lister 
 * @author Fuji
 */
public class Room implements Measurable{

    public ArrayList<Furniture> getFurniture() {
        return furniture;
    }

    public void setFurniture(ArrayList<Furniture> furniture) {
        this.furniture = furniture;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    
    private final RoomType roomType;
    private ArrayList<Appliance> appliance;
    private ArrayList<Furniture> furniture;
    private int floorNumber;
    private final int roomId;

    public Room(RoomType roomType, ArrayList<Appliance> appliance, ArrayList<Furniture> furniture, int floorNumber, int roomId) {
        this.roomType = roomType;
        this.appliance = appliance;
        this.furniture = furniture;
        this.floorNumber = floorNumber;
        this.roomId = roomId;
    }

    public ArrayList<Appliance> getAppliance() {
        return appliance;
    }

    public RoomType getRoomType() {
        return roomType;
    }
    

    public void addFurniture(Furniture furnt){
        this.furniture.add(furnt);
    }
    
    public void removeFurniture(Furniture furnt){
        furniture.remove(furnt);
    }
    
    public void addAppliance(Appliance appliance){
        this.appliance.add(appliance);
    }
    
    public void removeAppliance(Appliance appliance){
        this.appliance.remove(appliance);

    }

    @Override
    public int getConsumption(Measurable obj) {
        
        int roomConsump = 0;        
        roomConsump = appliance.stream().map((app) -> app.getApi().getConsumption(app)).reduce(roomConsump, Integer::sum);
        return roomConsump;
    }
}
