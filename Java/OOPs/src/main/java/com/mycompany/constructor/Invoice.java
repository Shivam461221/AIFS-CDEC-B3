/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.constructor;

/**
 *
 * @author shiva
 */
public class Invoice {

    public static void printInvoice(Plot plot) {
        System.out.println("Plot Length: " + plot.getLength());
        System.out.println("Plot Breadth: " + plot.getBreadth());
        System.out.println("Plot Sector: " + plot.getSector());

        System.out.println("Plot Area: " + plot.getArea());

//        System.out.println("Plot Base Price: "+Operation.getPlotBasePrise(plot.getArea(), plot.getSector()));
//        
//        System.out.println("Plot Final Prise: "+ Operation.getFinalPrise(plot.getArea(), plot.getSector()));
        System.out.printf("Plot Base Price: %.0f%n " , Operation.getPlotBasePrise(plot.getArea(), plot.getSector()));

        System.out.printf("Plot Final Price: %.0f%n " , Operation.getFinalPrise(plot.getArea(), plot.getSector()));
    }
}
