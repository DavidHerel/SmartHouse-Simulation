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
public abstract class PetState {
    Pet pet;

    public PetState(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    public abstract void visit(Pet pet);
}
