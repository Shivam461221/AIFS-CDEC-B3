package object;

public class Finalize {

	protected void finalize() {
		System.out.println("Finalize called");
	}

	public static void main(String[] args) {
		Finalize f1 = new Finalize();

		Finalize f2 = new Finalize();
		
		 f1 = null;
		 f2 = null;

		System.gc();
		
		//final, finally, finalize
	}

}
