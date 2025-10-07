/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptionhandling;

import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import javax.imageio.IIOException;

/**
 *
 * @author shiva
 */
public class Throw {

    public void readData(String path) throws IOException {
        throw new IOException("File was not found");
    }

    public static void main(String[] args) {
        ThrowsKeyword th = new ThrowsKeyword();

        try {
            th.readData("fjdkjf");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
