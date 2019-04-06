/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi.Factories;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.TelevisionApi;

/**
 *
 * @author Lister
 */
public class TelevisionApiFactory{

    private static TelevisionApi api;
    
    public static ApplianceApi getApi() {
        if(TelevisionApiFactory.api == null)
            TelevisionApiFactory.api = new TelevisionApi();
        return TelevisionApiFactory.api;
    }
    
}
