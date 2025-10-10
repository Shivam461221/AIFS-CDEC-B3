package object;

public class Animal{
	
	String name;
	String specie;
	
	public Animal(String name, String specie) {
		this.name = name;
		this.specie = specie;
	}
	
	public String toString() {
		return "Object { name:" +name+", species: "+specie+" }";
	}
	
	public boolean equals(Object obj) {
		Animal animal = (Animal) obj;
		return this.name.equals(animal.name) && this.specie.equals(animal.specie);
	}
	
	public static void main(String[] args) {
		Animal tiger = new Animal("Tiger", "Cat");
		
		Animal elephant = new Animal("Elephant", "Mammal"); 
		Animal elephant2 = new Animal("Elephant", "Mammal");
		
		System.out.println(elephant.toString());
		
		System.out.println(elephant.equals(elephant2));
		
		System.out.println(tiger.hashCode());
		
		String s = "str";
		
		int arr[] = {1,2,3,4};
		
		System.out.println(arr.getClass().getName());
	}
	
	
}
