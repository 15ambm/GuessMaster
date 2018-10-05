package MainPackage;

public class Politician extends Person{

	private String party;
	
	//standard constructor
	public Politician(String date, Date born, String gender, String party, double difficulty) {
		super(date, born, gender, difficulty);
		this.party = party;
		
	}
	
	//copy constructor
	Politician(Politician p) {
		super(p);
	}
	
	//outputs the detailed information of the politician
	public String toString() {
		System.out.println("Name: " + getName() +
							"\nBorn: " + getDate() + 
							"\nGender: " + getGender() +
							"\nParty: " + party +
							"\n*************************");
		
		String n = ("Name: " + getName() +
				"\nBorn: " + getDate() + 
				"\nGender: " + getGender() +
				"\nParty: " + party +
				"\n*************************");
		return n;
	}
	
	
	//returns a clone of the politician object 
	public Entity clone() {
		Politician P = new Politician(this);
		return P;
	}

	//returns the type of entity the object is. In this case it returns politician
	public String entityType() {
		String n = "This entity is a politician!";
		return n;
	}
	
	
	
}
