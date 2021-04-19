package org.tictactoe.tdd.demo;

public class TicTacToeGame {

	private static final int GAME_BOARD_SIZE = 3;
	private static final char MOVE_X = 'X';
	private static final char MOVE_O = 'O';
	private static final String PLAYER_X = "Player_X";
	private static final String PLAYER_O = "Player_O";
	
	
	private char[][] gameBoard = new char[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
	private char currentMove;
	
	
	public void makeMoveAt(int row, int column, char playerMove) {
		gameBoard[row][column] = playerMove;
	}

	public char identifyMoveAt(int row, int column) {
		return gameBoard[row][column];
	}

	public String identifyPlayerForGivenLocation(int row, int column) {
		String player;
		
		if (identifyMoveAt(row, column) == MOVE_X)
			player = PLAYER_X;
		else {
			player = PLAYER_O;
		}
		return player;
	}

	public void play(int row, int column) {
		currentMove = getNextMove();
		makeMoveAt(row, column, currentMove);
	}
	
	private char getNextMove() {
		char nextMove;
		if (currentMove == MOVE_X) {
			nextMove = MOVE_O;
		} else {
			nextMove = MOVE_X;
		}
		return nextMove;
	}

	public boolean isPositionAvailableToPlay(int pos1, int pos12) {
		boolean isAvailable = false;
		if (gameBoard[pos1][pos12] == '\0') {
			isAvailable = true;
		}
		return isAvailable;
	}
	
}
