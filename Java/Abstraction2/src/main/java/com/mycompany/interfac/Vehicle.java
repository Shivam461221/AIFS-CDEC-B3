/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfac;

/**
 *
 * @author shiva
 */
public interface Vehicle {
    
    public static final int x = 10;  //public static final
    
    void start();
    
    void stop();
    
    int sum(int x, int y);
    
    
    //Java 8
    default void display(){
        System.out.println("Display");
    }
    
    static void getData(){
        System.out.println("Data");
    }
}
