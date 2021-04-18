package org.tictactoe.tdd.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TicTacToeGameTest {

	@Test
	public void playerOneShouldBeAbleToMakeMoveInAnyPositionAndIdentifyTheSame() {
		TicTacToeGame game = new TicTacToeGame();
		game.makeMoveAt(1, 1, 'X');
		assertEquals('X', game.identifyMoveAt(1, 1));
	}
	
	@Test
	public void indentifyPlayerByObservingMoveAtAnyGivenLocation() {
		TicTacToeGame game = new TicTacToeGame();
		game.makeMoveAt(1, 1, 'X');
		assertEquals("Player_X", game.identifyPlayerForGivenLocation(1, 1));
	}

}
