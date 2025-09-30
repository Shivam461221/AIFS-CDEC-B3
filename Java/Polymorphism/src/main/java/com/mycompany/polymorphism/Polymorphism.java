/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.polymorphism;

/**
 *
 * @author shiva
 */
public class Polymorphism {

    public static void main(String[] args) {
       
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        
        a1.sound();
        
        a2.sound();
    
}
}
