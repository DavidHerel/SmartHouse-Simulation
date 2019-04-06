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
    
    int brokenProb; //broken probabilty

    public void setBrokenProb(int brokenProb) {
        this.brokenProb = brokenProb;
    }

    ApplianceState state;   //current appliance state : broken, on, off.
    Documentation documentation;    //contains repair time.
    int workTime;
    int busyTime;
    
    
    public Appliance(int brokenProb, Documentation documentation, int workTime) {
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
