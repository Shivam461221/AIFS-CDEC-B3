/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingapplication;

public class Account {

    int accountNumber;
    String accountHolder;
    double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " New Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
    
    
    public void displayAccountDetails(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder: "+accountHolder);
        System.out.println("Balance: "+balance);
    }
    
}
