package MainPackage;

public class Country extends Entity {

	private String capital;
	
	//standard constructor
	public Country (String date, Date born, String capital, double difficulty) {
		super(date, born, difficulty);
		this.capital = capital;
	}
	
	//copy constructor
	Country(Country c) {
		super(c);
		this.capital = c.capital;
	}
	
	//outputs the detailed information of the Country
	public String toString() {
		System.out.println("Name: " + getName() +
							"\nBorn: " + getDate() + 
							"\nCapital: " + capital +
							"\n*************************");
		
		
		String n = ("Name: " + getName() +
				"\nBorn: " + getDate() + 
				"\nCapital: " + capital);
		return n;
	}

	//returns a clone of the country object 
	public Entity clone() {
		Country C = new Country(this);
		return C;
	}

	
	//returns the type of entity the object is. In this case it returns country
	public String entityType() {
		String n = "This entity is a country!";
		return n;
	}
	
	
	
}
