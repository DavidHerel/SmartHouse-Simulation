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

    private final Integer age;

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

    public Pet(String name, PetType petType, House House, Integer age) throws Exception {
        if (name.equals("") || name.length() > 20) {
            throw new Exception("Empty name or longer than 20 characters");
        }
        if (age < 0 || age > 120){
            throw new Exception("Age is less than 0 or higher than 120");
        }
        this.name = name;
        this.petType = petType;
        this.house = House;
        api = new PetApi(this);
        numberTillExhausted = 0;
        this.state = new StateFresh(this);
        this.busyTime = 0;
        this.age = age;
    }

    public Pet(String name, String petType, House House, Integer age) throws Exception {
        if (name.equals("") || name.length() > 20) {
            throw new Exception("Empty name or longer than 20 characters");
        }
        if (age < 0 || age > 120){
            throw new Exception("Age is less than 0 or higher than 120");
        }
        this.name = name;
        if (petType.equals("Dog")){
            this.petType = PetType.DOG;
        }
        else if  (petType.equals("Cat")){
            this.petType = PetType.CAT;
        }
        else if  (petType.equals("Monkey")){
            this.petType = PetType.MONKEY;
        }
        else if (petType.equals("Allien")){
            this.petType = PetType.ALIEN;
        }else{
            throw new Exception("Invalid pet type");
        }
        this.house = House;
        api = new PetApi(this);
        numberTillExhausted = 0;
        this.state = new StateFresh(this);
        this.busyTime = 0;
        this.age = age;
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
