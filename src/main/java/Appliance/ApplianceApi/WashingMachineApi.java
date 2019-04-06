/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.WashingMachine;
import Controls.MainApi;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class WashingMachineApi extends ApplianceApi{

    @Override
    public int work(Appliance app){
        calculateDefect(app);
        //System.out.println("Setting washing machine to wash clothes!");
        MainApi.getApi().getReporter().gatherReport("Setting washing machine to wash clothes!");
        ((WashingMachine)app).setEnergyConsumed(((WashingMachine)app).getConsumption(app)+5*120);
        app.setBusyTime(120);
        return 10;
    }

    @Override
    public int broken(Appliance app) {
        return -10;
    }

    @Override
    public Documentation createDocumentation() {
        return new Documentation(420);
    }

    @Override
    public int getConsumption(Measurable wMachine) {
        int consumed = ((WashingMachine)wMachine).getConsumption(wMachine);
        ((WashingMachine)wMachine).setEnergyConsumed(0);
        return consumed;
    }

    @Override
    public String toString() {
        return "washing machine";
    }
    
}
