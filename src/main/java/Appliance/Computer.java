/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.ComputerApi;
import Appliance.ApplianceApi.Factories.ComputerApiFactory;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class Computer extends Appliance implements ConsumesOnUseOnly{
    
    private int energyConsumed; 

    public Computer(int brokenProb, Documentation documentation, int workTime, String name) throws Exception {
        super(brokenProb, documentation, workTime, name);
        this.energyConsumed = 0;
    }

    @Override
    public void setEnergyConsumed(int energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    @Override
    public String toString() {
        return "Computer";
    }

    @Override
    public int getConsumption(Measurable obj) {
        return energyConsumed;
    }

    @Override
    public ApplianceApi getApi() {
        return ComputerApiFactory.getApi();
    }
    
    
}
