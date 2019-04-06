/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.State;

import Appliance.Appliance;
import Appliance.CoffeeMaker;
import Human.Human;

/**
 *
 * @author Lister
 */
public class StateBroken extends ApplianceState {

    public StateBroken(Appliance app) {
        super(app);
    }

    /**
     * Human interacts with broken appliance,
     * appliance behaves as broken -> calls broken method
     * @param human
     * @returns time needed to discover the appliance is broken 
     */
    @Override
    public int visit(Human human) {
        return this.concreteAppliance.getApi().broken(this.concreteAppliance);
    }
    
}
