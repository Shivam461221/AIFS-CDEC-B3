/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aifs.cdec.b3;

/**
 *
 * @author shiva
 */
public class PassByValue {
    private int x = 10;
    
    public void changeValue(int a){
        a = 100;
        System.out.println(a);
    }
    
    public static void main(String[] args) {
        PassByValue obj = new PassByValue();
        
        obj.changeValue(obj.x);
        
        System.out.println(obj.x);
    }
}
