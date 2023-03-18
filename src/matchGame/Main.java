package matchGame;

import java.awt.*;																		//Library with containers that contains other components like buttons, text fields, labels, etc.
import javax.swing.*;                                                                   //Library that provides a set of "lightweight"(all-Java language) components.
import javax.swing.border.EmptyBorder;                                                  //A class which provides an empty, transparent border which takes up space but does no drawing.
import java.awt.event.*;                                                      			//Library that provides interfaces and classes for dealing with different types of events fired by AWT components.
																						
public class Main extends JFrame{	
																						
	private static final long serialVersionUID = 1L;                                    //Declares and sets a serialization for JFrame.
	private int milliseconds = 50;                                                      //Declares and sets a data member for milliseconds.
	private int position = 0;	                                                        //Declares and sets a data member for arrays positions.
	private int counter = 0;                                                            //Declares and sets a data member for counting the rounds.
	private int pointStage = 1;                                                         //Declares and sets a data member for a stage multiplier.
																						
	private static int INITIAL = 10;                                                    //Declares and sets a static data member for points to be multiplied by pointStage.
	private static Color DEFAULT_RED = new Color(153, 0, 0);                            //Declares and sets a data member for red color.
	private static Color DEFAULT_GREEN = new Color(0, 153, 0);                          //Declares and sets a data member for green color.
	private static Color DEFAULT_BLUE = new Color(0, 0, 153);                           //Declares and sets a data member for blue color.
	private static Color DEFAULT_YELLOW = new Color(204, 204, 0);                       //Declares and sets a data member for yellow color.
																						
	private Game game = new Game();                                                     //Instantiates an object to inherit all the methods for the game class.
	private Timer timer;	                                                            //Declares a timer for the colors blink.
	private JPanel contentPane;                                                         //Instantiates a JPanel.
	private JLayeredPane ldpGamePane;                                                   //JLayeredPane adds depth to a Swing container, allowing components to overlap each other when needed.
	private JButton btnRedLight;                                                        //Declares a JButton for the red light.
	private JButton btnGreenLight;                                                      //Declares a JButton for the green light.
	private JButton btnBlueLight;                                                       //Declares a JButton for the blue light.
	private JButton btnYellowLight;                                                     //Declares a JButton for the yellow light.
	private JButton btnNewGame;                                                         //Declares a JButton to start the game.
	private JLabel lblInstructions;                                                     //Declares a JLabel to show the instructions to the user.
	private JLabel lblScore;                                                            //Declares a JLabel to show the score reference.
	private JLabel lblScorePoints;                                                      //Declares a JLabel to show the score.
	private JLabel lblAuthor;                                                           //Declares a JLabel to show the author.
																						
	JOptionPane scorePane = new JOptionPane();	                                        //Declares and instantiates a JPanel.
	
	public static void main(String[] args) {   
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void main()
		//
		// Method parameters	:	String[] args - the method permits String command line parameters to be entered
		//
		// Method return		:	void
		//
		// Synopsis				:   This is the main method that generates the main frame for the content pane layer.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		EventQueue.invokeLater(new Runnable() {                                         //Posts an event (Runnable) at the end of Swings event list and is processed after all previous GUI events are processed.
			public void run() {                                                         
				try {                                                                   //Try/Catch to set visible the main frame.
					Main window = new Main();                                           
					window.setVisible(true);                                            
				} catch (Exception e) {                                                 
					e.printStackTrace();                                                
				}                                                                       
			}                                                                           
		});                                                                             
	}                                                                                   
																						
	public Main() {
		setTitle("Match Game");
		initialize();                                                                   //Creates the application.
	}                                                                                   
																						
	public void nextRound() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void nextRound()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method calls a method to generates a random color sequence and starts the timer to show the sequence.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				none
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		timer.stop(); 																	//Stops the timer.
		game.addComputerCharRound();		                                            //Add the random color sequence into computer's dynamic array.
		lblInstructions.setText("Next round!");		                                    //Show information into a label.
		timer.start();                                                                  //Starts the timer.
	}                                                                                   
																						
	public void nextStage() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void nextStage()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method calls a method to generates a random color (plus one color) sequence and starts the timer to show the sequence.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				none
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		timer.stop(); 																	//Stops the timer.
		pointStage++;                                                                   //Add to the pointStage for multiplication purposes.
		counter = 0;                                                                    //Resets the counter.
		game.addComputerCharStage();		                                            //Add the random color sequence into computer's dynamic array.
		lblInstructions.setText("Stage: " + pointStage);		                        //Show information into a label.
		game.playSoundNextStage();                                                      //Play a sound
		timer.start();                                                                  //Starts the timer.
	}                                                                                   
																						
	public void gameOver() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void gameOver()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method calls a method that removes the sequence and disable all the buttons.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				none
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		timer.stop(); 																	//Stops the timer.
		lblInstructions.setText("GAME OVER");                                           //Show information into a label.
		game.playSoundGameOver();                                                       //Play a sound.
		game.getPlayerCharSeq().clear();                                                //Removes the content in the player's dynamic array.
		if(game.getScore() < 0) {                                                       //Test if score is less then 0 to show or not the score. 
			lblScorePoints.setText("");                                                 //Hide the score.
		}else {                                                                         //else
			lblScorePoints.setText("" + game.getScore());		                        //Show the score.
		}                                                                               //
		btnRedLight.setEnabled(false);                                                  //Disable button.
		btnGreenLight.setEnabled(false);                                                //Disable button.
		btnBlueLight.setEnabled(false);                                                 //Disable button.
		btnYellowLight.setEnabled(false);		                                        //Disable button.
	}                                                                                   
																						
	public void rightSequence() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void rightSequence()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method sets the points to the player and calls a method that goes to the next round or next level.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				none
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		lblInstructions.setText("Correct!");                                            //Show information into a label.
		game.playSoundRightSequence();                                                  //Play a sound.
		game.setScore(game.getScore() + (INITIAL * pointStage));						//Math to calculate points according to the stage. 
		lblScorePoints.setText("" + game.getScore());                                   //Show information into a label.
		game.getPlayerCharSeq().clear();                                                //Removes the content in the player's dynamic array.
		counter++;		                                                                //Add to counter.
		if(counter == 4) {                                                              //Test is counter is equal to 4 to jump to the next stage.
			game.pause(300);			                                                //Pause all threads.
			//nextStage();						                                        //Go to next stage.
			nextRound();							                                    //Go to next round.
		}else {                                                                         //else
			game.pause(300);                                                            //Pause all threads.
			nextRound();							                                    //Go to next round.
		}                                                                               
	}                                                                                   
																						
	public void wrongSequence() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void rightSequence()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method sets the points to the player and calls a method that goes to the next round or next level.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				none
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		lblInstructions.setText("Incorrect!");                                          //Show information into a label.
		game.playSoundWrongSequence();                                                  //Play a sound.
		game.setScore(game.getScore() - ((INITIAL * pointStage) * 2));					//Math to calculate points according to the stage.
		lblScorePoints.setText("" + game.getScore());                                   //Show information into a label.
		game.pause(250);                                                                //Pause all threads.
		game.getPlayerCharSeq().clear();                                                //Removes the content in the player's dynamic array.
		counter--;                                                                      //Subtract from counter.
		nextRound();                                                                    //Go to next round.
	}                                                                                   
																						
	private void initialize() {  
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void initialize()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method contains the timer, also all the buttons and labels.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				none
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
																						
		setBounds(100, 100, 720, 420);		                                            //Sets the window's dimensions.
		
		timer = new Timer(400, new ActionListener() {                                   //Timer object with a listener to blink the colors. 
			@Override                                                                   
			public void actionPerformed(ActionEvent e) {				                
				if(game.getScore() >= 0) {					                            //Test if game score is greater then zero to test the buttons status.
					if (btnRedLight.getBackground().equals(Color.RED) ||                //Test if the color is ON (colors are lightning).
							btnGreenLight.getBackground().equals(Color.GREEN) ||        
							btnBlueLight.getBackground().equals(Color.BLUE) ||          
							btnYellowLight.getBackground().equals(Color.YELLOW)) {	    
						btnRedLight.setBackground(DEFAULT_RED);                         //Set color to default.
						btnGreenLight.setBackground(DEFAULT_GREEN);                     //Set color to default.
						btnBlueLight.setBackground(DEFAULT_BLUE);                       //Set color to default.
						btnYellowLight.setBackground(DEFAULT_YELLOW);                   //Set color to default.
					}else if (position < game.getComputerCharSeq().size()) {            //Test if position is less then the size of computer's dynamic array.
						switch(game.getComputerChar(position)) {                        //Switch to check which color will blink according to the array position.
						case 'R':                                                       //In case of R in the dynamic array
							btnRedLight.setBackground(Color.RED);                       //Sets the red color on background
							break;                                                      
						case 'G':                                                       //In case of G in the dynamic array
							btnGreenLight.setBackground(Color.GREEN);                   //Sets the green color on background
							break;                                                      
						case 'B':                                                       //In case of B in the dynamic array
							btnBlueLight.setBackground(Color.BLUE);                     //Sets the blue color on background
							break;                                                      
						case 'Y':                                                       //In case of Y in the dynamic array
							btnYellowLight.setBackground(Color.YELLOW);                 //Sets the yellow color on background
							break;                                                      
						default:                                                        
							break;                                                      
						}                                                               
						position++;                                                     //Increase position to get the next index in the array.
					} else {                                                            //else
						position = 0;                                                   //Resets the array position.
						timer.stop();                                                   //Stops the timer.
					}                                                                   
				} else {                                                                //else
					position = 0;                                                       //Resets the position.
					pointStage = 1;                                                     //Resets the stage points.
					counter = 1;                                                        //Resets the counter.
					timer.stop();                                                       //Stops the timer.
				}                                                                       
			}                                                                           
		});                                                                             
																						
		contentPane = new JPanel();                                                     //Instantiates Panel object.
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));                             //Set borders to the panel.
		contentPane.setLayout(new BorderLayout(0, 0));                                  //Set layout to the panel.
		setContentPane(contentPane);                                                    //Allows content into panel.
																						
		ldpGamePane = new JLayeredPane();                                               //Instantiates a layer object.
		contentPane.add(ldpGamePane, BorderLayout.CENTER);                              //Add the layer into content panel.
																						
		lblInstructions = new JLabel("");                                               //Instantiates a label object.
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 28));                     //Sets a font type and size.
		lblInstructions.setHorizontalTextPosition(SwingConstants.CENTER);	            //Sets a position.
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);                  //Sets an alignment.
		lblInstructions.setBounds(10, 81, 341, 58);                                     //Set bounds.
		ldpGamePane.add(lblInstructions);                                               //Add the label into layer.
																						
		lblScore = new JLabel("Score:");                                                //Instantiates a label object.
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 28));                            //Sets a font type and size.		 
		lblScore.setBounds(34, 186, 99, 33);                                            //Set bounds.
		ldpGamePane.add(lblScore);		                                                //Add the label into layer.
																						
		lblScorePoints = new JLabel("" + game.getScore());                              //Instantiates a label object.
		lblScorePoints.setFont(new Font("Tahoma", Font.BOLD, 28));                      //Sets a font type and size.		
		lblScorePoints.setBounds(132, 186, 208, 33);                                    //Set bounds.
		ldpGamePane.add(lblScorePoints);                                                //Add the label into layer.
																						
		btnNewGame = new JButton("New Game");                                           //Instantiates a button object.
		btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 25));                          //Sets a font type and size.
		btnNewGame.setBounds(28, 266, 226, 58);                                         //Set bounds.
		ldpGamePane.add(btnNewGame);                                                    //Add the label into layer.
																						
		btnNewGame.addActionListener(new ActionListener() {                             //New Game button listener.
			public void actionPerformed(ActionEvent e) {                                
				timer.stop();				                                            //Stops the timer.
				lblInstructions.setText("Let's start!");			                    //Show information into a label to the player.
				game = new Game();                                                      //Instantiates a new game object.
				lblScorePoints.setText("" + game.getScore());                           //Show information into a label to the player.
				position = 0;                                                           //Resets the position.
				timer.start();                                                          //Starts the timer.
				btnRedLight.setEnabled(true);                                           //Disable button.
				btnGreenLight.setEnabled(true);                                         //Disable button.
				btnBlueLight.setEnabled(true);                                          //Disable button.
				btnYellowLight.setEnabled(true);                                        //Disable button.
			}                                                                           
		});                                                                             
																						
		btnGreenLight = new JButton("");                                                //Instantiates a button object.
		btnGreenLight.addActionListener(new ActionListener() {                          //Button listener.
			public void actionPerformed(ActionEvent e) {				                
				btnGreenLight.setBackground(Color.GREEN);                               //Sets color to the background.
				game.pause(milliseconds);                                               //Pause all threads for 50 milliseconds.
				btnGreenLight.setBackground(DEFAULT_GREEN);                             //Sets default color to the background.
				game.pause(milliseconds);                                               //Pause all threads for 50 milliseconds.
				if(game.comparePlayerInput('G')) {                                      //Compares player input with the computer's dynamic array.
					if(game.compareSizes()) {						                    //Compare sizes (player's array and computer's array).
						rightSequence();                                                //Give points to the player and starts a new round or stage.
					}                                                                   
					else {                                                              //else
						lblInstructions.setText("Keep going...");                       //Informs player to keeping picking colors.
					}                                                                   
				}else {                                                                 //else
					wrongSequence();                                                    //Take points to the player and starts a new round.
				}                                                                       
																						
				if(game.getScore() < 0) {                                               //Verifies if player got less points than zero.
					gameOver();					                                        //Finishes the game.
				}                                                                       
			}                                                                           
		});		                                                                        
		btnGreenLight.setBackground(DEFAULT_GREEN);                                     //Sets a default background color.
		btnGreenLight.setBorder(null);                                                  //Sets no border.		
		btnGreenLight.setBounds(350, 26, 150, 152);                                     //Set bounds.
		ldpGamePane.add(btnGreenLight);                                                 //Add the button into layer.
																						
		btnRedLight = new JButton("");                                                  //Instantiates a button object.
		btnRedLight.addActionListener(new ActionListener() {                            //Button listener.
			public void actionPerformed(ActionEvent e) {                                
				btnRedLight.setBackground(Color.RED);                                   //Sets color to the background.
				game.pause(milliseconds);                                               //Pause all threads for 50 milliseconds.
				btnRedLight.setBackground(DEFAULT_RED);                                 //Sets default color to the background.
				game.pause(milliseconds);                                               //Pause all threads for 50 milliseconds.
				if(game.comparePlayerInput('R')) {                                      //Compares player input with the computer's dynamic array.
					if(game.compareSizes()) {                                           //Compare sizes (player's array and computer's array).
						rightSequence();                                                //Give points to the player and starts a new round or stage.
					}                                                                   
					else {                                                              //else
						lblInstructions.setText("Keep going...");                       //Informs player to keeping picking colors.
					}                                                                   
				}else {                                                                 //else
					wrongSequence();                                                    //Take points to the player and starts a new round.
				}                                                                       
																						
				if(game.getScore() < 0) {                                               //Verifies if player got less points than zero.
					gameOver();					                                        //Finishes the game.
				}                                                                       
			}                                                                           
		});                                                                             
		btnRedLight.setBackground(DEFAULT_RED);                                         //Sets a default background color.
		btnRedLight.setBorder(null);                                                    //Sets no border.		
		btnRedLight.setBounds(504, 26, 150, 152);                                       //Set bounds.
		ldpGamePane.add(btnRedLight);                                                   //Add the button into layer.
																						
		btnBlueLight = new JButton("");                                                 //Instantiates a button object.
		btnBlueLight.addActionListener(new ActionListener() {                           //Button listener.
			public void actionPerformed(ActionEvent e) {                                
				btnBlueLight.setBackground(Color.BLUE);                                 //Sets color to the background.
				game.pause(milliseconds);                                               //Pause all threads for 50 milliseconds.
				btnBlueLight.setBackground(DEFAULT_BLUE);                               //Sets default color to the background.
				game.pause(milliseconds);                                               //Pause all threads for 50 milliseconds.
				if(game.comparePlayerInput('B')) {                                      //Compares player input with the computer's dynamic array.
					if(game.compareSizes()) {                                           //Compare sizes (player's array and computer's array).
						rightSequence();                                                //Give points to the player and starts a new round or stage.
					}                                                                   
					else {                                                              //else
						lblInstructions.setText("Keep going...");                       //Informs player to keeping picking colors.
					}                                                                   
				}else {                                                                 //else
					wrongSequence();                                                    //Take points to the player and starts a new round.
				}                                                                       
																						
				if(game.getScore() < 0) {                                               //Verifies if player got less points than zero.
					gameOver();					                                        //Finishes the game.
				}                                                                       
			}                                                                           
		});                                                                             
		btnBlueLight.setBackground(DEFAULT_BLUE);                                       //Sets a default background color.
		btnBlueLight.setBorder(null);                                                   //Sets no border.		
		btnBlueLight.setBounds(350, 180, 150, 152);                                     //Set bounds.
		ldpGamePane.add(btnBlueLight);                                                  //Add the button into layer.
																						
		btnYellowLight = new JButton("");                                               //Instantiates a button object.
		btnYellowLight.addActionListener(new ActionListener() {                         //Button listener.
			public void actionPerformed(ActionEvent e) {                                
				btnYellowLight.setBackground(Color.YELLOW);                             //Sets color to the background.
				game.pause(milliseconds);                                               //Pause all threads for 50 milliseconds.
				btnYellowLight.setBackground(DEFAULT_YELLOW);                           //Sets default color to the background.
				game.pause(milliseconds);                                               //Pause all threads for 50 milliseconds.
				if(game.comparePlayerInput('Y')) {                                      //Compares player input with the computer's dynamic array.
					if(game.compareSizes()) {                                           //Compare sizes (player's array and computer's array).
						rightSequence();                                                //Give points to the player and starts a new round or stage.
					}                                                                   
					else {                                                              //else
						lblInstructions.setText("Keep going...");                       //Informs player to keeping picking colors.
					}                                                                   
				}else {                                                                 //else
					wrongSequence();                                                    //Take points to the player and starts a new round.
				}                                                                       
																						
				if(game.getScore() < 0) {                                               //Verifies if player got less points than zero.
					gameOver();					                                        //Finishes the game.
				}                                                                       
			}                                                                           
		});                                                                             
		btnYellowLight.setBackground(DEFAULT_YELLOW);                                   //Sets a default background color.
		btnYellowLight.setBorder(null);                                                 //Sets no border.		
		btnYellowLight.setBounds(504, 180, 150, 152);                                   //Set bounds.
		ldpGamePane.add(btnYellowLight);                                                //Add the button into layer.
																						
		lblAuthor = new JLabel("Match Game by Tiago");                                  //Instantiates a label object.
		lblAuthor.setFont(new Font("Tahoma", Font.ITALIC, 11));                         //Sets a font type and size.	
		lblAuthor.setBounds(550, 346, 111, 14);                                         //Set bounds.
		ldpGamePane.add(lblAuthor);                                                     //Add the label into layer.
	}
}
