
package com.mycompany.oops;

public class Encapsulation {
    
    //Access Modifiers
    //private, public, protected, default
    private String privateVariable = "private";
    
    public String publicVariable = "Public";
    
    protected String protectedVariable = "Protected";
    
    String defaultVariable = "Default";
    
    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();
        
        System.out.println(obj.privateVariable);
    }
    
}
