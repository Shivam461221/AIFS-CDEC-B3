package com.mycompany.aifs.cdec.b3;

public class Car {
    //instance variables/attributes
    private String brand = "Fronx";
    private String model = "Delta CNG";
    private double price = 1000000;
    private String color = "White";
    
    static String features = "Mialege";
    
    
    //methods/functions
    public void start(){
        System.out.println("Car started");
        
    }
    
    public String getBrand(){
        return brand;
        
    }
    
    public void stop(){
        System.out.println("Car stopped");
    }
    
    static void show(){
        System.out.println("Static method");
    }
    //non-static -
    //static - 
    
    public static void main(String[] args) {
        Car f1 = new Car();
        
        Car f2 = new Car();
        
        System.out.println(f1.brand);
        
        f1.start();

       // System.out.println(f1.brand);
       
        System.out.println(features);
        
        show();
    }
    
    

}
