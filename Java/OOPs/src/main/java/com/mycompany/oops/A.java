
package com.mycompany.oops;

public class A {
    private int x;
    private int y;
    
    public A(){
        this(10, 20);
    }
    
    
    public A(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void getSum(){
        int sum = x+y;
        this.display(sum);
    }
    
    void display(int result){
        System.out.println(result);
    }
    
    
    public static void main(String[] args) {
        
        
        A obj = new A(10, 20);
        
       // System.out.println(obj.getSum());
        
        A obj2 = new A(20, 30);
        
       // System.out.println(obj2.getSum());
       
        obj2.getSum();
        
        A obj3 = new A();
        
        System.out.println(obj3.y);
    }
    
}
