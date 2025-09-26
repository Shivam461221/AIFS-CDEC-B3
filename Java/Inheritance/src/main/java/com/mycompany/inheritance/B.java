/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inheritance;

public class B extends A {
   
    private String str = "class B variable";
    
    public void display(){
        System.out.println("Class B method");
    }
    
    @Override
    public void show(){
        System.out.println("Class B show method");
    }
    
    public String getStr(){
        return str;
    }
    
    public void setStr(String str){
        this.str = str;
    }
}
