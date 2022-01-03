/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.CoffeeMakerApi;
import Appliance.ApplianceApi.Factories.CoffeeMakerApiFactory;
import House.Measurable;



/**
 *
 * @author Lister
 */
public class CoffeeMaker extends Appliance implements ConsumesOnUseOnly{
    
    private int energyConsumed;

    public CoffeeMaker(int brokenProb, Documentation documentation, int workTime, String name) throws Exception {
        super(brokenProb, documentation, workTime, name);
        busyTime = 0;
        energyConsumed = 0;
    }

    @Override
    public void setEnergyConsumed(int energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    @Override
    public String toString() {
        return "Coffee maker";
    }

    @Override
    public int getConsumption(Measurable obj) {
        return energyConsumed;
    }

    @Override
    public ApplianceApi getApi() {
        return CoffeeMakerApiFactory.getApi();
    }
}
