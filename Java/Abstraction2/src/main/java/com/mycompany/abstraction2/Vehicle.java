/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abstraction2;

/**
 *
 * @author shiva
 */
abstract class Vehicle {
       
    String brand;
    
    public Vehicle(String brand){
        this.brand = brand;
    }
    
    abstract void startEngine();
    
    abstract void stopEngine();
    
    public void show(){
        System.out.println("Brand: "+brand);
    }
    
}
