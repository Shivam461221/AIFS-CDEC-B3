/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptionhandling.unchecked;

/**
 *
 * @author shiva
 */
public class ArrayBound {
    public static void main(String[] args) {
        
        int arr[] = {1,2,3};
        
        try{
        System.out.println(arr[4]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index not exist");
        }
    }
}
