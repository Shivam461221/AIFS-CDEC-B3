/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author shiva
 */
public class FileOperation {

//    public void writeData() {
//        try {
//            FileWriter writer = new FileWriter("C:\\AIFS-CDEC-B3\\AIFS-CDEC-B3\\Java\\input.txt", true);
//            writer.write("\nthis is new line");
//            writer.close();
//            System.out.println("File has been written");
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }
    
    public void writeData(String path, String msg) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(msg);
            writer.close();
            System.out.println("File has been written");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void readData(String path){
        try{
            FileReader reader = new FileReader(path);
            int ch;
            while((ch=reader.read()) != -1){
                System.out.print((char) ch);
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void readAndwrite(String path1, String path2){
        try{
            FileReader reader = new FileReader(path1);
            FileWriter writer = new FileWriter(path2, true);
            int ch;
            while((ch=reader.read()) != -1){
                System.out.print((char) ch);
                writer.write((char) ch);
            }
            writer.close();
            reader.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        FileOperation fo = new FileOperation();
        //fo.writeData("C:\\AIFS-CDEC-B3\\AIFS-CDEC-B3\\Java\\input.txt", "This is a new file");
        
        //fo.readData("C:\\AIFS-CDEC-B3\\AIFS-CDEC-B3\\Java\\input.txt");
        
        fo.readAndwrite("C:\\AIFS-CDEC-B3\\AIFS-CDEC-B3\\Java\\input.txt", "C:\\AIFS-CDEC-B3\\AIFS-CDEC-B3\\Java\\example.txt");
    }
}
