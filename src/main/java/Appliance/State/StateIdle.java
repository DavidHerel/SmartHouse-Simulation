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
public class StateIdle extends ApplianceState{

    public StateIdle(Appliance concreteAppliance) {
        super(concreteAppliance);
    }

    @Override
    public int visit(Human human) {
        this.concreteAppliance.setState(new StateOn(this.concreteAppliance));//human just turns on this appliance
        return this.concreteAppliance.getApi().work(this.concreteAppliance);
    }
    
}
