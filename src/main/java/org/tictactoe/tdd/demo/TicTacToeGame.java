package org.tictactoe.tdd.demo;

public class TicTacToeGame {

	private char[][] gameBoard = new char[3][3];
	
	public void makeMoveAt(int i, int j, char c) {
		gameBoard[i][j] = c;
	}

	public char identifyMoveAt(int i, int j) {
		return gameBoard[i][j];
	}
	
}
