/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.State.StateBroken;
import Appliance.State.StateOn;
import Controls.MainApi;
import House.Measurable;
import Human.Human;
import java.util.Random;

/**
 *
 * @author Lister
 */
public abstract class ApplianceApi implements Measurable{
    
     /**
     * Method for standard
     * appliance behavior
     * @param app
     * @return 
     */
    public abstract int work(Appliance app);
    
     /**
     * Method for broken 
     * appliance behavior
     * @param app
     * @return 
     */
    public abstract int broken(Appliance app);
    
     /**
     * Creates documentation for 
     * current appliance. Documentation
     * contains repair time.
     * @return 
     */
    public abstract Documentation createDocumentation();
    
    public int visit(Human human, Appliance app){
        if(human == null){
            System.err.println("Non-existant human can't use appliance!");
            return 0;
        }    
        return app.getState().visit(human);
    }
    
        
    
    /** Checks consumption
     * Returns how much power
     * was consumed since last check
     * @return
     */
    @Override
    public abstract int getConsumption(Measurable obj);
    
    
    /**
     * Repairs appliance, sets its state to On
     * if documentation repair time is less than 0, appliance is unreparable
     * and needs to be replaced
     * @param app
     * @return 
     * returns time needed for reparation 
     */
    public int repair(Appliance app){
        
        app.setDocumentation(app.getDocumentation() == null ? app.getApi().createDocumentation() : app.getDocumentation());
        
        if(app.getDocumentation().getRepairTime() >= 0){
            app.setState(new StateOn(app));
        }
        //System.out.println("Time repair "+ app.getDocumentation().getRepairTime());
        return app.getDocumentation().getRepairTime();
    }

    public void calculateDefect(Appliance app){
        Random rand = new Random();
        int value = rand.nextInt(100)+1;
        
        if(value < app.getBrokenProb()){
            app.setState(new StateBroken(app));
            //System.out.println(app.toString() + " is broken now!");
            MainApi.getApi().getReporter().gatherReport(app.toString() + " is broken now!");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public abstract String toString();
    
    
}
