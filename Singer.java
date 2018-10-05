package MainPackage;

public class Singer extends Person{

	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	
	//standard constructor
	public Singer(String date, Date born, String gender, String debut, Date debutDate, double difficulty) {
		super(date, born, gender, difficulty);
		debutAlbum =  debut;
		debutAlbumReleaseDate = debutDate;
	}
	
	//copy constructor
	Singer(Singer s) {
		super(s);
	}
	
	//outputs the detailed information of the singer
	public String toString() {
		System.out.println("Name: " + getName() +
							"\nBorn: " + getDate() + 
							"\nGender: " + getGender() +
							"\nDebut Album: " + debutAlbum +
							"\nDebut Album Release Date: " + debutAlbumReleaseDate + 
							"\n*************************");
		String n = ("Name: " + getName() +
				"\nBorn: " + getDate() + 
				"\nGender: " + getGender() +
				"\nDebut Album: " + debutAlbum +
				"\nDebut Album Release Date: " + debutAlbumReleaseDate + 
				"\n*************************");
		return n;
	}
	
	
	//returns a clone of the singer object 
	public Entity clone() {
		Singer S = new Singer(this);
		return S;
	}

	//returns the type of entity the object is. In this case it returns singer
	public String entityType() {
		String n = "This entity is a singer!";
		return n;
	}
	
	
}
