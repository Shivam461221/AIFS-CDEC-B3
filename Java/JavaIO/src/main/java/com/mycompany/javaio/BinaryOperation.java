/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author shiva
 */
public class BinaryOperation {
    
    public void readBinaryFile(String path1, String path2){
        try{
            FileInputStream fis = new FileInputStream(path1);
            FileOutputStream fos = new FileOutputStream(path2);
            
            int byteData;
            while((byteData = fis.read()) != -1){
                System.out.print(byteData);
                fos.write(byteData);
            }
                
            fis.close();
            fos.close();
            System.out.println("Operation successful");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        BinaryOperation br = new BinaryOperation();
        
        br.readBinaryFile("C:\\AIFS-CDEC-B3\\AIFS-CDEC-B3\\Java\\input.jpg", "C:\\AIFS-CDEC-B3\\AIFS-CDEC-B3\\Java\\output2.jpg");
    }
}
