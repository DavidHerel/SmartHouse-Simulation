/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.Accessories.CDs;

/**
 *
 * @author Lister
 */
public enum CDEnum {
    
    DIRT("Dirt from Alice in Chains", 45),
    DOKKTOR_ZAIUS("Dokktor Zaius from Hentai Corporation", 21),
    STEAL_THIS_ALBUM("Steal this album from System Of A Down", 37),
    DETEKTOR("POMOC KRVACIM Z USI!", 1);
    
    private final String band;
    private final int cdLength;

    private CDEnum(String band, int cdLength) {
        this.band = band;
        this.cdLength = cdLength;
    }

    public int getCDLength() {
        return cdLength;
    }

    @Override
    public String toString() {
        return band;
    }
    
    
}
