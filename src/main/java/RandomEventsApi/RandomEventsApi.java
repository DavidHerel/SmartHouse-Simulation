/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomEventsApi;

import RandomEvents.RandomEvent;
import RandomEvents.RandomEventType;
import RandomEventsState.StateActive;
import Sensor.Sensor;

/**
 *
 * @author fuji
 */
public class RandomEventsApi {
    RandomEvent event;

    public RandomEventsApi(RandomEvent event) {
        this.event = event;
    }

    public RandomEvent getEvent() {
        return event;
    }

    public void setEvent(RandomEvent event) {
        this.event = event;
    }
    
    /**Generate some events
     * 
     */
    public void visit(){
        event.getState().visit();
    }
    
    /**Generate some events
     * 
     */
    public void generateEvents(){
        if (event.getBusyTime() <= 0){
            event.setEvent(RandomEventType.randomEvent());    
            event.setNumberTillInactive(event.getNumberTillInactive()+1);
            //System.out.println("Random event " +event.getEvent() +" took an action");
            
            //sensor reacts on event
            if (event.getHouse() == null){
                System.out.println("asa");
            }
            if (event.getHouse().getSensor() == null){
                System.out.println("Sensor null");
            }
            Sensor sensor = event.getHouse().getSensor();
            sensor.getApi().visit(event, sensor);
        }
    }

    /**
     * Goes sleeps and wakes up as active
     */
    public void goSleep() {
        event.setBusyTime(60); 
        event.setState(new StateActive(event));
    }
}
