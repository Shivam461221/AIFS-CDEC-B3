/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superkeyword;

/**
 *
 * @author shiva
 */
public class Child extends Parent{
    //child / subclass/ derived
    
    private String data;
    int y;
    
    public Child(String data, int x, String data2, int y){
        super(data, x);
        this.data = data2;
        this.y = y;
    }
    
    @Override
    void show(){
        super.show();
        System.out.println("Child class method");
    }
    
    void display(){
        System.out.println(data);
        System.out.println(y);
        System.out.println(super.data);
        System.out.println(super.x);
        super.show();
        //super.data;
    }
    
    
    public static void main(String[] args) {
        Child child = new Child("parent class data", 10, "child", 20);
//        
//        child.show();
//        System.out.println(child.data);
//        
        //System.out.println(child.data);
        child.display();
    }
}
