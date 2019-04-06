/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Accessories.TvShows.TvShow;
import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.Television;
import Controls.MainApi;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class TelevisionApi extends ApplianceApi{

    @Override
    public int work(Appliance app) {
        calculateDefect(app);
        TvShow tvShow = new TvShow();
        //System.out.println("Watching " + tvShow + " now!");
        MainApi.getApi().getReporter().gatherReport("Watching " + tvShow + " now!");
        int watchTime = tvShow.getMovieTime();
        ((Television)app).setEnergyConsumed( ((Television)app).getConsumption(app)+watchTime);
        
        return watchTime;
    }

    @Override
    public int broken(Appliance app) {
        return -10;
    }

    @Override
    public Documentation createDocumentation() {
        return new Documentation(180);
    }

    @Override
    public int getConsumption(Measurable obj) {
        
        Television tv = (Television) obj;
        
        int consump = tv.getConsumption(tv);
        tv.setEnergyConsumed(0);
        return consump;
    }

    @Override
    public String toString() {
        return "TV";
    }
    
}
