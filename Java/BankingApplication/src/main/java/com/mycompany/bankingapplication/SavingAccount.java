/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingapplication;

/**
 *
 * @author shiva
 */
public class SavingAccount extends Account{
    double interestPercentage;
    
    public SavingAccount(int accountNumber, String accountHolder, double balance, double interestPercentage){
        super(accountNumber, accountHolder, balance);
        this.interestPercentage = interestPercentage;
    }
    
    public void calculateInterest(){
        double interest = balance*interestPercentage/100;
        System.out.println("Interest: "+interest);
    }
    
    @Override
    public void withdraw(double amount){
            if(balance-amount<1000){
                System.out.println("Cannot Withraw, minimum balance must be maintained");
            }
            else{
                super.withdraw(amount);
            }
    }
}
