/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.constructor;

public class Operation {
    
    public static double getPlotBasePrise(double area, String sector){
        if(sector.equalsIgnoreCase("A")){
            return area*Rate.sectorA;
        }
        else if(sector.equalsIgnoreCase("B")){
            return area*Rate.sectorB;
        }
        else if(sector.equalsIgnoreCase("c")){
            return area*Rate.sectorC;
        }
        else{
            return 0;
        }
    }
    
    public static double getFinalPrise(double area, String sector){
        return getPlotBasePrise(area, sector)+Rate.registryCharge+Rate.societyDevelopmentCharge;
    }
    
}
