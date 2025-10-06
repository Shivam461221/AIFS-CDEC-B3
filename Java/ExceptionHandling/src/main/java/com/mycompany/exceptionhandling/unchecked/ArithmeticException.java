/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptionhandling.unchecked;

public class ArithmeticException {

    public static void main(String[] args) {
       System.out.println("Start");
        int a = 5;
        int b = 0;

        try{
            System.out.println(a / b);
        } catch (java.lang.ArithmeticException e) {
            System.out.println("Please don't enter zero");
        }
        

        System.out.println("End");
    }

}
