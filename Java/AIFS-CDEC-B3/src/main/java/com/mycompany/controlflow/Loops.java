/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlflow;

public class Loops {

    //while, do while, for
    public static void main(String[] args) {
        int x = 10;

//        while(x<=100){
//            System.out.println(x);
//            x++;
//        }
        do {
            System.out.println("do while");
            x++;
        } while (false);

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
