package MainPackage;

public abstract class Entity { //Entity Class

	//Instance variables 
	private String name; 
	private Date born;
	private double difficulty; 
	
	//constructor, sets the name and date of the entity
	public Entity (String name, Date born, double diff) {
		this.name = name;
		this.born = born;
		this.difficulty = diff;
		
	}
	
	//copy constructor
	Entity(Entity e) {
		name = e.name;
		born = e.born;
		difficulty = e.difficulty;
	}
	
	//returns number of tickets awarded to the player for correctly guessing an entitys birthday
	public int getTickets() {
		return (int)(difficulty*100);
	}
	
	public abstract Entity clone();
	
	public abstract String entityType();
	
	public String welcomeMessage() {
		String n = "\nWelcome! Let's start the game! " + entityType();
		return n;
	}
	
	public String closingMessage() {
		String n = "Congratulations! The detailed information of the entity is: " + toString();
		return n;
	}
	
	
	//returns the name of the person
	public String getName() { 
		String n = this.name;
		return n;
	}
	
	//returns the birthday of the person
	public Date getDate() { 
		Date d = new Date();
		d = born;
		return d;
	}
	
	//outputs and returns a string that displays the data in the entity
	public String toString() { 
		System.out.println(name + ", born on " + born);
		String n = (name + ", born on " + born);
		return n;
	}
	
	//compares two entities and returns true if they're equal
	public boolean equals(Entity entity) { 
		if (entity.name.equals(this.name)) {
			if (entity.born.equals(this.born)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
