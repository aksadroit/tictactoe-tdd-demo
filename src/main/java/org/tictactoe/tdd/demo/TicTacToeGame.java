package org.tictactoe.tdd.demo;

public class TicTacToeGame {

	private char[][] gameBoard = new char[3][3];
	
	public void makeMoveAt(int row, int column, char playerMove) {
		gameBoard[row][column] = playerMove;
	}

	public char identifyMoveAt(int row, int column) {
		return gameBoard[row][column];
	}

	public String identifyPlayerForGivenLocation(int i, int j) {
		String player;
		
		if (identifyMoveAt(i, j) == 'X')
			player = "Player_X";
		else {
			player = "Player_O";
		}
		return player;
	}
	
}
