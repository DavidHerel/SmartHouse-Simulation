/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.CDPlayerApi;
import Appliance.ApplianceApi.Factories.CDPlayerApiFactory;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class CDPlayer extends Appliance implements ConsumesOnUseOnly{

    private int energyConsumed;
    
    public CDPlayer(int brokenProb, Documentation documentation, int workTime, String name) throws Exception {
        super(brokenProb, documentation, workTime, name);
        this.energyConsumed = 0;
    }

    @Override
    public void setEnergyConsumed(int energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    @Override
    public String toString() {
        return "CD player";
    }

    @Override
    public int getConsumption(Measurable obj) {
        return energyConsumed;
    }

    @Override
    public ApplianceApi getApi() {
        return CDPlayerApiFactory.getApi();
    }
    
}
