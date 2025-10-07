/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptionhandling.custom;

/**
 *
 * @author shiva
 */
public class Test {

    void readFile() throws RuntimeException {
        throw new RuntimeException("File was not found");
    }

    public static void main(String[] args) {
        Test t1 = new Test();

        try {
            t1.readFile();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
