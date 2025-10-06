/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptionhandling.unchecked;

import com.mycompany.exceptionhandling.ExceptionHandling;

public class NullPointer {
    static ExceptionHandling ex ;
    
    public static void main(String[] args) {
        try{
             NullPointer.ex.showMessage();
        }
        catch(NullPointerException e){
            System.out.println("Please initialize the object first");
        }
    }
    
}
