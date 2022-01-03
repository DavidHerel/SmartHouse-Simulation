/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Human;

import Appliance.Appliance;
import Equipment.Equipment;
import House.House;
import Human.State.HumanState;
import Human.State.StateFresh;
import HumanApi.HumanApi;
import Room.Room;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author fuji
 */
public abstract class Human {

    private final Integer age;
    HumanState state;

    public void setAbilities(ArrayList<HumanAbility> abilities) {
        this.abilities = abilities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setApi(HumanApi api) {
        this.api = api;
    }
    int busyTime;
    ArrayList<HumanAbility> abilities;
    String name;
    House house;
    Appliance lastUsedApliance;
    HumanApi api;
    int numberTillExhausted;
    CurrentAction action;

    public void setState(HumanState state) {
        this.state = state;
    }

    public HumanState getState() {
        return state;
    }

    public HumanApi getApi() {
        return api;
    }

    public Human(ArrayList<HumanAbility> abilities, String name, House house, Integer age) {
        this.busyTime = 0;
        this.state = new StateFresh(this);
        this.abilities = abilities;
        this.name = name;
        this.house = house;
        this.api = new HumanApi(this);
        numberTillExhausted = 0;
        action = new CurrentAction("Does nothing");
        this.age = age;
    }

    public CurrentAction getAction() {
        return action;
    }

    public void setAction(CurrentAction action) {
        this.action = action;
    }

    public Appliance getLastUsedApliance() {
        return lastUsedApliance;
    }

    public House getHouse() {
        return house;
    }
    
    public void setLastUsedApliance(Appliance lastUsedApliance) {
        this.lastUsedApliance = lastUsedApliance;
    }
    
    public ArrayList<HumanAbility> getAbilities() {
        return abilities;
    }
    

    public String getName() {
        return name;
    }

    public int getBusyTime() {
        return busyTime;
    }

    public void setBusyTime(int busyTime) {
        this.busyTime = busyTime;
    }

    public int getNumberTillExhausted() {
        return numberTillExhausted;
    }

    public void setNumberTillExhausted(int numberTillExhausted) {
        this.numberTillExhausted = numberTillExhausted;
    }
    
    
}
