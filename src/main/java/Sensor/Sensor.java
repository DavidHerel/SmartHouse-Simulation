/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import House.House;
import RandomEvents.RandomEvent;

/**
 *
 * @author fuji
 */
public class Sensor {
    
    private RandomEvent event;
    private final House house;
    private final SensorApi api;

    public Sensor(House house) {
        this.house = house;
        this.api = new SensorApi();
    }

    public SensorApi getApi() {
        return api;
    }
/**TODO
 * -react on events from outside
 * 
 * @param event
 */
    public void visit(RandomEvent event){
        

    }

    public RandomEvent getEvent() {
        return event;
    }

    public void setEvent(RandomEvent event) {
        this.event = event;
    }

    public House getHouse() {
        return house;
    }
    
    
}
