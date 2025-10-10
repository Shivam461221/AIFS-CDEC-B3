package innerclass;

public class Outer {
	int x = 10;
	
	class Inner{
		
		void display() {
			System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		
		Outer.Inner inner = outer.new Inner();
		
		inner.display();
		
	}
}
