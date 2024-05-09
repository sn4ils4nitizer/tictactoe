package ticTacToe;

import javax.swing.JOptionPane;
import java.util.*;

public class Board { 
	//array to hold Xs and Os, limited to nine slots
	final int POSITION = 9;
	private String[] gameBoard = new String[POSITION];
	//variable to keep track of who is the winner and to track the results
	public String winner;
	private int xWins;
	private int oWins;
	private int draws;

	//function to initialize the win counter variable starting at 0
	Board() {
		xWins = 0;   
		oWins = 0;   	
		draws = 0;   	
	}
	
	//function to initialize board, also used to clear the previous games when starting new ones
	public void initializeBoard() {
		winner = "null";
        for (int i = 0; i < 9; i++) {
            getGameBoard()[i] = String.valueOf(i + 1);
        }
	}
	
	//function to display the current state of the board
	public void drawBoard(){
		JOptionPane.showMessageDialog(null, getGameBoard()[0] +" "+ getGameBoard()[1] +" "+ getGameBoard()[2] + "\n"
										 +  getGameBoard()[3] +" "+ getGameBoard()[4] +" "+ getGameBoard()[5] + "\n"
										 +  getGameBoard()[6] +" "+ getGameBoard()[7] +" "+ getGameBoard()[8] + "\n");
    }
	
	//function to check for winner after each move, appropriate counters go up after each results is achieved
	public void checkWinner(){
        for (int i = 0; i < 8; i++) {
           String line = null;
           switch(i){
           //win cases for rows
           case 0:
               line = getGameBoard()[0] + getGameBoard()[1] + getGameBoard()[2];
               break;
           case 1:
               line = getGameBoard()[3] + getGameBoard()[4] + getGameBoard()[5];
               break;
           case 2:
               line = getGameBoard()[6] + getGameBoard()[7] + getGameBoard()[8];
               break;
           //win cases for diagonals
           case 3:
               line = getGameBoard()[0] + getGameBoard()[4] + getGameBoard()[8];
               break;
           case 4:
               line = getGameBoard()[6] + getGameBoard()[4] + getGameBoard()[2];
               break;
           //win cases for columns
           case 5:
               line = getGameBoard()[0] + getGameBoard()[3] + getGameBoard()[6];
               break;
           case 6:
               line = getGameBoard()[1] + getGameBoard()[4] + getGameBoard()[7];
               break;
           case 7:
               line = getGameBoard()[2] + getGameBoard()[5] + getGameBoard()[8];
               break;
           }
           //For X winner
           if (line.equals("XXX")) {
               winner = "X";
               xWins ++;
           }
            
           // For O winner
           else if (line.equals("OOO")) {
               winner = "O";
               oWins ++;
           }
       }
           //loop that checks for draws, checks if there are unoccupied spaces, if there is no win by either side
           //by the 8th iteration the result is assumed to be a draw
           for (int a = 0; a < 9; a++) {
        	   if (Arrays.asList(getGameBoard()).contains(
                   String.valueOf(a + 1))) {
               break;
        	   }
        	   else if (a == 8) {
        		   winner = "draw";
        		   draws ++;
        	   }
           }
	
	}

	//getter method for the gameBoard fields
	public String[] getGameBoard() {
		return gameBoard;
	}
	
	//method to set player by human layers
	public String setPlay(String choice, int place){
        getGameBoard()[place] = choice;
        return choice;
    }
	
	//getter methods for each result counter
	public int getXWins() {
		return xWins;
	}
	public int getOWins() {
		return oWins;
	}
	public int getDraws() {
		return draws;
	}
}
