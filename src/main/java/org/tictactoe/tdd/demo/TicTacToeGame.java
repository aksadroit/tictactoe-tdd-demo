package org.tictactoe.tdd.demo;

public class TicTacToeGame {

	private char[][] gameBoard = new char[3][3];
	
	public void makeMoveAt(int row, int column, char playerMove) {
		gameBoard[row][column] = playerMove;
	}

	public char identifyMoveAt(int row, int column) {
		return gameBoard[row][column];
	}
	
}
