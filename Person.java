package MainPackage;

public class Person extends Entity {

	private String gender;
	
	//standard constructor
	public Person (String date, Date born, String gender, double difficulty) {
		super(date, born, difficulty);
		this.gender = gender;
		
	}
	
	//copy constructor
	Person(Person p) {
		super(p);
	}
	
	//outputs the detailed information of the person
	public String toString() {
		System.out.println("Name: " + getName() +
							"\nBorn: " + getDate() + 
							"\nGender: " + getGender() +
							"\n*************************");
		
		String n = ("Name: " + getName() +
				"\nBorn: " + getDate() + 
				"\nGender: " + getGender() +
				"\n*************************");
		return n;
	}

	//returns gender of the person
	public String getGender() {
		String g = gender;
		return g;
	}
	
	
	//returns a clone of the person object 
	public Entity clone() {
		Person P = new Person(this);
		return P;
	}

	//returns the type of entity the object is. In this case it returns person
	public String entityType() {
		String n = "This entity is a person!";
		return n;
	}
	
	
	
}
