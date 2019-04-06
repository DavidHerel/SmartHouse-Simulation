/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.Accessories.TvShows;

import Appliance.Accessories.Food.FoodEnum;
import java.util.Random;

/**
 *
 * @author Lister
 */
public class TvShow {
    
    private final TvShowEnum movieType;

    public TvShow() {
                Random rand = new Random();
        int value = rand.nextInt(8); 
        
        switch(value){
            case 0:
                this.movieType = TvShowEnum.SAW2;
                break;
            case 1:
                this.movieType = TvShowEnum.TWILIGHT;
                break;
            case 3:
                this.movieType = TvShowEnum.MASK;
                break;
            case 4:
                this.movieType = TvShowEnum.BATMAN;
                break;    
             case 5:
                this.movieType = TvShowEnum.DANO_DREVO;
                break;
            case 6:
                this.movieType = TvShowEnum.HENRY_PROPER;
                break;
            case 7:
                this.movieType = TvShowEnum.PAR_PARMENU;
                break;
            default:
                this.movieType = TvShowEnum.PAR_PARMENU;
        }
    }

    public TvShowEnum getMovieType() {
        return movieType;
    }

    @Override
    public String toString() {
        return movieType+"";
    }

    public int getMovieTime() {
        return movieType.getWatchTime();
    }
    
    
}
