/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi.Factories;

import Appliance.ApplianceApi.ApplianceApi;
import Appliance.ApplianceApi.MassageChairApi;

/**
 *
 * @author Lister
 */
public class MassageChairApiFactory{

    private static MassageChairApi api;
    
    public static ApplianceApi getApi() {
        if(MassageChairApiFactory.api == null)
            MassageChairApiFactory.api = new MassageChairApi();
        return MassageChairApiFactory.api;
    }
    
}
