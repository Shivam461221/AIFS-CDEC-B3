package innerclass;

public class StaticOuter {
	static String message = "Outer";
	
	static class Inner{
		void display() {
			System.out.println(message);
		}
	}
	
	
	public static void main(String[] args) {
		StaticOuter.Inner inner = new StaticOuter.Inner();
		
		inner.display();
		
	}
}
