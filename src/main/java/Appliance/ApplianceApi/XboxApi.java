/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Accessories.XboxGames.XboxGame;
import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.Xbox;
import Controls.MainApi;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class XboxApi extends ApplianceApi{

    @Override
    public int work(Appliance app) {
        
        calculateDefect(app);
        XboxGame game = new XboxGame();
        int gameTime = game.getGameTime();
        ((Xbox)app).setEnergyConsumed(app.getConsumption(app)+gameTime*4);
        //System.out.println("Now playing " + game +" now!");
        MainApi.getApi().getReporter().gatherReport("Now playing " + game +" now!");
        return gameTime;
    }

    @Override
    public int broken(Appliance app) {
        return -20;
    }

    @Override
    public Documentation createDocumentation() {
        return new Documentation(50);
    }

    @Override
    public int getConsumption(Measurable obj) {
        
        Xbox xbox = (Xbox) obj;
        
        int consump = xbox.getConsumption(xbox);
        xbox.setEnergyConsumed(0);
        return consump;
    }

    @Override
    public String toString() {
        return "Xbox (n)One";
    }
    
}
