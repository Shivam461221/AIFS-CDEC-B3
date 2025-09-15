
import com.mycompany.aifs.cdec.b3.Methods;


public class Methods2 {
    
    //parameter - these are the varibles pass to methods 
    //argument - these are the actual values passed during function calling
    
    private int x = 10;
    
    private int y = 20;
    
    private int sum;
    
    public int getSum(int a, int b){ //parameters
        a = 100;
        return a+b;
    }
    
    public void getProduct(int a, int b){
        System.out.println(a*b);
    }
    
    
    public static void main(String[] args) {
        Methods obj = new Methods();
        
        obj.show();
        
        Methods.getData();
        
        Methods2 obj2 = new Methods2();
        
        obj2.sum = obj2.getSum(obj2.x, obj2.y);
        
        System.out.println(obj2.getSum(23, 35));  //arguments
        
        obj2.getProduct(19, 10);
    }
}
