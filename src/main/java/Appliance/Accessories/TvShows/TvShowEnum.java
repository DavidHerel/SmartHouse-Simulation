/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.Accessories.TvShows;

/**
 *
 * @author Lister
 */
public enum TvShowEnum {
    
    SAW2("Weird film", 126),
    MASK("<3 Jim Carrey", 120),
    TWILIGHT("i'm not watching this bull***!", 1),
    BATMAN("..prave jsem skopal batmana...ale ukazalo se, ze to je jeptiska..", 111),
    DANO_DREVO("Chvostnaty Gabor!", 90),
    HENRY_PROPER("Henry the Proper!", 89),
    PAR_PARMENU("Lala je ****", 99);
    
    private final String reaction;
    private final int watchTime;

    private TvShowEnum(String reaction, int watchTime) {
        this.reaction = reaction;
        this.watchTime = watchTime;
    }    

    @Override
    public String toString() {
        return reaction + "";
    }

    public int getWatchTime() {
        return watchTime;
    }
    
    
}
