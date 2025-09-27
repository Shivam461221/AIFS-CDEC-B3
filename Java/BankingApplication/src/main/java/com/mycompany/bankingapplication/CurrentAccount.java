/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingapplication;

/**
 *
 * @author shiva
 */
public class CurrentAccount extends Account{
        double overdraftLimit;   //1000

    public CurrentAccount(double overdraftLimit, int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }
        
    @Override
    public void withdraw(double amount){
        if(balance+overdraftLimit>=amount){
            balance-=amount;
            System.out.println("Withdrawn: "+amount+" new balance :"+balance);
        }
        else{
            System.out.println("Overdraft Limit has been exceeded");
        }
    }
}
