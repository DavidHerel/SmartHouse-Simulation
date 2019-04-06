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
public class StateExhausted extends PetState{

    public StateExhausted(Pet pet) {
        super(pet);
    }

    @Override
    public void visit(Pet pet) {
        pet.getApi().goSleep();
    }
    
}
