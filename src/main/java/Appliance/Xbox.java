/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.Factories.XboxApiFactory;
import Appliance.ApplianceApi.XboxApi;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class Xbox extends Appliance implements ConsumesOnUseOnly{

    private int energyConsumed;

    public Xbox(int brokenProb, Documentation documentation, int workTime) {
        super(brokenProb, documentation, workTime);
        this.energyConsumed = 0;
    }

    @Override
    public int getConsumption(Measurable obj) {
        return energyConsumed;
    }

    @Override
    public void setEnergyConsumed(int energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    @Override
    public String toString() {
        return "Xbox";
    }

    @Override
    public ApplianceApi getApi() {
        return XboxApiFactory.getApi();
    }
    
}
