/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Human.State;

import Appliance.Appliance;
import Equipment.Equipment;
import Human.Human;
import Human.HumanAbility;
import Human.Kid;
import Room.Room;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Lister
 */
public class StateFresh extends HumanState{

    public StateFresh(Human human) {
        super(human);
    }

    @Override
    public void visit(Human human) {
              // create random object
      Random randomno = new Random();

      // get next next boolean value 
      boolean value = randomno.nextBoolean();
        if (value){
            human.getApi().doSport();
        }else{
            human.getApi().useRandomAppliance();
        }
        human.setNumberTillExhausted(human.getNumberTillExhausted() + 1);
        if (human.getNumberTillExhausted() >= 10){
            human.setState(new StateTired(human));
        }
        if (human.getHouse().getApi().getTime()%1920 >= 1260){
            human.setState(new StateExhausted(human));
        }
    }
}
