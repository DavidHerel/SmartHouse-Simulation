/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet;

import Appliance.Appliance;
import Appliance.State.StateBroken;
import House.FamilyHouse;
import House.House;
import PetApi.PetApi;
import PetState.PetState;
import PetState.StateFresh;
import Room.Room;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author fuji
 */
public class Pet {

    public void setName(String name) {
        this.name = name;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public void setHouse(House house) {
        this.house = house;
    }
    private String name;
    private PetType petType;
    private House house;
    private PetApi api;
    private int numberTillExhausted;
    private PetState state;
    private int busyTime;

    public int getNumberTillExhausted() {
        return numberTillExhausted;
    }

    public void setNumberTillExhausted(int numberTillExhausted) {
        this.numberTillExhausted = numberTillExhausted;
    }

    public String getName() {
        return name;
    }

    public PetType getPetType() {
        return petType;
    }

    public House getHouse() {
        return house;
    }

    public Pet(String name, PetType petType, House House) {
        this.name = name;
        this.petType = petType;
        this.house = House;
        api = new PetApi(this);
        numberTillExhausted = 0;
        this.state = new StateFresh(this);
        this.busyTime = 0;
    }

    public PetState getState() {
        return state;
    }

    public void setState(PetState state) {
        this.state = state;
    }

    public int getBusyTime() {
        return busyTime;
    }

    public void setBusyTime(int busyTime) {
        this.busyTime = busyTime;
    }

    public PetApi getApi() {
        return api;
    }

    public void setApi(PetApi api) {
        this.api = api;
    }
}
