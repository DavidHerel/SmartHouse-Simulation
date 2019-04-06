/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import Controls.MainApi;
import House.Window;
import RandomEvents.RandomEvent;
import RandomEvents.RandomEventType;

/**
 *
 * @author Lister
 */
public class SensorApi {
    
    /**
     *
     * @param event
     * @param sensor
     */
    public void visit(RandomEvent event, Sensor sensor){
        
        if(sensor.getEvent() != null){
            restoreState(sensor);
        }
        //System.out.println("Sensor reacts on " + event.getEvent());
        MainApi.getApi().getReporter().gatherReport("Sensor reacts on " + event.getEvent());
        sensor.setEvent(event);
        //for instance: it could be like this
        switch(sensor.getEvent().getEvent()){
            case WIND:
                sensor.getHouse().getWindows().forEach(window ->  window.setIsShut(true));
                //System.out.println("Closing all windows!");
                MainApi.getApi().getReporter().gatherReport("Closing all windows!");
                break;
            case SUN:
                sensor.getHouse().getWindows().forEach(window -> {  window.setIsShut(false);
                                                                    window.getBlinds().setClosed(true);
                });
                //System.out.println("Opening all windows, shutting all blinds!");
                MainApi.getApi().getReporter().gatherReport("Opening all windows, shutting all blinds!");
                break;
            case SNOW:
                sensor.getHouse().setTemperature(27);
                //System.out.println("House temperature increased!");
                MainApi.getApi().getReporter().gatherReport("House temperature increased!");
                break;
            case STORM:
                sensor.getHouse().getWindows().forEach(window -> {  window.setIsShut(true);
                                                                    window.getBlinds().setClosed(true);
                
                });
                //System.out.println("Closing all windows and shutting all blinds!");
                MainApi.getApi().getReporter().gatherReport("Closing all windows and shutting all blinds!");
                break;
        }
    }
    
    private void restoreState(Sensor sensor) {
        
        switch(sensor.getEvent().getEvent()){
            case WIND:
                sensor.getHouse().getWindows().forEach(window -> {
                    window.getBlinds().setClosed(false);
                });
                break;
            case SUN:
                sensor.getHouse().getWindows().forEach(window -> {
                    window.getBlinds().setClosed(false);
                });
                break;
            case SNOW:
                sensor.getHouse().setTemperature(22);
                break;
            case STORM:
                sensor.getHouse().getWindows().forEach(window -> {
                    window.getBlinds().setClosed(false);
                });
                break;
        }
    }
}
