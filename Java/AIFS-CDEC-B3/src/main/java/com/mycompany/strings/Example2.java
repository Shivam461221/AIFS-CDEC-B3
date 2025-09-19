/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.strings;
import java.util.*;
public class Example2 {
        
    
    public static void main(String[] args) {
        String str1 = "Sagar";   //literals
        
        String str2 = "sagar";
        
        System.out.println(str1.equals(str2));
        
        System.out.println(str1.equalsIgnoreCase(str2));
        
        String strArray[] = str1.split("a");
        
        System.out.println(Arrays.toString(strArray));
        
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i] + " ");
        }
        
        String name = "  he llo ";
        
        System.out.println(name.trim());
        
        String str3 = "Swaleha";
        
        String str4 = "Swaleha";
        
        String str5 = new String("Swaleha");  //
        
        str3 = str3.concat(" AIFS");
        
        System.out.println(str3);
    }
}
