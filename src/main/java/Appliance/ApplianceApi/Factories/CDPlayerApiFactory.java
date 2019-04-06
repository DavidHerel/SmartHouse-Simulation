/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi.Factories;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.CDPlayerApi;

/**
 *
 * @author Lister
 */
public class CDPlayerApiFactory{

    private static CDPlayerApi api;

    public static ApplianceApi getApi() {
        if(CDPlayerApiFactory.api == null)
            CDPlayerApiFactory.api = new CDPlayerApi();
        
        return CDPlayerApiFactory.api;
    }
    
}
