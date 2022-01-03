/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanFactory;

import House.House;
import Human.Adult;
import Human.Human;
import Human.HumanAbility;
import Human.Kid;
import java.util.ArrayList;

/** Factory class for human - it is singleton
 *
 * @author fuji
 */
public class HumanFactory {
    //object itself
    private static HumanFactory instance;

    private HumanFactory() {
    }  
    
    public static synchronized HumanFactory getInstance(){
        if (instance == null){ // "lazy" inicializace
            instance = new HumanFactory();
        }
        return instance;
    }
    
    /**
     *  Method for creating humans
     * @param type - specifies which type of human you want
     * @param abilities
     * @return 
     */
    public static Human createHuman(String type, ArrayList<HumanAbility> abilities, String name, House house, Integer age) throws Exception {
        if (name.equals("") || name.length() > 20) {
            throw new Exception("Empty name or longer than 20 characters");
        }
        if (age < 0 || age > 120){
            throw new Exception("Age is less than 0 or higher than 120");
        }
        if ("Adult".equalsIgnoreCase(type)){
            return new Adult(abilities, name, house, age);
            
        } else if ("Kid".equalsIgnoreCase(type)){
            return new Kid(abilities, name, house, age);
        }
        return null; 
    }
}
