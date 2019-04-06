/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.State;

import Appliance.Appliance;
import Human.Human;

/**
 *
 * @author Lister
 */
public abstract class ApplianceState {
    
    Appliance concreteAppliance;

    public ApplianceState(Appliance concreteAppliance) {
        this.concreteAppliance = concreteAppliance;
    }

    public Appliance getConcreteAppliance() {
        return concreteAppliance;
    }

    public void setConcreteAppliance(Appliance concreteAppliance) {
        this.concreteAppliance = concreteAppliance;
    }
    
    
    /**
     * Behaves according to current state
     * @param human
     * @return
     */
    public abstract int visit(Human human);
    
}
