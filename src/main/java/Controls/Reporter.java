/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lister
 */
public class Reporter {
    
    private String outputString;
    private final MainApi mainApi;

    public Reporter(MainApi mainApi) {
        this.mainApi = mainApi;
        this.outputString = "";
    }
    
    
    
    /**
     * Use this method for recording events for 
     * daily report!
     * @param newEvent 
     */
    public void gatherReport(String newEvent){
        System.out.println(MainApi.getApi().getDayTime().toString() + " - " + newEvent);
        StringBuilder sb = new StringBuilder(outputString);
        sb.append("\n").append(MainApi.getApi().getDayTime().toString()).append(" - ").append(newEvent);
        outputString = sb.toString();
    }
    
    /**
     *
     */
    public void currentStateReport(){
        
        DayTime dayTime = DayTime.toDayTime(MainApi.getApi().getTime());
        int dayNo = MainApi.getApi().getTime() % 1440;
        File file = new File(dayNo+":"+dayTime.toString()+"_quick_report.txt");
        
        StringBuilder sb = new StringBuilder("Day number "+ dayNo +":\nTime: ");
        mainApi.getPeople().forEach( human -> sb.append(human.getAction().toString()));
        
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(sb.toString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Reporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void dailyReport(){
        int dayNo = MainApi.getApi().getTime()/1440;
        
        File file = new File("dayNo."+dayNo+"_report.txt");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("Day number "+ dayNo +":\nHouse temperature: " + MainApi.getApi().getHouse().getTemperature() + " °C" +
                         " Consumption: " + MainApi.getApi().getHouse().getConsumption(MainApi.getApi().getHouse()) + "\n" + outputString);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Reporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
