/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.second;

import com.mycompany.oops.Encapsulation;

/**
 *
 * @author shiva
 */
public class B{
    
    private String username ;
    private String password ;
    
//    public void setUsername(String username){
//        this.username = username;
//    }
//    
//    public String getUsername(){
//        return this.username;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public static void main(String[] args) {
        B obj = new B();
        
        obj.setUsername("Shivam");
        
        System.out.println(obj.getUsername());
       
    }
}
