/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetApi;

import Appliance.Appliance;
import Appliance.State.StateBroken;
import Controls.MainApi;
import PetState.StateFresh;
import Pet.Pet;
import Pet.PetType;
import PetState.StateExhausted;
import Room.Room;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author fuji
 */
public class PetApi {
    Pet pet;

    public PetApi(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    /**
     * Generates events
     */
    public void visit(){
        pet.getState().visit(pet);
        
    }
    /**
     * Animal will break something every hour
     */
    public void doRandomStuff(){

        Room randomRoom = findRandomRoomWithAppliance();
          
        //take random appliance from room
        ArrayList<Appliance> appliances = randomRoom.getAppliance();
        Collections.shuffle(appliances);
        Appliance randomApp = appliances.get(0);
        
        //animal broke it
        randomApp.setState(new StateBroken(randomApp));
        
        pet.setBusyTime(60);
        MainApi.getApi().getReporter().gatherReport(pet.getName() + " broke " + randomApp.getApi().toString());
        pet.setNumberTillExhausted(pet.getNumberTillExhausted() + 1);
        
    }
    
    /**
     * Finds random room with appliance
     * @return 
     */
    public Room findRandomRoomWithAppliance(){
        int temp = 0;
        ArrayList<Room> rooms = new ArrayList<>();
        for (Room room : pet.getHouse().getRooms()){
            if (room.getAppliance().size() > 0){
                temp++;
                rooms.add(room);
            }
        }
        if (temp == 0){
            System.out.println("No appliance was found");
            return null;
        }
        Collections.shuffle(rooms);
        return rooms.get(0);
    }
    
    /**
     * Pet goes sleeps
     */
    public void goSleep(){
        //count time to sleep to 8:00 AM
        int currTime = pet.getHouse().getApi().getTime();
        int timeToEightClock = 1920-(currTime%1920);
        
        //set it
        pet.setBusyTime(timeToEightClock);
        
        //refresh state
        pet.setState(new StateFresh(pet));
        
        //refresh numberstillexhausted
        pet.setNumberTillExhausted(0);
        MainApi.getApi().getReporter().gatherReport(pet.getName() + " goes sleep to 8:00 AM");
    }

    
    /*
    * Function, that will make this app more realistic
    * Use it carefuly
    */
    public void slaveTheHumanRace(){
        if (pet.getPetType() == PetType.ALIEN){
            System.out.println("The age of human is over.");
            System.out.println("The time of the allien has come.");
        }
    }
}
