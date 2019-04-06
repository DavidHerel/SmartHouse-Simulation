/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.Factories.MassageChairApiFactory;
import Appliance.ApplianceApi.MassageChairApi;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class MassageChair extends Appliance implements ConsumesOnUseOnly{

    private int energyConsumed;
    
    public MassageChair(int brokenProb, Documentation documentation, int workTime) {
        super(brokenProb, documentation, workTime);
    }

    @Override
    public void setEnergyConsumed(int energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    @Override
    public String toString() {
        return "Massage chair";
    }

    @Override
    public int getConsumption(Measurable obj) {
        return energyConsumed;
    }

    @Override
    public ApplianceApi getApi() {
        return MassageChairApiFactory.getApi();
    }
   
}
