/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aifs.cdec.b3;

/**
 *
 * @author shiva
 */
public class Human {
    
    private String name = "";
    
    private double height = 5.5;
    private int age = 25;
    private double weight = 62.5;
    private char gender = 'M';
    
    public void speak(){
        System.out.println("Speaking");
    }
    
    public void walk(){
        System.out.println("Walking");
    }
    
    public static void main(String[] args) {
        System.out.println(Car.features);
        
        Car c1 = new Car();
        System.out.println(c1.getBrand());
    }
    
    
}
