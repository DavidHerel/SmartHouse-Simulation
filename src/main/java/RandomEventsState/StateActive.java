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
public class StateActive extends RandomEventState{
    
    public StateActive(RandomEvent event) {
        super(event);
    }

    @Override
    public void visit() {
        event.getApi().generateEvents();
        if (event.getNumberTillInactive() >= 1){
            event.setState(new StateInactive(event));
        }
    }
    
}
