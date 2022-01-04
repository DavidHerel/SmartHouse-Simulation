/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomEvents;

import House.House;
import RandomEventsApi.RandomEventsApi;
import RandomEventsState.RandomEventState;
import RandomEventsState.StateActive;
import java.util.ArrayList;
import java.util.Arrays;

/** Class for representing randomEvents
 *
 * @author fuji
 */
public class RandomEvent {
    private final Integer strength;
    RandomEventType event;
    RandomEventsApi api;

    public void setHouse(House house) {
        this.house = house;
    }
    int busyTime;
    House house;
    RandomEventState state;
    int numberTillInactive;

    public int getNumberTillInactive() {
        return numberTillInactive;
    }

    public void setNumberTillInactive(int numberTillInactive) {
        this.numberTillInactive = numberTillInactive;
    }


    public House getHouse() {
        return house;
    }


    public RandomEventState getState() {
        return state;
    }

    public void setState(RandomEventState state) {
        this.state = state;
    }

    public RandomEvent(RandomEventType event, House house, Integer strength) {
        this.event = event;
        this.house = house;
        this.busyTime = 0;
        this.api = new RandomEventsApi(this);
        this.state = new StateActive(this);
        this.strength = strength;
        numberTillInactive = 0;
    }

    public RandomEvent(String event, House house, Integer strength) throws Exception {
        if (strength < 0 || strength > 10){
            throw new Exception("Strength can not be negative or bigger than 10");
        }
        if (event.equals("Storm")){
            this.event = RandomEventType.STORM;
        }else if (event.equals("Wind")){
            this.event = RandomEventType.WIND;
        }else if (event.equals("Snow")){
            this.event = RandomEventType.SNOW;
        }else if (event.equals("Sun")){
            this.event = RandomEventType.SUN;
        }else{
            throw new Exception("Uknown event type");
        }

        this.house = house;
        this.busyTime = 0;
        this.api = new RandomEventsApi(this);
        this.state = new StateActive(this);
        this.strength = strength;
        numberTillInactive = 0;
    }

    public RandomEventType getEvent() {
        return event;
    }

    public void setEvent(RandomEventType event) {
        this.event = event;
    }

    public RandomEventsApi getApi() {
        return api;
    }

    public void setApi(RandomEventsApi api) {
        this.api = api;
    }

    public int getBusyTime() {
        return busyTime;
    }

    public void setBusyTime(int busyTime) {
        this.busyTime = busyTime;
    }

}
