package org.tictactoe.tdd.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tictactoe.tdd.exception.PositionAlreadyOccupiedException;
import org.tictactoe.tdd.exception.PositionOutOfRangeException;

public class TicTacToeGameTest {
	
	private static final int POS_0 = 0;
	private static final int POS_1 = 1;
	private static final int POS_2 = 2;
	private static final char MOVE_X = 'X';
	private static final String PLAYER_X = "Player_X";
	private static final String PLAYER_O = "Player_O";
	
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
	
	@Test
	public void markFirstMoveMadeByPlayerAsX() throws PositionAlreadyOccupiedException, PositionOutOfRangeException {
		game.play(POS_1, POS_1);
		assertEquals(PLAYER_X, game.identifyPlayerForGivenLocation(POS_1, POS_1));
	}
	
	@Test
	public void alternativelySwitchBetweenPlayersWhenPlaying() throws PositionAlreadyOccupiedException, PositionOutOfRangeException {
		game.play(POS_1, POS_1);
		assertEquals(PLAYER_X, game.identifyPlayerForGivenLocation(POS_1, POS_1));
		
		game.play(POS_0, POS_2);
		assertEquals(PLAYER_O, game.identifyPlayerForGivenLocation(POS_0, POS_2));
	}
	
	@Test
	public void checkIfTheSelectedPositionOnBoardIsEmpty() {
		assertTrue(game.isPositionAvailableToPlay(POS_1, POS_1));
	}
	
	@Test
	public void shouldThrowExceptionIfChoosenAlreadyOccupiedLocation() throws PositionAlreadyOccupiedException, PositionOutOfRangeException {
		game.play(POS_1, POS_1);
		assertThrows(PositionAlreadyOccupiedException.class, () -> game.play(POS_1, POS_1));
	}
	
	@Test
	public void checkExceptionMessageIfPositionAlreadyOccupied() throws PositionAlreadyOccupiedException, PositionOutOfRangeException {
		game.play(POS_1, POS_1);
		PositionAlreadyOccupiedException exceptionThrown = assertThrows(PositionAlreadyOccupiedException.class, () -> game.play(POS_1, POS_1));
		assertTrue(exceptionThrown.getMessage().contains("(1, 1)"));
	}
	
	@Test
	public void checkIfTheProvidedPositionIsWithinRange() {
		assertTrue(game.isPositionWithinRange(POS_1, POS_2));
	}
	
	@Test
	public void shouldThrowExceptionIfPositionIsOutOfRange() throws PositionAlreadyOccupiedException, PositionOutOfRangeException {
		assertThrows(PositionOutOfRangeException.class, () -> game.play(POS_1, 3));
	}
	
	@Test
	public void checkExceptionMessageIfPositionIsOutOfRange() throws PositionAlreadyOccupiedException, PositionOutOfRangeException {
		PositionOutOfRangeException exception = assertThrows(PositionOutOfRangeException.class, () -> game.play(POS_1, 3));
		assertTrue(exception.getMessage().contains("Invalid Position..!!"));
	}

}
