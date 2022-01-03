/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Human;

import Appliance.Appliance;
import Equipment.Equipment;
import House.House;
import Human.State.StateFresh;
import Room.Room;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author fuji
 */
public class Adult extends Human{
    
    @Override
    public ArrayList<HumanAbility> getAbilities() {
        return abilities;
    }

    public Adult(ArrayList<HumanAbility> abilities, String name, House house, Integer age) {
        super(abilities, name, house, age);
        this.busyTime = 0;
        this.state = new StateFresh(this);
    }
    


}
