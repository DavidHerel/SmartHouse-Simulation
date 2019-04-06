/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package House.Builder;

import Appliance.Appliance;
import Appliance.CDPlayer;
import Appliance.CoffeeMaker;
import Appliance.Computer;
import Appliance.Documentation;
import Appliance.Fridge;
import Appliance.MassageChair;
import Appliance.Television;
import Appliance.WashingMachine;
import Appliance.Xbox;
import Controls.MainApi;
import Equipment.Equipment;
import Equipment.EquipmentType;
import House.ClassicWindow;
import House.FamilyHouse;
import House.House;
import House.IkeaBlinds;
import House.Window;
import Room.Room;
import Room.RoomType;
import java.util.ArrayList;

/**
 *
 * @author Lister
 */
public class FamilyHouseBuilder extends HouseBuilder{
    
    
    @Override
    public House buildHouse(MainApi api) {
        return new FamilyHouse(createRooms(), createWindows(), createEquipment(), api);
    }

    @Override
    ArrayList<Room> createRooms() {
        ArrayList rooms = new ArrayList<Room>();
        
        Room room;
        
        rooms.add(room = new Room(RoomType.LIVINGROOM, new ArrayList<>(), new ArrayList<>(), 1, 0));
        room.addAppliance(new CDPlayer(2, new Documentation(15), 20));
        room.addAppliance(new Computer(4, new Documentation(30), 40));
        room.addAppliance(new CDPlayer(2, new Documentation(15), 20));
        room.addAppliance(new Computer(4, new Documentation(30), 40));
        room.addAppliance(new Computer(4, new Documentation(30), 40));
        
        rooms.add(room = new Room(RoomType.KITCHEN, new ArrayList<>(), new ArrayList<>(), 1, 1));
        room.addAppliance(new Fridge(6, new Documentation(10), 10));
        room.addAppliance(new MassageChair(6, new Documentation(10), 30));
        room.addAppliance(new Fridge(6, new Documentation(10), 10));
        room.addAppliance(new MassageChair(6, new Documentation(10), 30));
        room.addAppliance(new MassageChair(6, new Documentation(10), 30));
        
        rooms.add(room = new Room(RoomType.BEDROOM, new ArrayList<>(), new ArrayList<>(), 2, 2));
        room.addAppliance(new CoffeeMaker(3, new Documentation(1), 5));
        room.addAppliance(new Television(6, new Documentation(10), 30));
        room.addAppliance(new CoffeeMaker(3, new Documentation(1), 5));
        room.addAppliance(new Television(6, new Documentation(10), 30));
        room.addAppliance(new Television(6, new Documentation(10), 30));
        
        rooms.add(room = new Room(RoomType.HALL, new ArrayList<>(), new ArrayList<>(), 2, 3));
        room.addAppliance(new WashingMachine(5, new Documentation(10), 60));
        room.addAppliance(new Xbox(6, new Documentation(10), 45));
        room.addAppliance(new WashingMachine(5, new Documentation(10), 60));
        room.addAppliance(new Xbox(6, new Documentation(10), 45));
        room.addAppliance(new Xbox(6, new Documentation(10), 45));
        
        return rooms;
    }

    @Override
    ArrayList<Window> createWindows() {
        
        ArrayList<Window> windows = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            windows.add(new ClassicWindow(new IkeaBlinds()));
        }
        return windows;
    }    

    @Override
    ArrayList<Equipment> createEquipment() {
        ArrayList<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment(EquipmentType.SKI,0));
        equipment.add(new Equipment(EquipmentType.BIKE,0));
        equipment.add(new Equipment(EquipmentType.BIKE,0));
        return equipment;
        
    }


}
