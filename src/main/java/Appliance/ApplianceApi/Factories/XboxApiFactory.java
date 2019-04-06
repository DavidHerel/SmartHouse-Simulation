/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi.Factories;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.XboxApi;

/**
 *
 * @author Lister
 */
public class XboxApiFactory{

    private static XboxApi api;
            
    public static ApplianceApi getApi() {
        if(XboxApiFactory.api == null)
            XboxApiFactory.api = new XboxApi();
        return XboxApiFactory.api;
    }
    
}
