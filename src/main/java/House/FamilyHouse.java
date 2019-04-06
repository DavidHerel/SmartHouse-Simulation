/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package House;

import Appliance.Appliance;
import Controls.MainApi;
import Equipment.Equipment;
import Room.Room;
import Sensor.Sensor;
import java.util.ArrayList;

/** Contains: 2 floors:
 * 1 kitchen
 * 4 bedrooms
 * 1 living room
 * 2 bathrooms
 * @author fuji
 */
public class FamilyHouse extends House{

    public FamilyHouse(ArrayList<Room> rooms, ArrayList<Window> windows, ArrayList<Equipment> equipment, MainApi api) {
        super(rooms, windows, equipment, api);
    }

    @Override
    public int getConsumption(Measurable obj) {
        int houseConsump = 0;
        
        houseConsump = rooms.stream().map((room) -> room.getConsumption(room)).reduce(houseConsump, Integer::sum);  //gets sum of all consumptions
        return houseConsump;
    }

    @Override
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    
}
