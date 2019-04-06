/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi.Factories;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.ComputerApi;

/**
 *
 * @author Lister
 */
public class ComputerApiFactory{

    private static ComputerApi api;
    
    public static ApplianceApi getApi() {
        if(ComputerApiFactory.api == null)
            ComputerApiFactory.api = new ComputerApi();
        return ComputerApiFactory.api;
    }
    
}
