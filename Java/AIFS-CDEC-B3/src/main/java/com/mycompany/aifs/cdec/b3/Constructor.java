/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aifs.cdec.b3;

public class Constructor {
    private String firstName;
    private String lastName;
    
    private int x ;
    
    //default constructor, parameterized constructor, No-argument constructor
    
    
    public Constructor(String firstName, String lastName, int x){
        this.firstName = firstName;
        this.lastName = lastName;
        this.x = x;
    }
    
    public Constructor(){
        this.firstName = "XYZ";
        this.lastName = "ABC";
        this.x = 12;
    }
    
    public Constructor(String firstName){
        this.firstName = firstName;
        this.lastName = "Singh";
    }
    
    public void show(){
        System.out.println(firstName+" "+lastName);
    }
    
    public static void main(String[] args) {
        Constructor obj1 = new Constructor("Shivam", "Lowanshi", 5);
        
       // obj1.firstName = "Shivam";
       
        System.out.println(obj1.x);
        
        obj1.show();
        
        Constructor obj2 = new Constructor("Sagar","Bhor", 6);
        
        obj2.show();
        
        Constructor obj3 = new Constructor();
        
        obj3.show();
        
        
        Constructor obj4 = new Constructor("Swaleha");
        
        obj4.show();
                
    }
}
