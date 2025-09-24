/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.constructor;

public class Plot {
    private double length ;
    private double breadth;
    private String sector;
    
    public Plot(){
        this.length = 100;
        this.breadth = 50;
        this.sector = "A";
    }
    
    public Plot(double breadth){
        this.length = 100;
        this.breadth = breadth;
        this.sector = "B";
    }
    
    public Plot(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
        this.sector = "C";
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
    public double getArea(){
        return length*breadth;
    }
   
    
    
}
