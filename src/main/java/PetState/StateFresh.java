/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetState;

import Pet.Pet;

/**
 *
 * @author fuji
 */
public class StateFresh extends PetState{

    public StateFresh(Pet pet) {
        super(pet);
    }

    @Override
    public void visit(Pet pet) {
        pet.getApi().doRandomStuff();
        if (pet.getHouse().getApi().getTime()%1920 >= 1260){
            pet.setState(new StateExhausted(pet));
        }
    }
    
}
