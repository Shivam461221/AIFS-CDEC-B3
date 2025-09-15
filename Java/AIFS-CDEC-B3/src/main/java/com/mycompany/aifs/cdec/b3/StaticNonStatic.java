/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aifs.cdec.b3;

/**
 *
 * @author shiva
 */
public class StaticNonStatic {
    //variables, methods, block
    
    static{
        System.out.println("Static block");
    }
    
    {
        System.out.println("Non-static block");
    }
    
    public static void main(String[] args) {
        
        System.out.println("Main method");
        //public - access modifier
        //static - for sharing method across the application
        //void - so the method does not return any value
        //main 
        //System - class predefined 
        //out - out is an intance 
        //println - method of system class
        StaticNonStatic obj1 = new StaticNonStatic();
        
        StaticNonStatic obj2 = new StaticNonStatic();
                
        
    }
}
