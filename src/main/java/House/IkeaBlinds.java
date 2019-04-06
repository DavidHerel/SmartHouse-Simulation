/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package House;

import java.util.Random;

/**
 * Self-put-together blinds from IKEA
 * might not always work :( 
 * @author Lister
 */
public class IkeaBlinds extends Blinds{
    
    /**
     *
     * @param bool
     */
    @Override
    public void setClosed(boolean bool){
        Random rand = new Random();
        int value = rand.nextInt(100)+1;
        
        if(value > 95){
            return;
        }
        this.closed = bool;
    }
}
