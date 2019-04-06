/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi.Factories;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.CoffeeMakerApi;

/**
 *
 * @author Lister
 */
public class CoffeeMakerApiFactory{

    private static CoffeeMakerApi api;
    
    public static ApplianceApi getApi() {
        if(CoffeeMakerApiFactory.api == null)
            CoffeeMakerApiFactory.api = new CoffeeMakerApi();
        return CoffeeMakerApiFactory.api;
    }
    
}
