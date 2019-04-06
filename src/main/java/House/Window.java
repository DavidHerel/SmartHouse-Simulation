/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package House;

/**
 *
 * @author Lister
 */
public abstract class Window {

    private final Blinds blinds;
    private Boolean isShut;

    public Window(Blinds blinds) {
        this.blinds = blinds;
    }

    public Blinds getBlinds() {
        return blinds;
    }

    public Boolean getIsShut() {
        return isShut;
    }

    public void setIsShut(Boolean isShut) {
        this.isShut = isShut;
    }
    
    
}
