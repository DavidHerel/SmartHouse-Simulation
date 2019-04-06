/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi.Factories;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.FridgeApi;

/**
 *
 * @author Lister
 */
public class FridgeApiFactory{
    
    private static FridgeApi api;

    public static ApplianceApi getApi() {
        if(FridgeApiFactory.api == null)
            FridgeApiFactory.api = new FridgeApi();
        return FridgeApiFactory.api;
    }
}
