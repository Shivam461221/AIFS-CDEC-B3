
package com.mycompany.bankingapplication;

public class BankingApplication {

    public static void main(String[] args) {
        System.out.println("Banking Application");
        
        SavingAccount sa = new SavingAccount(101, "Shivam Lowanshi", 1000, 4);
        
        sa.displayAccountDetails();
        sa.deposit(2000);
        sa.withdraw(2000);
        sa.calculateInterest();
        
        System.out.println("-----------------------------------------");
        
        CurrentAccount ca = new CurrentAccount(2000, 103, "Sagar", 3000);
        ca.displayAccountDetails();
        ca.withdraw(5000);
        ca.deposit(3000);
    }
}
