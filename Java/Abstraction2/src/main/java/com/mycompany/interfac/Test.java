/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfac;

/**
 *
 * @author shiva
 */
public class Test {
    
    
    public static void main(String[] args) {
        
        Vehicle v1 = new Car();
        
        v1.start();
        v1.stop();
        
        v1.display();
        
        Vehicle.getData();
    }
}
