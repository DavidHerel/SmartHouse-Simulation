/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Human.State;

import Human.Human;

/**
 *
 * @author Lister
 */
public class StateExhausted extends HumanState{

    public StateExhausted(Human human) {
        super(human);
    }

    @Override
    public void visit(Human human) {
        human.getApi().goSleep();
    }
    
    
}
