
package com.mycompany.strings;

public class StringExample {
    String str1 = "Shivam";
    
    String str2 = new String("Lowanshi");
    
    public static void main(String[] args) {
        
        String name = "Java";
        
        String surname = "Language";
        
        System.out.println(name.length());
        
        System.out.println(name.toLowerCase());
        
        System.out.println(name.toUpperCase());
        
        System.out.println(name.substring(2));
        
        System.out.println(name.contains("Jax"));
        
        System.out.println(name.replace("va", "xa"));
        
        System.out.println(name.concat(surname));
        
        
        
    }
}
