package RoomApiTest;

import Appliance.Appliance;
import Furniture.Furniture;
import Furniture.FurnitureType;
import Room.Room;
import org.junit.jupiter.api.*;
import Room.RoomType;
import Appliance.CoffeeMaker;
import Appliance.Television;
import Appliance.Documentation;
import Appliance.Fridge;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author fuji
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoomApiTest {

    @Test
    @Order(2)
    @Tag("House")
    public void testAddingApplianceVSEnergyConsumption() throws Exception{
        ArrayList<Appliance> kitchenAppliances = new ArrayList<Appliance>();
        kitchenAppliances.add(new Fridge(0, new Documentation(10), 10, "Fridge"));
        kitchenAppliances.add(new CoffeeMaker(0, new Documentation(1), 5, "Coffee Maker"));

        Room kitchen = new Room(RoomType.KITCHEN, kitchenAppliances, new ArrayList<Furniture>(), 0, 1);
        int applianceCountBefore = kitchen.getAppliance().size();

        //turn all the kitchen appliances on
        for (int i = 0; i < applianceCountBefore; i++) {
            kitchen.getAppliance().get(i).getApi().work(kitchen.getAppliance().get(i));
        }
        int consumptionBefore = kitchen.getConsumption(kitchen);

        //create a new appliance and add it to the kitchen
        Television tv = new Television(0, new Documentation(10), 30, "TV");
        kitchen.addAppliance(tv);
        int applianceCountAfter = kitchen.getAppliance().size();
        assertTrue("There should be more appliances in the kitchen after the TV has been added ", applianceCountBefore<applianceCountAfter);

        //turn all the kitchen appliances on
        for (int i = 0; i < applianceCountAfter; i++) {
            kitchen.getAppliance().get(i).getApi().work(kitchen.getAppliance().get(i));
        }
        int consumptionAfter = kitchen.getConsumption(kitchen);
        assertTrue("The energy consumption should increase after TV has been added ", consumptionBefore<consumptionAfter);

    }

    @Test
    @Order(1)
    @Tag("House")
    public void testAddRemoveFurniture() throws Exception{
        //create rooms
        Room kitchen = new Room(RoomType.KITCHEN, new ArrayList<Appliance>(), new ArrayList<Furniture>(), 0, 1);
        Room livingRoom = new Room(RoomType.LIVINGROOM, new ArrayList<Appliance>(), new ArrayList<Furniture>(), 0, 2);

        //create a table and put it in the kitchen
        Furniture table = new Furniture(FurnitureType.TABLE, kitchen);
        kitchen.addFurniture(table);
        assertTrue("Table should be initially located in the kitchen ", table.getRoom()==kitchen);

        //move table from kitchen to living room
        kitchen.removeFurniture(table);
        table.setRoom(livingRoom);
        livingRoom.addFurniture(table);
        assertTrue("Kitchen should have no furniture after the table is moved ", kitchen.getFurniture().size()==0);
        assertTrue("Now table should be located in the living room, where we moved it ", table.getRoom()==livingRoom);
    }

}
