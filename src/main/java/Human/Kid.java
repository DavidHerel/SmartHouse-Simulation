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
public class Kid extends Human{
        
    @Override
    public ArrayList<HumanAbility> getAbilities() {
        return abilities;
    }

    public Kid(ArrayList<HumanAbility> abilities, String name, House house, Integer age, String gender) {
        super(abilities, name, house, age, gender);
        this.busyTime = 0;
        this.state = new StateFresh(this);
    }
    
}
