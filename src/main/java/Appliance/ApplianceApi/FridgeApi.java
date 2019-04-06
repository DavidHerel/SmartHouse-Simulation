/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Accessories.Food.Food;
import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.Fridge;
import Controls.MainApi;
import House.Measurable;
import java.util.ArrayList;

/**
 *
 * @author Lister
 */
public class FridgeApi extends ApplianceApi{

    @Override
    public String toString() {
        return "fridge";
    }

    public FridgeApi() {
    }

    @Override
    public int work(Appliance fridge) {
        
        calculateDefect(fridge);
        if(((Fridge)fridge).getFood().isEmpty()){
            return 0;
        } else{
            Food meal = ((Fridge)fridge).getFood().get(0);
            //System.out.println("Eating " + meal.toString() + " now!");
            MainApi.getApi().getReporter().gatherReport("Eating " + meal.toString() + " now!");
            int eatingTime = meal.getEatingTime();
            ((Fridge)fridge).getFood().remove(0);
            return eatingTime;   //takes time to eat equal to the food pulled out of fridge
        }
    }

    @Override
    public int broken(Appliance app) {
        ((Fridge)app).getFood().removeAll(((Fridge)app).getFood());
        return -15;
    }

    @Override
    public Documentation createDocumentation() {
        return new Documentation(120);
    }

    @Override
    public int getConsumption(Measurable fridge) {
        int consump = (MainApi.getApi().getTime() - (((Fridge)fridge).getLastCheckTime() + ((Fridge)fridge).getBrokenTime()))*2;
        ((Fridge)fridge).setLastCheckTime(MainApi.getApi().getTime());
        ((Fridge)fridge).setBrokenTime();
        return consump;
    }
    
    public void addFood(Fridge fridge, ArrayList<Food> food){
        food.forEach((foodToAdd) -> {
            fridge.getFood().add(foodToAdd);
        });
    }
    
}
