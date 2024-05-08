package ticTacToe;

import javax.swing.JOptionPane;

public class TicTacToeMain {
	public static void main(String args[]) {
		//new instance of the classes containing game methods, sets results count to 0 via constructor
		BoardExtras board = new BoardExtras();
		//boolean to keep track if the win conditions have been achieved
		boolean gameOver = false;
		
		JOptionPane.showMessageDialog(null, "Welcome to the grand game of Xs and Os (aka TicTacToe, Noughts and Crosses). "
		+ "\nYou may face off against another player or a random number generator. \nMay the best player win!");
		//asks the user if a second human player is present
		board.setPlayer2(JOptionPane.showInputDialog(null, "Would you like to play against second player? (Y/N)"));
		//main loop which lets the user restart the game
		while(true) {
			//when newGame remains True the game will be run indefinitely
			if(board.newGame) {
				//sets-up/resets the game board
				board.initializeBoard();
			
			//loop managing the turns, while gameOver is false the players will keep taking turns
			while(!gameOver){
				//board is drawn and player is asked where they want to place an "X" mark on the board
				board.drawBoard();
				board.setPlay("X", (board.validateInput("player 1")-1));
				//opponents turn, if player2 is set to false a check for winner will be performed, if there is no winner
				//computer will make a move, then another check for winner will be performed, if there is a win/draw at any point
				//the game will stop and the appropriate results counter will be incremented
				if(!board.player2) {
					board.checkWinner();
					if(!board.winner.equals("null")) {
						gameOver = true;
						if(!board.winner.equals("draw")) {
							JOptionPane.showMessageDialog(null, board.winner + "s have won!!!");
							board.drawBoard();
							break;
						}
						if(board.winner.equals("draw")) {
							JOptionPane.showMessageDialog(null, "It's a "+board.winner+".");
							board.drawBoard();
							break;
						}
					}
					board.setCompPlay("O");
					board.checkWinner();
					if(!board.winner.equals("null")) {
						gameOver = true;
						if(!board.winner.equals("draw")) {
							JOptionPane.showMessageDialog(null, board.winner + "s have won!!!");
							board.drawBoard();
							break;
						}
						if(board.winner.equals("draw")) {
							JOptionPane.showMessageDialog(null, "It's a "+board.winner+".");
							board.drawBoard();
							break;
						}
					}
				}
				//same as above but includes player2
				//checks for winner/draw prior to start of player2's turn
				if(board.player2) {
					board.checkWinner();
					if(!board.winner.equals("null")) {
						gameOver = true;
						if(!board.winner.equals("draw")) {
							JOptionPane.showMessageDialog(null, board.winner + "s have won!!!");
							board.drawBoard();
							break;
						}
						if(board.winner.equals("draw")) {
							JOptionPane.showMessageDialog(null, "It's a "+board.winner+".");
							board.drawBoard();
							break;
						}
					}
					//draws board, asks player2 where to put an "O", re-checks for winner
					board.drawBoard();
					board.setPlay("O", (board.validateInput("player 2")-1));
					board.checkWinner();
					if(!board.winner.equals("null")) {
						gameOver = true;
						if(!board.winner.equals("draw")) {
							JOptionPane.showMessageDialog(null, board.winner + "s have won!!!");
							board.drawBoard();
							break;
							}
						if(board.winner.equals("draw")) {
							JOptionPane.showMessageDialog(null, "It's a "+board.winner+".");
							board.drawBoard();
							break;
						}	        		
					}				
				}
				
			}
			//asks user if another round is to be played
			board.newGame(JOptionPane.showInputDialog(null, "Would you like to play aanother game? (Y/N)"));
			gameOver = false;
			}
			if(!board.newGame) {
				break;
			}
		}
		//asks user if results of the games should be save and what to name to save file
		board.saveGameResults(JOptionPane.showInputDialog(null, "Would you like to save the game results? (Y/N)"), 
				JOptionPane.showInputDialog(null, "Please enter name for the save file."));
	}
}	