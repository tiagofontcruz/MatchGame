package matchGame;																								
																												                                                                                           //User interfaces and operating systems use system-dependent pathname strings to name files and directories.
import java.util.*;                                                                                             //Contains the collections framework, legacy collection classes, event model, date and time facilities, internationalization, and miscellaneous utility classes.
																				
public class Game extends Sound{
	private ArrayList<Character> computerCharSeq;                                                               //Declare dynamic array for computer
	private ArrayList<Character> playerCharSeq;                                                                 //Declare dynamic array for player
	private Random random;                                                                       				//Declare object random class
	private int score;                                                                                          //Declare score for player
	private char[] colors = {'R', 'G', 'B', 'Y'};                                                               //Declare and add elements into a static array
																												
	public Game() {                                                                                             
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Game()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This constructor method instantiates the dynamic arrays for computer and player, set initial score, set initial							
		//							random color sequence. 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Constructor Method
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		super();                                                                                                //Use to call the parent class’s constructor (defaul).
		this.computerCharSeq = new ArrayList<>();                                                               //Instantiate dynamic array for computer.
		this.playerCharSeq = new ArrayList<>();                                                                 //Instantiate dynamic array for player.
		this.random = new Random();                                                                             //Instantiate random object to randomize colors.
		this.score = 0;		                                                                                    //Initiate score. 
		for (int i = 0; i < 3; i++) {                                                                           //For loop to fill with 4 colors. 
			computerCharSeq.add(colors[random.nextInt(4)]);			                                            //Add a random color into computer's dynamic array.
		}                                                                                                       
	}                                                                                                           

	//GETTER METHOD FOR SCORE
	public int getScore() {		                                                                                
		return this.score;                                                                                      //Return player's score.
	}                                                                                                           
	
	//SETTER METHOD FOR SCORE
	public void setScore(int score) {                                                                           
		this.score = score;                                                                                     //Set the player's score.
	}                                                                                                           
																												
	//GETTER METHOD FOR COMPUTER'S DYNAMIC ARRAY POSITION
	public char getComputerChar(int index) {                                                                    
		return computerCharSeq.get(index);                                                                      //Return the computer's color in a specific position.
	}                                                                                                           
																												
	//GETTER METHOD FOR PLAYER'S DYNAMIC ARRAY POSITION
	public char getPlayerChar(int index) {                                                                      
		return playerCharSeq.get(index);                                                                        //Return the player's color in a specific position.
	}                                                                                                           

	//GETTER METHOD FOR COMPUTER'S DYNAMIC ARRAY
	public ArrayList<Character> getComputerCharSeq() {                                                          
		return computerCharSeq;                                                                                 //Return the computer's dynamic array.
	}                                                                                                           
	
	//GETTER METHOD FOR PLAYER'S DYNAMIC ARRAY
	public ArrayList<Character> getPlayerCharSeq() {                                                            
		return playerCharSeq;                                                                                   //Return the player's dynamic array.
	}                                                                                                           
																												
	public void addComputerCharRound() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void addComputerCharRound()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method stores the size of a dynamic array, removes the content and generates a new random color sequence.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Method used into the nextRound() method.
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		int size = computerCharSeq.size();                                                                      //Stores the size of the computer's dynamic array.
		computerCharSeq.clear();                                                                                //Removes computer's dynamic arrays content.
		playerCharSeq.clear();                                                                                  //Removes player's dynamic arrays content.
		for (int i = 0; i < size; i++) {                                                                        //For loop to fill with 4 colors. 
			computerCharSeq.add(colors[random.nextInt(4)]);			                                            //Add a random color sequence into computer's dynamic array.
		}                                                                                                       
	}                                                                                                           
																												
	public void addComputerCharStage() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void addComputerCharStage()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method stores the size of a dynamic array, removes the content and generates a new random color sequence plus one color.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Method used into the nextStage() method.
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		int size = computerCharSeq.size();                                                                      //Stores the size of the computer's dynamic array.
		computerCharSeq.clear();                                                                                //Removes computer's dynamic arrays content.
		playerCharSeq.clear();                                                                                  //Removes player's dynamic arrays content.
		for (int i = 0; i < size + 1; i++) {                                                                    //For loop to fill with 4 colors. 
			computerCharSeq.add(colors[random.nextInt(4)]);			                                            //Add a random color sequence into computer's dynamic array plus one color.
		}                                                                                                       
	}                                                                                                           
																												
	public boolean comparePlayerInput(char color) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	boolean comparePlayerInput()
		//
		// Method parameters	:	char color
		//
		// Method return		:	boolean match
		//
		// Synopsis				:   This method adds a new color to the player's dynamic array and compares it with the computer's dynamic array's position.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Method used into the colors buttons.
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		boolean match = false;                                                                                  //Declare and Set a boolean value to return a result.
		playerCharSeq.add(color);                                                                               //Add a new color into the player's dynamic array.
		if (computerCharSeq.get(playerCharSeq.size()-1).equals(playerCharSeq.get(playerCharSeq.size()-1))) {    //Compares dynamic arrays (player and computer).
			match = true;                                                                                       //Sets true if both arrays have the same color.
		}                                                                                                       
		return match;                                                                                           //Return a boolean
	}                                                                                                           
																												
	public boolean compareSizes() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	boolean compareSizes()
		//
		// Method parameters	:	none
		//
		// Method return		:	boolean identicalSize
		//
		// Synopsis				:   This method compares the player's dynamic array size with the computer's dynamic array.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Method used into the colors buttons.
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		boolean identicalSize = false;
		if(computerCharSeq.size() == playerCharSeq.size()) {                                                    //Compares dynamic arrays size.
			identicalSize = true;                                                                               //Sets true if both arrays have the same size.
		}  
		return identicalSize;																					//Return a boolean.
	}                                                                                                                                                                                                                     
																												
	public void pause(int ms) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void pause()
		//
		// Method parameters	:	none
		//
		// Method return		:	int ms
		//
		// Synopsis				:   This method pause all threads for milliseconds. Used for specific situations with player's interactions.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				none
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		try {                                                                                                   //Try/Catch
			Thread.sleep(ms);                                                                                   //Put to sleep all threads for milliseconds.
		} catch (InterruptedException e) {                                                                      //Catches the exception.
			Thread.currentThread().interrupt();			                                                        //Treats the exception.
		}                                                                                                       
	}                                                                                                           
}                                                                                                               