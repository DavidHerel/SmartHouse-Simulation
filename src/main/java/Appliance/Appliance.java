/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.State.ApplianceState;
import Appliance.State.StateOn;
import House.Measurable;

/**
 *Added appType, room.
 * Added consumption of appliance and its break probability and more.. 
 * @author Lister
 * @author Fuji
 */
public abstract class Appliance implements Measurable{

    private final String name;
    int brokenProb; //broken probabilty

    public void setBrokenProb(int brokenProb) {
        this.brokenProb = brokenProb;
    }

    ApplianceState state;   //current appliance state : broken, on, off.
    Documentation documentation;    //contains repair time.
    int workTime;
    int busyTime;
    
    
    public Appliance(int brokenProb, Documentation documentation, int workTime, String name) throws Exception {
        if(brokenProb < 0 || brokenProb > 100){
            throw new Exception("Probability can not be negative or higher than 100%");
        }
        if (documentation.getRepairTime() < 0){
            throw new Exception("Repair time can not be negative");
        }
        if(workTime < 0){
            throw new Exception("Work time can not be negative");
        }
        if (name.equals("") || name.length() > 20){
            throw new Exception("Empty or too long name");
        }
        this.name = name;
        this.brokenProb = brokenProb;
        this.documentation = documentation;
        this.workTime = workTime;
        setState(new StateOn(this));
        busyTime = 0;
    }

    public int getBusyTime() {
        return busyTime;
    }

    public void setBusyTime(int busyTime) {
        this.busyTime = busyTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public abstract ApplianceApi getApi();
    
    public int getWorkTime() {
        return workTime;
    }

    public int getBrokenProb() {
        return brokenProb;
    }
   
    public Documentation getDocumentation() {
        return documentation;
    }

    public void setDocumentation(Documentation doc){
        this.documentation = doc;
    }
    
    public ApplianceState getState() {
        return state;
    }

    public final void setState(ApplianceState state) {
        this.state = state;
    }

    public void setBusyTime(){
        this.busyTime--;
    }

    @Override
    public abstract String toString();

}
