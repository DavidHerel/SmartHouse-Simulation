/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import Appliance.Appliance;
import Appliance.State.StateBroken;
import House.Builder.FamilyHouseBuilder;
import House.House;
import Human.Human;
import Human.HumanAbility;
import HumanFactory.HumanFactory;
import Pet.Pet;
import Pet.PetType;
import Room.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lister
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {

        // TODO code application logic here
        File file = new File("config1.txt");
        MainApi api = MainApi.getApi();
        try {
            //api.run();
            api.runFromFile(file);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
