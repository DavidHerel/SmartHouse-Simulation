/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.MassageChair;
import Controls.MainApi;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class MassageChairApi extends ApplianceApi{

    @Override
    public int work(Appliance app) {
        calculateDefect(app);
        //System.out.println("Having a 'm'sážž' in this fancy massage chair!");
        MainApi.getApi().getReporter().gatherReport("Having a 'm'sážž' in this fancy massage chair!");
        ((MassageChair)app).setEnergyConsumed(((MassageChair)app).getConsumption(app)+4*30);
        return 30;
    }

    @Override
    public int broken(Appliance app) {
        return -1;
    }

    @Override
    public Documentation createDocumentation() {
        return new Documentation(420);
    }

    @Override
    public int getConsumption(Measurable obj) {
        int energyConsumed = ((MassageChair)obj).getConsumption(obj);
        ((MassageChair)obj).setEnergyConsumed(0);
        return energyConsumed;
    }

    @Override
    public String toString() {
        return "massage chair";
    }
    
}
