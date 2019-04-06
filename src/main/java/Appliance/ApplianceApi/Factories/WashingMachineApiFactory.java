/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi.Factories;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.WashingMachineApi;

/**
 *
 * @author Lister
 */
public class WashingMachineApiFactory{

    private static WashingMachineApi api;
    
    public static ApplianceApi getApi() {
        if(WashingMachineApiFactory.api == null)
            WashingMachineApiFactory.api = new WashingMachineApi();
        return WashingMachineApiFactory.api;
    }
    
}
