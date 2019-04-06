/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.Accessories.CDs;

import Appliance.Accessories.Food.FoodEnum;
import java.util.Random;

/**
 *
 * @author Lister
 */
public class CD {
    
    private final CDEnum cd;

    public CD() {
    
         Random rand = new Random();
        int value = rand.nextInt(4); 
        
        switch(value){
            case 0:
                this.cd = CDEnum.DIRT;
                break;
            case 1:
                this.cd = CDEnum.DOKKTOR_ZAIUS;
                break;
            case 3:
                this.cd = CDEnum.DETEKTOR;
                break;
            case 4:
                this.cd = CDEnum.STEAL_THIS_ALBUM;
                break;    
            default:
                this.cd = CDEnum.DIRT;
        }
    }   

    public CDEnum getCd() {
        return cd;
    }
    
    public int getCDLength(){
        return this.cd.getCDLength();
    }

    @Override
    public String toString() {
        return cd.toString();
    }
    
    
}
