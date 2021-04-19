package org.tictactoe.tdd.demo;

import org.tictactoe.tdd.exception.PositionAlreadyOccupiedException;
import org.tictactoe.tdd.exception.PositionOutOfRangeException;

public class TicTacToeGame {

	private static final int GAME_BOARD_SIZE = 3;
	private static final char MOVE_X = 'X';
	private static final char MOVE_O = 'O';
	private static final char EMPTY = '\0';
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

	public void play(int row, int column) throws PositionAlreadyOccupiedException, PositionOutOfRangeException {
		if (!isPositionWithinRange(row, column)) {
			throw new PositionOutOfRangeException("");
		}
		
		if (isPositionAvailableToPlay(row, column)) {
			currentMove = getNextMove();
			makeMoveAt(row, column, currentMove);
		} else {
			throw new PositionAlreadyOccupiedException("Position ("+row+", "+column+") is already occupied. Please choose a different position");
		}
		
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

	public boolean isPositionAvailableToPlay(int row, int column) {
		return gameBoard[row][column] == EMPTY;
	}

	public boolean isPositionWithinRange(int row, int column) {
		return (row >=0 && row <= 2 && column >=0 && column <= 2);
	}
	
}
