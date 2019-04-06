/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Accessories.CDs.CD;
import Appliance.Appliance;
import Appliance.CDPlayer;
import Appliance.Documentation;
import Controls.MainApi;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class CDPlayerApi extends ApplianceApi{

    
    @Override
    public int work(Appliance app) {
        CD cd = new CD();
        int listeningTime = cd.getCDLength();
        //System.out.println("Listening to " + cd.toString() + " now!");
        MainApi.getApi().getReporter().gatherReport("Listening to " + cd.toString() + " now!");
        ((CDPlayer)app).setEnergyConsumed(((CDPlayer)app).getConsumption(app)+listeningTime);
        calculateDefect(app);
        return listeningTime;
    }

    @Override
    public int broken(Appliance app) {
        return -4;
    }

    @Override
    public Documentation createDocumentation() {
        return new Documentation(45);
    }

    @Override
    public int getConsumption(Measurable cPlayer) {
        int consumed = ((CDPlayer)cPlayer).getConsumption(cPlayer);
        ((CDPlayer)cPlayer).setEnergyConsumed(0);
        return consumed;
    }

    @Override
    public String toString() {
        return "CD player";
    }
    
    
}
