/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfac;

import com.mycompany.abstraction2.*;
/**
 *
 * @author shiva
 */
public class Car implements Vehicle, Norms{
    
    @Override
    public void start(){
        System.out.println("Starts with key ignition");
    }
    
    @Override
    public void stop(){
        System.out.println("Stop with key");
    }
    @Override
    public int sum(int x, int y){
        return x*y;
    }
    @Override
    public void rules(){
        System.out.println("Must have seat belt");
    }
    
    public static void main(String[] args) {
        Test t1 = new Test();
    }
    
}
