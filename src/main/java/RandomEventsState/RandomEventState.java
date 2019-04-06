/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomEventsState;

import RandomEvents.RandomEvent;

/**
 *
 * @author fuji
 */
public abstract class RandomEventState {
    RandomEvent event;

    public RandomEventState(RandomEvent event) {
        this.event = event;
    }

    public RandomEvent getEvent() {
        return event;
    }

    public void setEvent(RandomEvent event) {
        this.event = event;
    }
    
    public abstract void visit();
}
