/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.Accessories.Food;

/**
 *
 * @author Lister
 */
public enum FoodEnum {
    
    CHEESE(5, "cheese (smells like socks)"),
    HAM(4, "smoked ham"),
    MEAT(10, "fresh flesh"),
    GRANDER_TEXAS(15, "super tasty, giant Texas Grander from Almighty KFC!");
    
    private final int time;
    private final String name;

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "" + name;
    }
     
    private FoodEnum(int time, String name){
        this.time = time;
        this.name = name;
    }
}
