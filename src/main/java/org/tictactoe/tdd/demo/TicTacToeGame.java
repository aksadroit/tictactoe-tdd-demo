package org.tictactoe.tdd.demo;

public class TicTacToeGame {

	private static final int GAME_BOARD_SIZE = 3;
	private static final char MOVE_X = 'X';
	private static final String PLAYER_X = "Player_X";
	private static final String PLAYER_Y = "Player_Y";
	
	
	private char[][] gameBoard = new char[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
	
	
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
			player = PLAYER_Y;
		}
		return player;
	}

	public void play(int row, int column) {
		makeMoveAt(row, column, MOVE_X);
	}
	
}
