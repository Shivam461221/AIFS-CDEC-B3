/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.polymorphism;

/**
 *
 * @author shiva
 */
public class Calculator {
    
    public int sum(int x, int y){
        System.out.println("int");
        return x+y;
    }
    
    public String sum(String str1, String str2){
        return str1+str2;
    }
    
    public double sum(double x, double y){
        System.out.println("double");
        return x+y;
    }
    
    public int sum(int x, int y, int z){
        System.out.println("three parameters");
        return x+y+z;
    }
    
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        
        
        System.out.println(c1.sum(12.0, 17.0));
        
        System.out.println(c1.sum(12, 10, 34));
        System.out.println(c1.sum("first_", "name"));
    }
    
}
