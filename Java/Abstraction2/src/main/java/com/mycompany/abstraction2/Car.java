/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abstraction2;

/**
 *
 * @author shiva
 */
public class Car extends Vehicle{
    
    public Car(String brand){
        super(brand);
    }
    
    void startEngine(){
        System.out.println("Use Key based Ignition to start engine");
    }
    
    void stopEngine(){
        System.out.println("Use key based technique to stop engine");
    }
    
    
}
