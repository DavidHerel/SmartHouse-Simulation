/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.Accessories.XboxGames;

import Appliance.Accessories.Food.FoodEnum;
import java.util.Random;

/**
 *
 * @author Lister
 */
public class XboxGame {
    
    private final XboxGameEnum gameType;

    public XboxGameEnum getGameType() {
        return gameType;
    }

    public XboxGame() {
        
        Random rand = new Random();
        int value = rand.nextInt(4); 
        
        switch(value){
            case 0:
                this.gameType = XboxGameEnum.RED_DEAD_REDEMPTION2;
                break;
            case 1:
                this.gameType = XboxGameEnum.WITCHER3;
                break;
            case 3:
                this.gameType = XboxGameEnum.FORZA7;
                break;
            case 4:
                this.gameType = XboxGameEnum.FIFA1415;
                break;    
            default:
                this.gameType = XboxGameEnum.FIFA1415;
        }
    }
    
    public int getGameTime(){
        return gameType.getPlayTime();
    }

    @Override
    public String toString() {
        return "" + gameType;
    }
    
}
