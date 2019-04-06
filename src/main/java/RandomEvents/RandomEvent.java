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

    public RandomEvent(RandomEventType event, House house) {
        this.event = event;
        this.house = house;
        this.busyTime = 0;
        this.api = new RandomEventsApi(this);
        this.state = new StateActive(this);
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
