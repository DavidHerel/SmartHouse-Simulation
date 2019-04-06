/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package House.Builder;

import Appliance.Appliance;
import Controls.MainApi;
import Equipment.Equipment;
import House.House;
import House.Window;
import Room.Room;
import java.util.ArrayList;

/**
 *
 * @author Lister
 */
public abstract class HouseBuilder {
    
    public abstract House buildHouse(MainApi api);
    
    abstract ArrayList<Room> createRooms();
    abstract ArrayList<Window> createWindows();
    abstract ArrayList<Equipment> createEquipment();
}
