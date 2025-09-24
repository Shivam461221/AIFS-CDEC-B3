/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.constructor;

/**
 *
 * @author shiva
 */
public class Test {
        
    public static void main(String[] args) {
        Plot plotA = new Plot();
        Plot plotB = new Plot(30);
        Plot plotC = new Plot(50, 30);
        
        Invoice.printInvoice(plotA);
    }
}
