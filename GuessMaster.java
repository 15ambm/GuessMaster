package MainPackage;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GuessMaster { //GuessMaster Class
	
	
	private int numCanEntities; //maximum number of entities that can be used in the game 
	private Entity[] entities; //array of entities
	
	private int eUsed = 0; //The number of entities being held in the array of entities 
	
	private int totalTickets = 0; //Total number of tickets over the course of a game
	
	//Constructor, sets entity array to null;
	public GuessMaster(int num) {
		numCanEntities = num;
		entities = new Entity[numCanEntities];	
		for (int i = 0; i < numCanEntities;i++) {
			entities[i] = null;	
		}
	}
	public GuessMaster() { //default constructor, this is assuming the user likely wont exceed 99 entities
		this(99);
	}

	
	//Iterates through the entities array and if an index contains null, set it to the entitiy e
	//If it iterates through the entire array and no null entries, do nothing
	public void addEntity (Entity e) {
		
		for (int i = 0; i < entities.length;i++) {//for loop iterates through list of entities until it either finds a null index or goes 
			if (entities[i] == null) {			//through the entire loop. If null index is found, place entity at that index
				entities[i] = e;
				eUsed++;
				return;
			} 
		}
		System.out.println("array is full");
	}
	
	
	private Date getInput(int num) { //takes index of entity in array
		
		Scanner sc = new Scanner(System.in);

			while (true) {	
				String input = sc.next();//takes input as string
				if (input.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") //compares the format of the input date and the required format
						|| input.matches("([0-9]{1})/([0-9]{2})/([0-9]{4})") //allows for users to enter 1/11/1111
								|| input.matches("([0-9]{2})/([0-9]{1})/([0-9]{4})") // 			or 11/1/1111
									|| input.matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")) {  // 	or 1/1/1111
					Date out = new Date(input); // call the String to Date method 
					return out; //return the date that was made in str2date
				} else if (input.equals("quit")) { //if the user types quit, exit the program
					System.exit(0);
				} else { //if the input format does not match above options, 
					System.out.print("Improper format, please enter a proper format: ");
				}
			}
	}
	
		public boolean checkInput (Date input, int personID) { //Checks if the date given is good or not
				
				if (input.equals(entities[personID].getDate())) { //if the input from user matches persons date, you win
					System.out.println("\n**********BINGO**********");
					totalTickets += entities[personID].getTickets();
					System.out.println("You won " + entities[personID].getTickets() + " tickets this turn.\nYour total tickets so far are: " 
							+ totalTickets + "\n*************************");
					entities[personID].toString();
					return true;
				} else if(input.precedes(entities[personID].getDate())) { //if input precedes the correct date
					System.out.print("**********Incorrect********** \nTry a later date: ");
					return false;
				} else {
					System.out.print("**********Incorrect********** \nTry an earlier date: ");//if input date is after the correct date
					return false;
				}
						
				
			
			}
		
		
	public void playGame() { //runs the game
		
		boolean check = true; //a boolean which will terminate the while loop when the game is done
		Date input = new Date(); //creating a date to store the user input in playGame();
		
		System.out.println("Welcome to Guess Master! Please enter the date in the format mm/dd/yyyy. "
				+ "\nIf the format is inccorect you will get an error."
				+ "\nType quit to exit the game");
		
		while(check) { //primary game loop. Game runs while check is true
			
			int rand = (int)(Math.random() * eUsed); //chooses a random index within bounds of array of entities   
			
			System.out.println(entities[rand].welcomeMessage());
			System.out.print("Guess the birthday of " + entities[rand].getName() + " : ");
				while(true) {
					input = getInput(rand); //takes user input and the array index of entity
					boolean outcome = checkInput(input,rand); //determines whether answer is correct or not
					if(outcome) { //if correct, break the loop and choose a new person
						 break;
					}
				}
		}
		
	}
	
		public static void main(String[] args) { //Main Method
		

				/*The first Date parameter in the following line is
				the birth date of the singer and the second Date parameter
				is the release date of the debut album.*/
				
				// The last parameter of the follow line is the difficulty score described above.
				
				Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25,1971), "Male", "Liberal", 0.25);
			
				Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female","La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
				
				Person myCreator = new Person("myCreator", new Date("September", 1, 2000),"Female", 1);
				
				Country usa = new Country("United States", new Date("July", 4, 1776), "Washington D.C.", 0.1);
				
				GuessMaster gm = new GuessMaster();
				gm.addEntity(trudeau);
				gm.addEntity(dion);
				gm.addEntity(myCreator);
				gm.addEntity(usa);
				gm.playGame();
			
				
			
			}
	
	

}
