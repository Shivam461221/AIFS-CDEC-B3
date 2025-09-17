/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aifs.cdec.b3;

public class Bike {
    private String model;
    private String color;
    private String brand;
    
    public Bike(){
        this.model = "125 cc";
        this.color = "Black-red";
        this.brand = "Bajaj";
    }
    
    public Bike(String model,String color,String brand){
        this.model = model;
        this.color = color;
        this.brand = brand;
    }
    
    public static void main(String[] args) {
        Bike apache = new Bike("Apache RTR 160", "black", "TVS");
        
        System.out.println(apache.color);
        
        Bike pulser = new Bike();
        
        System.out.println(pulser.color);
    }
}
