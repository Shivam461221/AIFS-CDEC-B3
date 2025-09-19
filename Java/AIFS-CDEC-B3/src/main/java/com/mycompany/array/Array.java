/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.array;

/**
 *
 * @author shiva
 */
public class Array {
        
    int[] arr1 = new int[5];
    
    int arr2[] = {1,2,3,4,5,6,7,8};
    
    {
        arr1[0] = 12;
        arr1[1] = 13;
    }
    
    public static void main(String[] args) {
        
        Array obj1 = new Array();
        //System.out.println(obj1.arr2.length);
        
        for (int i = 0; i < obj1.arr2.length; i++) {
            System.out.print(obj1.arr2[i]+" ");
        }
            System.out.println();
       // int matrix[][] = new int[2][2];
       
       int matrix[][] = {{1,2}, {3,4}};
       
        //System.out.println(matrix[1][0]);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            
            System.out.println();
        }
    }
    
    
}
