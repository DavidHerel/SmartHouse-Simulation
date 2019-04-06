/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.CoffeeMaker;
import Appliance.Documentation;
import House.Measurable;

/**
 *
 * @author Lister
 */
public class CoffeeMakerApi extends ApplianceApi{

    public CoffeeMakerApi() {
    }  

    @Override
    public int work(Appliance cMaker) {
           
        calculateDefect(cMaker);
        //System.out.println("Coffee done");
        ((CoffeeMaker)cMaker).setEnergyConsumed(((CoffeeMaker)cMaker).getConsumption(cMaker)+10);  //consumes electricity
        return 1;   //action takes 1 time unit
    }

    @Override
    public String toString() {
        return "CoffeeMaker";
    }

    @Override
    public int broken(Appliance app) {
       // System.err.println("Coffee machine broken! Reparation needed!");
        return -1;   //human discovers immidiately
    }

    @Override
    public Documentation createDocumentation() {
        return new Documentation(10);
    }

    @Override
    public int getConsumption(Measurable cMaker) {
        int consumed = ((CoffeeMaker)cMaker).getConsumption(cMaker);
        ((CoffeeMaker)cMaker).setEnergyConsumed(0);
        return consumed;
    }
    
}
