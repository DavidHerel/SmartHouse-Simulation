/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package House;

import Controls.MainApi;
import Equipment.Equipment;
import Room.Room;
import Sensor.Sensor;
import java.util.ArrayList;

/**
 *
 * @author fuji
 */
public abstract class House implements Measurable{
    
    ArrayList<Room> rooms;

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void setWindows(ArrayList<Window> windows) {
        this.windows = windows;
    }

    public void setApi(MainApi api) {
        this.api = api;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }
    ArrayList<Window> windows;
    MainApi api;
    ArrayList<Equipment> equipment;
    Sensor sensor;
    int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    
    

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public House(ArrayList<Room> rooms, ArrayList<Window> windows, ArrayList<Equipment> equipment, MainApi api) {
        this.rooms = rooms;
        this.windows = windows;
        this.equipment = equipment;
        this.api = api;
        this.sensor = new Sensor(this);
        System.out.println("zde incializace senzoru");
        this.temperature = 22;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public ArrayList<Window> getWindows() {
        return windows;
    }

    public MainApi getApi() {
        return api;
    }

    
    @Override
    public abstract int getConsumption(Measurable obj);

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Sensor getSensor() {
        return sensor;
    }
    
    

    
    
}
