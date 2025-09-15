/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aifs.cdec.b3;

public class Test {
    
    public void changeName(PassByRefrence p1){
        p1.name = "Greamio";
    }
    
    
    public static void main(String[] args) {
        Test t1 = new Test();
        
        PassByRefrence pass1 = new PassByRefrence("Cloudblitz");
        
        System.out.println(pass1.name);
        
        t1.changeName(pass1);
        
        System.out.println(pass1.name);
    }
}
