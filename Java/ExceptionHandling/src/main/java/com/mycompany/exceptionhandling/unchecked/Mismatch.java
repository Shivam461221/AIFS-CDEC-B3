/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptionhandling.unchecked;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author shiva
 */
public class Mismatch {

    public static void main(String[] args) {
        int a;

        try (Scanner sc = new Scanner(System.in);) {
            a = sc.nextInt();
            System.out.println(a);
        } catch (InputMismatchException e) {
            System.out.println("Please enter integer only");
        }
    }

}
