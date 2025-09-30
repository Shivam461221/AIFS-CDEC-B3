/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.abstraction2;

/**
 *
 * @author shiva
 */
public class Abstraction2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Vehicle car = new Car("Toyota");
        
        //Vehicle v1 = new Vehicle("str");
        
        car.startEngine();
        
        car.show();
        
        Vehicle bike = new Bike("TVS");
        
        bike.startEngine();
        bike.stopEngine();
        
    }
}
