/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import Appliance.Appliance;
import Appliance.CoffeeMaker;
import Equipment.Equipment;
import House.Builder.FamilyHouseBuilder;
import House.House;
import Human.Human;
import Human.HumanAbility;
import HumanFactory.HumanFactory;
import Pet.Pet;
import Pet.PetType;
import RandomEvents.RandomEvent;
import RandomEvents.RandomEventType;
import Room.Room;
import Transport.Bike;
import Transport.Car;
import Transport.Machines;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lister
 */
public class MainApi {
    
    private int time;
    private static boolean exists = false;
    private static MainApi api;
    private Reporter reporter;
    
    private House house;

    public Reporter getReporter(){
        return this.reporter;
    }
    
    public ArrayList<Human> getPeople(){
        return this.people;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public static void setApi(MainApi api) {
        MainApi.api = api;
    }

    public void setMachines(ArrayList<Machines> machines) {
        this.machines = machines;
    }

    public static boolean isExists() {
        return exists;
    }

    public static void setExists(boolean exists) {
        MainApi.exists = exists;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public RandomEvent getEvent() {
        return event;
    }

    public void setEvent(RandomEvent event) {
        this.event = event;
    }
    private ArrayList<Human> people;
    private ArrayList<Pet> pets;
    private RandomEvent event;
    private ArrayList<Machines> machines;

    public void setPeople(ArrayList<Human> people) {
        this.people = people;
    }

    private MainApi() {
        people = new ArrayList<>();
        pets = new ArrayList<>();
        machines = new ArrayList<>();
        this.reporter = new Reporter(this);
    }

    public MainApi(ArrayList<Human> people, ArrayList<Pet> pets, ArrayList<Machines> machines) {
        this.people = people;
        this.pets = pets;
        this.machines = machines;
        this.reporter = new Reporter(this);
    }
    
    
    public static MainApi getApi(){
        if(!exists){
            api = new MainApi();
            exists = true;
        }
        return api;
    }

    public int getTime() {
        return time;
    }

    public ArrayList<Machines> getMachines() {
        return machines;
    }
    
    
    
    public void run() throws Exception {
        
        Scanner usrInput = new Scanner(System.in);
        char input;
        System.out.println("Choose the house you want.Type 'F' for family house. Type 'H' for help. Type 'X' for exit");
        buildinghouse: while(true){
            switch(input = usrInput.next().charAt(0)){
                case 'F':
                    this.house = new FamilyHouseBuilder().buildHouse(this);
                    System.out.println("You built house.");
                    System.out.println("The current configuration of family house is: ");
                    
                    System.out.println("Number of equipment is: " + house.getEquipment().size());
                    System. out. println("----Equipment----");
                    for (Equipment eq : house.getEquipment()){
                        System.out.println(eq.toString());
                    }
                    int tmps = 0;
                    
                    System. out. println("----Appliances----");
                    for (Room room : house.getRooms()){
                        for (Appliance app : room.getAppliance()){
                            System.out.println(app.toString());
                            tmps++;
                        }
                    }
                    System.out.println("Number of appliances are: " + tmps);
                    System.out.println();
                    break buildinghouse;
                case 'H':
                    System.out.println("F - family house");
                    System.out.println("H - help");
                    System.out.println("X - exit");
                    continue;
                case 'X':
                    return;
                default:
                    System.out.println("Invalid input! Type 'H' for help!");
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makingpeople: while(true){
            
            System.out.println("Add people to the family. Type 'A' and 'name' for adult, 'K' and 'name' for kid. 'X' when finished with process, 'H' for help.");
            System.out.println("Add pet to the family. Type 'D' and name for Dog, 'C' and 'name' for cat. 'X' when finished with process, 'H' for help.");
            switch(input = usrInput.next().charAt(0)){
                case 'A':
                    System.out.println("Enter your adult's name.");
                    ArrayList<HumanAbility> abilities = new ArrayList<>();
                    abilities.add(HumanAbility.CAN_REPAIR);
                    abilities.add(HumanAbility.CAN_SPORT);
                    people.add(HumanFactory.createHuman("Adult", abilities, br.readLine(), this.house, 10, "male"));
                    break;
                case 'K':
                    System.out.println("Enter your kid's name.");
                    abilities = new ArrayList<>();
                    abilities.add(HumanAbility.CAN_SPORT);
                    people.add(HumanFactory.createHuman("Kid", abilities, br.readLine(), this.house, 10, "male"));
                    break;
                case 'H':
                    System.out.println("PIZDIEC!");
                    System.out.println("Add people to the family. Type 'A' and 'name' for adult, 'K' and 'name' for kid. 'X' when finished with process, 'H' for help.");
                    break;
                case 'D':
                    System.out.println("Enter your dog's name.");
                    pets.add(new Pet(br.readLine(), PetType.DOG, house, 10));
                    break;
                case 'C':
                    System.out.println("Enter your cat's name.");
                    pets.add(new Pet(br.readLine(), PetType.CAT, house, 10));
                    break;
                case 'X':
                    break makingpeople;
                default:    
                    System.out.println("Invalid input! Type 'H' for help!");
            }
        }
        
        this.time = 0;
        createTransport();
        event = new RandomEvent(RandomEventType.WIND, house, 10);
        System.out.println("For testing press 'Y', for simulation press anything else.");
        if((input = usrInput.next().charAt(0)) == 'Y'){
            simulation: while(true){
                System.out.println("Generate some Events now!");
                switch(input = usrInput.next().charAt(0)){
                    case 'C':
                        //findHuman(br.readLine()).makeCoffee(); //final version, unsupported yet
                       for(Room room : house.getRooms())
                           for(Appliance app : room.getAppliance())
                               if(app instanceof CoffeeMaker)
                                   app.getApi().visit(findHuman(br.readLine()), app);
                        break;
                    case 'X':
                        return;
                    case 'H':
                        System.out.println("No help for you!");
                        break;
                    case '0':
                        System.out.println("No action performed!");
                        break;
                }
                time++;
            }
        } else{
            time = 480; //simulation starts at 8:00 am - 1 time unit equals 1 minute
            //MAIN SIMULATION LOOP HERE
            
            simulation: while(true){
              //  System.out.println("The time is: "+getDayTime());
                
                checkEvents();
                checkPeople();                
                checkPets();
                checkAppliance();
                checkMachines();
                checkEquipment();
                
                time++;
                sleep(10);//SLEEP FOR 0,1 SEC (i hope its 0,1 sec :D :D ) just to make the simulation a little smoother
                
                //simulation stops at at midnight
                if(time % 1440 == 0){
                    this.reporter.dailyReport();
                }
                if (time == 1440){
                    System.out.println("We have Midnight. Simulation of 1 day in our SmartHouse ends.");
                    break;
                }
            }  
        }
    }
    
    public void runFromFile(File file) throws FileNotFoundException, IOException, InterruptedException{
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            
            OUTER:
            while ((line = br.readLine()) != null) {
                if (null != line) {
                    switch (line) {
                        case "F":
                            this.house = new FamilyHouseBuilder().buildHouse(this);
                            System.out.println("You built house.");
                            System.out.println("The current configuration of family house is: ");
                            System.out.println("Number of equipment is: " + house.getEquipment().size());
                            System. out. println("----Equipment----");
                            for (Equipment eq : house.getEquipment()){
                                System.out.println(eq.toString());
                            }       int tmps = 0;
                            System. out. println("----Appliances----");
                            for (Room room : house.getRooms()){
                                for (Appliance app : room.getAppliance()){
                                    System.out.println(app.toString());
                                    tmps++;
                                }
                            }       System.out.println("Number of appliances are: " + tmps);
                            System.out.println();
                            break;
                        case "A":
                            {
                                ArrayList<HumanAbility> abilities = new ArrayList<>();
                                abilities.add(HumanAbility.CAN_REPAIR);
                                abilities.add(HumanAbility.CAN_SPORT);
                                people.add(HumanFactory.createHuman("Adult", abilities, br.readLine(), this.house, Integer.parseInt(br.readLine()), br.readLine()));
                                break;
                            }
                        case "K":
                            {
                                ArrayList<HumanAbility> abilities = new ArrayList<>();
                                abilities = new ArrayList<>();
                                abilities.add(HumanAbility.CAN_SPORT);
                                people.add(HumanFactory.createHuman("Kid", abilities, br.readLine(), this.house, Integer.parseInt(br.readLine()), br.readLine()));
                                break;
                            }
                        case "D":
                            pets.add(new Pet(br.readLine(), PetType.DOG, house, 10));
                            break;
                        case "C":
                            pets.add(new Pet(br.readLine(), PetType.CAT, house, 10));
                            break;
                        case "X":
                            break OUTER;
                        default:
                            throw new Exception("Invalid starting char in input file");
                    }
                }
            }
            this.time = 0;
            createTransport();
            event = new RandomEvent(RandomEventType.WIND, house, 10);
            time = 480; //simulation starts at 8:00 am - 1 time unit equals 1 minute
            //MAIN SIMULATION LOOP HERE
            
            while(true){
              //  System.out.println("The time is: "+getDayTime());

                checkEvents();
                checkPeople();
                checkPets();
                checkAppliance();
                checkMachines();
                checkEquipment();
                
                time++;
                sleep(10);//SLEEP FOR 0,1 SEC (i hope its 0,1 sec :D :D ) just to make the simulation a little smoother
                
                //simulation stops at at midnight
                if(time % 1440 == 0){
                    this.reporter.dailyReport();
                }
                if (time == 1440){
                    System.out.println("We have Midnight. Simulation of 1 day in our SmartHouse ends.");
                    break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DayTime getDayTime(){
        return DayTime.toDayTime(time);
    }

    private Human findHuman(String name) {
        for(Human human : this.people){
            if(name.equals(human.getName())){
                return human;
            }
        }
        return null;
    }

    private void checkAppliance() {
        
        house.getRooms().forEach((room) -> {
            room.getAppliance().forEach((app) -> {
                if (app.getBusyTime() > 0){
                    app.setBusyTime();
                }else{
                    app.setBusyTime(0);
                }
            });
        });    
    }

    private void checkPeople() {
        
        this.people.forEach((buddy) -> {
            if(buddy.getBusyTime() > 0){
                buddy.setBusyTime(buddy.getBusyTime()-1);
            } else{
                buddy.setBusyTime(0);
                buddy.getApi().visit();
            }
        });
    }
    
        private void checkMachines() {
        
        this.machines.forEach((buddy) -> {
            if(buddy.getBusyTime() > 0){
                buddy.setBusyTime(buddy.getBusyTime()-1);
            } else{
                buddy.setBusyTime(0);
            }
        });
    }
    
    private void checkPets(){
        if (!pets.isEmpty()){
        
            this.pets.forEach((pet) -> {
                if(pet.getBusyTime() > 0){
                    pet.setBusyTime(pet.getBusyTime()-1);
                } else{
                    pet.setBusyTime(0);
                    pet.getApi().visit();
                }
            });
        }
    }
    
    private void checkEquipment(){
        
        this.house.getEquipment().forEach((Equipment eq) -> {
            if(eq.getBusyTime() > 0){
                eq.setBusyTime(eq.getBusyTime()-1);
            } else{
                eq.setBusyTime(0);
            }
        });
    }
    
        private void checkEvents(){
        
        if (event.getBusyTime() > 0){
            event.setBusyTime(event.getBusyTime() - 1);
        }else{
            event.setBusyTime(0);
            event.getApi().visit();
        }
    }
        
        private void createTransport(){
            machines.add(new Car(5, 0));
            machines.add(new Bike(10, 0));
        }
    
}
