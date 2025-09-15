/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aifs.cdec.b3;

/**
 *
 * @author shiva
 */
public class Methods {
    //Methods- it is a reusable block of code to perform a specific task and run only when we call it

    public void show() {
        System.out.println("Its a non-static method");
    }

    public static void getData() {
        System.out.println("Its a static method");
    }

    public static void main(String[] args) {
        Methods obj = new Methods();

        obj.show();

        Methods.getData();
    }

}
