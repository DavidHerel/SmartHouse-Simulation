/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance;

import Appliance.Accessories.Food.Food;
import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.Factories.FridgeApiFactory;
import Appliance.State.StateBroken;
import Appliance.State.StateIdle;
import Controls.MainApi;
import House.Measurable;
import java.util.ArrayList;

/**
 *
 * @author Lister
 */
public class Fridge extends Appliance{

    private int lastCheckTime;
    private int brokenTime;
    private ArrayList<Food> food;

    public Fridge(int brokenProb, Documentation documentation, int workTime) {
        super(brokenProb, documentation, workTime);
        lastCheckTime = MainApi.getApi().getTime();
        this.food = new ArrayList<>();
        busyTime = 0;
    }    

    public int getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(int lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    @Override
    public void setBusyTime() {
        if(this.state instanceof StateBroken || this.state instanceof StateIdle){
            this.brokenTime++;
        }
    }
    
    @Override
    public void setBusyTime(int routine){
        if(this.state instanceof StateBroken || this.state instanceof StateIdle){
            this.brokenTime++;
        }
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public int getBrokenTime() {
        return brokenTime;
    }

    public void setBrokenTime() {
        this.brokenTime = 0;
    }

    @Override
    public String toString() {
        return "Fridge";
    }

    @Override
    public int getConsumption(Measurable obj) {
        System.err.println("ERROR! this should never HAPPEN!");
        return 0;
    }

    @Override
    public ApplianceApi getApi() {
        return FridgeApiFactory.getApi();
    }
    

}
