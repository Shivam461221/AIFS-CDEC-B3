/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abstraction2;

/**
 *
 * @author shiva
 */
public class Bike extends Vehicle {
    
    
    public Bike(String brand){
        super(brand);
    }
    
    void startEngine(){
        System.out.println("Use self start button");
    }
    
    void stopEngine(){
        System.out.println("Use button to stop engine");
    }
}
