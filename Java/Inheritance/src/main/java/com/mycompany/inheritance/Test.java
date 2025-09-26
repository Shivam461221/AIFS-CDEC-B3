/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inheritance;

public class Test {
    
    public static void main(String[] args) {
        
        B obj = new B();
        
        obj.show();
        
        obj.display();
        
        System.out.println(obj.getName());
        
        System.out.println(obj.getStr());
        
        C objC = new C();
        
        objC.display();
    }
}
