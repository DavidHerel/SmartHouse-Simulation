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
public abstract class HumanState {
    
    Human concreteHuman;

    public HumanState(Human human) {
        this.concreteHuman = human;
    }

    public Human getConcreteHuman() {
        return concreteHuman;
    }

    public void setConcreteHuman(Human concreteHuman) {
        this.concreteHuman = concreteHuman;
    }
   
    
    public abstract void visit(Human human);
}
