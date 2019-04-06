/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.Accessories.XboxGames;

/**
 *
 * @author Lister
 */
public enum XboxGameEnum {
    
    RED_DEAD_REDEMPTION2("Red Dead Redemption 2", 180),
    WITCHER3("medieval sex simulator 3000", 600),
    FORZA7("Forza7", 45),
    FIFA1415("This Fifa1415 is on fire!", 20);
    
    private final String name;
    private final int playTime;

    private XboxGameEnum(String name, int playTime) {
        this.name = name;
        this.playTime = playTime;
    }
    
    public int getPlayTime(){
        return this.playTime;
    }

    @Override
    public String toString() {
        return "" + name;
    }
    
    
}
