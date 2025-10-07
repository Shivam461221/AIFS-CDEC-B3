/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptionhandling.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author shiva
 */
public class FileNotFound {
    
    public static void main(String[] args) {
        
        try{
            FileReader fr = new FileReader("");
            
          //  fr.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Please provide right path");
        }
        
    }
}
