/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author shiva
 */
public class ThrowsKeyword {

    public void readData(String path) throws IOException {
        FileReader reader = new FileReader(path);

        int ch;
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }

    }

    public static void main(String[] args) {
        ThrowsKeyword th = new ThrowsKeyword();

        try {
            th.readData("");
        } catch (IOException e) {
            System.out.println("File was not found");
        }
    }
}
