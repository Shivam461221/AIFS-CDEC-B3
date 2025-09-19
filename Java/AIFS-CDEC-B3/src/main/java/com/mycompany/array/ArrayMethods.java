/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.array;

import java.util.Arrays;

public class ArrayMethods {

    void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {11, 2, 33, 14, 5, 6, 17};

//        System.out.println(Arrays.toString(arr));
//        
//        Arrays.sort(arr);
//        
//        System.out.println(Arrays.toString(arr));
//        
//        int index = Arrays.binarySearch(arr, 33);
//        
//        System.out.println(index);
        int arr2[] = {3, 2, 5, 6, 86, 12};

        for (int i : arr) {
            System.out.println(i);
        }

        ArrayMethods obj = new ArrayMethods();

        obj.print(arr2);

//        
//        int matrix[][] = {
//            {1,2,4}, 
//            {3,4,6}, 
//            {5,6,5}
//        };
//        
//        System.out.println(matrix[2][0]);
//        
//        
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.println(matrix[i][j]);
//            }
//        }
    }
}
