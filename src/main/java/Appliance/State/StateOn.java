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
public class StateOn extends ApplianceState{

    public StateOn(Appliance app) {
        super(app);
    }

    /**
     * Human interacts with functioning appliance
     * appliance works properly -> work func called
     * @return 
     * @returns time needed to perform the action
    */
    @Override
    public int visit(Human human){
        return this.concreteAppliance.getApi().work(this.concreteAppliance);
    }
    
}
