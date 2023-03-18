package matchGame;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Sound {
	public void playSoundGameOver() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playSoundGameOver()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method play (streams) a sound from a file when the game is over.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Method used into the gameOver() method.
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		String dingLocation = "Audio/wah.wav";		                                                            //Sets the location into a String.
		try {                                                                                                   //Try/Catch
			File dingFile = new File(dingLocation);                                                             //Declares and instantiates a file object from location.
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);                         //Declares and Sets the file into a Stream object.
			Clip dingSound = AudioSystem.getClip();			                                                    //Uses Clip object to open and plays the sound.
			dingSound.open(dingAudioFile);                                                                      //Opens the sound clip.
			dingSound.start();		                                                                            //Plays the sound clip.
		} catch (Exception e) {                                                                                 //Catches the exception.
			JOptionPane.showMessageDialog(null, "Problem playing sound");                                       //Shows a message dialog with the exception
		}                                                                                                       
	}                                                                                                           
																												
	public void playSoundNextStage() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playSoundNextStage()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method play (streams) a sound from a file when the game goes to the next stage.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Method used into the nextStage() method.
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		String dingLocation = "Audio/levelUp.wav";		                                                        //Sets the location into a String.
		try {                                                                                                   //Try/Catch
			File dingFile = new File(dingLocation);                                                             //Declares and instantiates a file object from location.
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);                         //Declares and Sets the file into a Stream object.
			Clip dingSound = AudioSystem.getClip();			                                                    //Uses Clip object to open and plays the sound.
			dingSound.open(dingAudioFile);                                                                      //Opens the sound clip.
			dingSound.start();		                                                                            //Plays the sound clip.
		} catch (Exception e) {                                                                                 //Catches the exception.
			JOptionPane.showMessageDialog(null, "Problem playing sound");                                       //Shows a message dialog with the exception
		}                                                                                                       
	}                                                                                                           
																												
	public void playSoundRightSequence() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playSoundRightSequence()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method play (streams) a sound from a file when the the player does the correct sequence.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Method used into the rightSequence() method.
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		String dingLocation = "Audio/ding.wav";		                                                            //Sets the location into a String.
		try {                                                                                                   //Try/Catch
			File dingFile = new File(dingLocation);                                                             //Declares and instantiates a file object from location.
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);                         //Declares and Sets the file into a Stream object.
			Clip dingSound = AudioSystem.getClip();			                                                    //Uses Clip object to open and plays the sound.
			dingSound.open(dingAudioFile);                                                                      //Opens the sound clip.
			dingSound.start();		                                                                            //Plays the sound clip.
		} catch (Exception e) {                                                                                 //Catches the exception.
			JOptionPane.showMessageDialog(null, "Problem playing sound");                                       //Shows a message dialog with the exception
		}                                                                                                       
	}                                                                                                           
																												
	public void playSoundWrongSequence() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playSoundWrongSequence()
		//
		// Method parameters	:	none
		//
		// Method return		:	none
		//
		// Synopsis				:   This method play (streams) a sound from a file when the the player does the incorrect sequence.							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-08		Tiago   				Method used into the wrongSequence() method.
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		String dingLocation = "Audio/wrong.wav";		                                                        //Sets the location into a String.
		try {                                                                                                   //Try/Catch
			File dingFile = new File(dingLocation);                                                             //Declares and instantiates a file object from location.
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);                         //Declares and Sets the file into a Stream object.
			Clip dingSound = AudioSystem.getClip();			                                                    //Uses Clip object to open and plays the sound.
			dingSound.open(dingAudioFile);                                                                      //Opens the sound clip.
			dingSound.start();		                                                                            //Plays the sound clip.
		} catch (Exception e) {                                                                                 //Catches the exception.
			JOptionPane.showMessageDialog(null, "Problem playing sound");                                       //Shows a message dialog with the exception
		}                                                                                                       
	} 
}
