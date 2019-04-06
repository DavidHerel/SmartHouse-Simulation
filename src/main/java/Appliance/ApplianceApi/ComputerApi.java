/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Computer;
import Appliance.Documentation;
import Controls.MainApi;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class ComputerApi extends ApplianceApi {

    public ComputerApi() {
    }

    @Override
    public int work(Appliance app) {
        calculateDefect(app);
        //System.out.println("OMG i have HW to a four credit subject OSY!");
        MainApi.getApi().getReporter().gatherReport("OMG i have HW to a four credit subject OSY!");
        ((Computer)app).setEnergyConsumed(((Computer)app).getConsumption(app)+24*60);
        return 24*60;
    }

    @Override
    public int broken(Appliance app) {
        return -100;
    }

    @Override
    public Documentation createDocumentation() {
        return new Documentation(100);
    }

    @Override
    public int getConsumption(Measurable obj) {
        Computer cmp = (Computer) obj;
        int consump = cmp.getConsumption(cmp);
        cmp.setEnergyConsumed(0);
        return consump;
    }

    @Override
    public String toString() {
        return "computer";
    }
    
}
