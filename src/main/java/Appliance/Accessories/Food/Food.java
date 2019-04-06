/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.Accessories.Food;

import java.util.Random;

/**
 *
 * @author Lister
 */
public class Food {

    private final FoodEnum foodType;

    public int getEatingTime() {
        return foodType.getTime();
    }
    
    @Override
    public String toString() {
        return ""+foodType ;
    }

    public FoodEnum getFoodType() {
        return foodType;
    }

    public Food(){
        Random rand = new Random();
        int value = rand.nextInt(4); 
        
        switch(value){
            case 0:
                this.foodType = FoodEnum.CHEESE;
                break;
            case 1:
                this.foodType = FoodEnum.HAM;
                break;
            case 3:
                this.foodType = FoodEnum.MEAT;
                break;
            case 4:
                this.foodType = FoodEnum.GRANDER_TEXAS;
                break;    
            default:
                this.foodType = FoodEnum.CHEESE;
        }
    }
        
    
}
