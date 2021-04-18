package org.tictactoe.tdd.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeGameTest {
	
	private static final int POS_1 = 1;
	private static final char MOVE_X = 'X';
	private static final String PLAYER_X = "Player_X";
	
	private TicTacToeGame game;
	
	@BeforeEach
	public void init() {
		game = new TicTacToeGame();
	}

	@Test
	public void playerOneShouldBeAbleToMakeMoveInAnyPositionAndIdentifyTheSame() {
		game.makeMoveAt(POS_1, POS_1, MOVE_X);
		assertEquals(MOVE_X, game.identifyMoveAt(POS_1, POS_1));
	}
	
	@Test
	public void indentifyPlayerByObservingMoveAtAnyGivenLocation() {
		game.makeMoveAt(POS_1, POS_1, MOVE_X);
		assertEquals(PLAYER_X, game.identifyPlayerForGivenLocation(POS_1, POS_1));
	}

}
