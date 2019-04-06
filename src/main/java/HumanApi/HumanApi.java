/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanApi;

import Appliance.Accessories.Food.Food;
import Appliance.Appliance;
import Appliance.Fridge;
import Controls.DayTime;
import Controls.MainApi;
import Equipment.Equipment;
import Human.CurrentAction;
import Human.Human;
import Human.HumanAbility;
import Human.Kid;
import Human.State.StateExhausted;
import Human.State.StateFresh;
import Room.Room;
import Transport.Machines;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author fuji
 */
public class HumanApi {
    Human human;

    public HumanApi(Human human) {
        this.human = human;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }
    
    /**
     * Generate events
     */
    public void visit(){
        human.getState().visit(human);
    }
    
    /** Used random free appliance
     * 
     */
    public void useRandomAppliance(){
        
        //finds random room with free appliance
        Room randomRoom = findRandomRoomWithAppliance();
        if (randomRoom == null){
            takeNap();
            return;
        }
        
        //finds random appliance
        Appliance randomApp = findRandomFreeAppliance(randomRoom.getAppliance());
        if (randomApp == null){
            takeNap();
            return;
        }
        
        human.setAction(new CurrentAction("is using" + randomApp.getApi().toString()));
        MainApi.getApi().getReporter().gatherReport(human.getName() + " is using " + randomApp.getApi().toString());
        
        
        //use it
        human.setBusyTime(randomApp.getApi().visit(human, randomApp));
        
        //fridge case -> is empty
        if (randomApp.getClass() == Fridge.class && human.getBusyTime() == 0){
            MainApi.getApi().getReporter().gatherReport(randomApp.getApi().toString() + " is empty");
            fridgeCase(randomApp);
        }
        
        //if it is broken -> repair it and use it
        if (human.getBusyTime()< 0){
            
            MainApi.getApi().getReporter().gatherReport(randomApp.getApi().toString() + " broked during using.");
            if (human.getAbilities().contains(HumanAbility.CAN_REPAIR)){
                repairAppliance(randomApp);
                MainApi.getApi().getReporter().gatherReport(randomApp.getApi().toString() + " was repaired by " + human.getName());
                //use it
                MainApi.getApi().getReporter().gatherReport(human.getName() + " uses " + randomApp.getApi().toString() +" again.");
                human.setBusyTime(human.getBusyTime() + randomApp.getApi().visit(human, randomApp));
                
                
            }else{
                MainApi.getApi().getReporter().gatherReport(human.getName() + " is calling adult to repair it.");
                callAdultForRepair(randomApp);
                
                MainApi.getApi().getReporter().gatherReport(human.getName() + " uses " + randomApp.getApi().toString() +" again.");
                human.setBusyTime(randomApp.getApi().visit(human, randomApp));
            }

        }
        //set busy time on appliance
        randomApp.setBusyTime(human.getBusyTime());
        
        //actualize lastusedappliance
        human.setLastUsedApliance(randomApp);
    }
    
    /**
     * Human goes sleeps
     */
    public void goSleep(){
        //count time to sleep to 8:00 AM
        int currTime = human.getHouse().getApi().getTime();
        int timeToEightClock = 1920-(currTime%1920);
        
        //set it
        human.setBusyTime(timeToEightClock);
        
        //refresh state
        human.setState(new StateFresh(human));
        
        //refresh numberstillexhausted
        human.setNumberTillExhausted(0);
        human.setAction(new CurrentAction("sleeps to 8:00 AM"));
        MainApi.getApi().getReporter().gatherReport(human.getName() + " goes sleep to 8:00 AM");
    }

    /**
     * Repair selected appliance
     * @param app 
     */
    public void repairAppliance(Appliance app){
        if (human.getAbilities().contains(HumanAbility.CAN_REPAIR)){
            MainApi.getApi().getReporter().gatherReport(human.getName() + " repaired " + app.getApi().toString());
            human.setAction(new CurrentAction("is repairing " + app.getApi().toString()));
            human.setBusyTime(app.getApi().repair(app));
        }
    }
    
    
    /**
     * Human does sport 
     */
    public void doSport(){
        int temp = 0;
        MainApi.getApi().getReporter().gatherReport(human.getName() + " wants to do sport.");
        //if can sport
        if (human.getAbilities().contains(HumanAbility.CAN_SPORT)){
            
            //find sport equipment
            for (Equipment equipment : human.getHouse().getEquipment()){
                
                //if found -> set busytime
                if (equipment.getBusyTime() == 0){
                    temp++;
                    if (human.getClass()==Kid.class){
                        human.setBusyTime(30);
                        MainApi.getApi().getReporter().gatherReport(equipment.toString() + " was found");
                        MainApi.getApi().getReporter().gatherReport(human.getName() + " is going to use it.");
                    }else{
                        human.setBusyTime(60);
                        MainApi.getApi().getReporter().gatherReport(equipment.toString() + " was found");
                        MainApi.getApi().getReporter().gatherReport(human.getName() + " is going to use it.");
                    }
                    human.setAction(new CurrentAction("is doing sport with " + equipment.toString()));
                    equipment.setBusyTime(human.getBusyTime());
                    break;
                }
            }
            // if no free equipment -> goes sleeps
            if (temp == 0){
                MainApi.getApi().getReporter().gatherReport("No free equipment was found");
                takeNap();
            }
        } else{
            //cannot
            MainApi.getApi().getReporter().gatherReport("You cant do sport");
        }
    }
    
    /**Acts for a fridge
     * 
     * @param app 
     */
    public void fridgeCase(Appliance app){
        for (Machines e : human.getHouse().getApi().getMachines()){
            if (e.getBusyTime() <= 0){
                MainApi.getApi().getReporter().gatherReport(human.getName() + "found free " + e.toString() + " it will take only " + e.getSpeed() + " minutes.");
                human.setBusyTime(e.getSpeed());
                e.setBusyTime(e.getSpeed());
                ArrayList<Food> food = new ArrayList<Food>();
                MainApi.getApi().getReporter().gatherReport(human.getName() + "bought food and will fill fridge");
                human.setAction(new CurrentAction("travels to Shop for food and then fills it"));
                //fill the fridge
                for(int i = 0; i < 10; i++){
                    food.add(new Food());
                }
                return;
            }
        }
        
        MainApi.getApi().getReporter().gatherReport(human.getName() + " didnt found free machine");
        MainApi.getApi().getReporter().gatherReport(human.getName() + "has to go by their own it will take 60 minutes");
        human.setBusyTime(60);
        ArrayList<Food> food = new ArrayList<Food>();

        MainApi.getApi().getReporter().gatherReport(human.getName() + "bought food and will fill fridge");
        human.setAction(new CurrentAction("travels to Shop for food and then fills it"));
        //fill the fridge
        for(int i = 0; i < 10; i++){
            food.add(new Food());
            MainApi.getApi().getReporter().gatherReport("Food " + food.get(i).toString() + " was added.");
        }
        
    }
    
    /**
     * Find random room with appliance
     * @return 
     */
    public Room findRandomRoomWithAppliance(){
        ArrayList<Room> rooms = new ArrayList<>();
        int temp = 0;
        //loop rooms
        for (Room room : human.getHouse().getRooms()){
            
            //room with appliances
            if (room.getAppliance().size() > 0){
                
                //finding free appliances
                for (Appliance app : room.getAppliance()){
                    if (app.getBusyTime() == 0){
                        rooms.add(room);
                        temp++;
                        break;
                    }
                }
            }
        }
        //if no room with free appliance
        if (temp == 0){
            System.out.println("No room with free appliance was found.");
            return null;
        }
        //else return random
        Collections.shuffle(rooms);
        return rooms.get(0);
    }
    
    /**Finds random free appliance in room
     * 
     * @param appliances
     * @return 
     */
    public Appliance findRandomFreeAppliance(ArrayList<Appliance> appliances) {
        Collections.shuffle(appliances);
        
        //loop from all appliances
        for (Appliance app : appliances){
            if (app.getBusyTime() == 0){
                return app;
            }
        }
        System.out.println("No free appliance was found.");
        return null;
    }
    
    /**
     * Call adult to repair it
     * @param app 
     */
    public void callAdultForRepair(Appliance app){
        for (Human human : human.getHouse().getApi().getPeople()){
            if (human.getBusyTime() == 0){
                MainApi.getApi().getReporter().gatherReport("Adult" + human.getName() + "finded and goes to repair it");
                repairAppliance(app);
            }
        }
        MainApi.getApi().getReporter().gatherReport("All adults are busy -> nobody can repair it now");
    }

    public void takeNap() {
        //set it
        human.setBusyTime(60);
        
        //refresh state
        human.setState(new StateFresh(human));
        
        //refresh numberstillexhausted
        human.setNumberTillExhausted(0);
        MainApi.getApi().getReporter().gatherReport(human.getName() + " takes a nap.");
        if (human.getHouse().getApi().getTime()%1920 >= 1260){
            human.setState(new StateExhausted(human));
        }
        
    }

}
