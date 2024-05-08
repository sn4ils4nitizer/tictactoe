package ticTacToe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class BoardExtras extends Board {
	
	//boolean variables to keep track if another human player is present and if the game is to be restarted
	boolean player2 = false;
	boolean newGame = true;
	
	//method for computer to place an "O" in a random place
	public void setCompPlay(String choice) {
		Random rand = new Random();
		while(true) {			
			int position = rand.nextInt(9);
			if(!getGameBoard()[position].equals("X") && !getGameBoard()[position].equals("O")) {	
				getGameBoard()[position] = choice;
				break;
			}
		}
	}
	
	//method for player to provide input, check if the input is in bounds of the gameBoard
	//and if the chosen space is already occupied by "X" or "O"
	public int validateInput(String player) {
		int input;
			
		while(true) {			
			input = Integer.parseInt(JOptionPane.showInputDialog(player));		
			if(input < 1 || input > 9) {
				JOptionPane.showMessageDialog(null, "Invalid Input. Enter a number between 1 and 9.\n\nFIX YOUR INPUT NOW!");
				input = Integer.parseInt(JOptionPane.showInputDialog(player));
			}
			if(getGameBoard()[input-1].equals("X")||getGameBoard()[input-1].equals("O")) {
				JOptionPane.showMessageDialog(null, "This field is already populated. Please choose an empty field.");
			}
			else
				break;
		}
		return input;
	}
	
	//method to set if a second human player is present
	public void setPlayer2(String choice) {
		
		while(!choice.toUpperCase().equals("Y") || !choice.toUpperCase().equals("N") ) {
			if(choice.toUpperCase().equals("Y")) {
				player2 = true;
				break;
			}
			if(choice.toUpperCase().equals("N")) {
				break;
			}
			choice = JOptionPane.showInputDialog(null, "Enter 'Y' for YES or 'N' for NO.");
		}
	}
	
	//method to set if new game is to be played
	public void newGame(String choice) {
			while(!choice.toUpperCase().equals("Y") || !choice.toUpperCase().equals("N")) {
			if(choice.toUpperCase().equals("Y")) {
				newGame = true;
				break;
			}
			if(choice.toUpperCase().equals("N")) {
				newGame = false;
				break;
			}
			choice = JOptionPane.showInputDialog(null, "Enter 'Y' for YES or 'N' for NO.");
		}
	}
	
	//method to save results to file, lets the user name the file
	public void saveGameResults(String choice, String filename) {
		while(!choice.toUpperCase().equals("Y") || !choice.toUpperCase().equals("N")) {
			if(choice.toUpperCase().equals("Y")) {
				try{
					FileWriter gameResults = new FileWriter(filename + ".txt");
					gameResults.write("In a grand total of " + ((getXWins()) + getOWins() + getDraws()) + " matches results were the following:");
					gameResults.write("\n\nXs have won " + getXWins() + " matches.");
					gameResults.write("\n\nOs have won " + getOWins() + " matches.");
					gameResults.write("\n\nDraws have occured in " + getDraws() + " matches.");
					gameResults.close();
					JOptionPane.showMessageDialog(null, "Game results have been successfully saved to a file!");
					}
				catch(IOException e) {
					JOptionPane.showMessageDialog(null, "An error has occured. File cannot be saved.");
					}
				break;
			}
			if(choice.toUpperCase().equals("N")) {
				break;
			}
			choice = JOptionPane.showInputDialog(null, "Enter 'Y' for YES or 'N' for NO.");
			filename = JOptionPane.showInputDialog(null, "Please re-enter the file name.");
		}
	}
	
}
