/**
 * File: Controller.java
 * Creation Date: 23.12.2014
 *
 * Copyright © 2014 by HOOD GmbH – all rights reserved 
 */
package com.hoodgroup.tictactoe.controller;

import com.hoodgroup.tictactoe.model.Game;

/**
 * This class implements the controller class of the tic tac toe game.
 * 
 * @author p_stolz
 *
 */
public class Controller {
	
	/**
	 * Constructor.
	 *
	 */
	private Controller() {
		state = ControllerState.WAITING_FOR_PLAYER_NAMES;
	}
	
	/**
	 * Enters the names of the players.
	 * 
	 * @param name1 the name of player 1
	 * @param name2 the name of player 2
	 */
	public void enterPlayerNames(String name1, String name2) {
		game = new Game(name1, name2);
		state = ControllerState.WAITING_FOR_PLAYER1S_TURN;
	}
	
	/**
	 * Enters the 1st player's turn.
	 * 
	 * @param x the column number (1st column is x=0)
	 * @param y the row number (1st row is y=0)
	 */
	private void enterTurnPlayer1sTurn(int x, int y)
	{
		if(game.isTurnOK(1, x, y)) {			
			game.enterTurn(1, x, y);
			
			switch(game.getState()) {	
			case GAME_ONGOING:
				state = ControllerState.WAITING_FOR_PLAYER2S_TURN;
				break;
			case GAME_WON:
				state = ControllerState.DISPLAYING_WINNER_MESSAGE_FOR_PLAYER1;				
				displayWinnerMessageForPlayer1();
				break;
			case GAME_ENDED:
				state = ControllerState.DISPLAYING_NO_WINNER_MESSAGE;				
				displayNoWinnerMessage();
				break;
			}
		}
		else {
			state = ControllerState.WAITING_FOR_PLAYER1S_TURN;
		}

	}
	
	
	/**
	 * Enters the 2nd player's turn.
	 * 
	 * @param x the column number (1st column is x=0)
	 * @param y the row number (1st row is y=0)
	 */
	private void enterTurnPlayer2sTurn(int x, int y)
	{
		if(game.isTurnOK(2, x, y)) {			
			game.enterTurn(2, x, y);
			
			switch(game.getState()) {	
			case GAME_ONGOING:
				state = ControllerState.WAITING_FOR_PLAYER1S_TURN;
				break;
			case GAME_WON:
				state = ControllerState.DISPLAYING_WINNER_MESSAGE_FOR_PLAYER2;				
				displayWinnerMessageForPlayer2();

				break;
			case GAME_ENDED:
				state = ControllerState.DISPLAYING_NO_WINNER_MESSAGE;				
				displayNoWinnerMessage();

				break;
			}
		}
		else {
			state = ControllerState.WAITING_FOR_PLAYER2S_TURN;
		}

	}	
	
	/**
	 * Enters a player's turn.
	 * 
	 * @param x the column number (1st column is x=0)
	 * @param y the row number (1st row is y=0)
	 */	
	public void enterTurn(int x, int y) {
		if(state == ControllerState.WAITING_FOR_PLAYER1S_TURN) {
			enterTurnPlayer1sTurn(x, y);
		}
		else {
			enterTurnPlayer2sTurn(x, y);
		}
	}
	
	/**
	 * Call this method when the user has confirmed a message.
	 */
	public void confirmMessage() {
		this.state = ControllerState.WAITING_FOR_PLAYER_NAMES;
	}

	
	/**
	 * Creates the winner message as a <code>String</code> for
	 * a specific player.
	 * 
	 * @param playerNo the number of the player (1 or 2).
	 * @return the message as a <code>String</code>.
	 */
	private String createWinnerMesage(int playerNo) {
		String message = null;
		
		String playerName = null;
		
		if(playerNo == 1) {
			playerName = game.getName1();
		}
		else {
			playerName = game.getName2();
		}
		
		message = playerName + " has won the game!";

		return message;
	}
	
	/**
	 * Displays the winner message for player 2.
	 */
	private void displayWinnerMessageForPlayer2() {
		if(ui != null) {
			ui.display(createWinnerMesage(2));
		}		
	}

	private void displayNoWinnerMessage() {
		if(ui != null) {
			ui.display("GAME OVER! No winner.");
		}				
	}

	private void displayWinnerMessageForPlayer1() {
		if(ui != null) {
			ui.display(createWinnerMesage(1));
		}
	}

	
	/**
	 * Returns the game.
	 *
	 * @return the game
	 */
	protected Game getGame() {
		return game;
	}

	/**
	 * Sets the game.
	 *
	 * @param game the game to set
	 */
	protected void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Returns the state.
	 *
	 * @return the state
	 */
	public ControllerState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the state to set
	 */
	protected void setState(ControllerState state) {
		this.state = state;
	}

	/**
	 * Returns the user interface.
	 *
	 * @return the user interface
	 */
	public IfcUserInterface getUi() {
		return ui;
	}

	/**
	 * Sets the ui.
	 *
	 * @param ui the ui to set
	 */
	public void setUi(IfcUserInterface ui) {
		this.ui = ui;
	}



	/**
	 * Returns the <code>Controller</code> instance.
	 * 
	 * @return the <code>Controller</code> instance.
	 */
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		
		return instance;
	}
	
	/**
	 * Returns the current content of the game board.
	 * 
	 * @return
	 */
	public String getGameBoardContent() {
		return this.game.getGameBoard();
	}

	/**
	 * Stores a reference to the game.
	 */
	private Game game;
	
	/**
	 * Controller states.
	 */
	public enum ControllerState {
	    WAITING_FOR_PLAYER_NAMES,
	    WAITING_FOR_PLAYER1S_TURN,
	    CHECKING_PLAYER1S_TURN,
	    CHECKING_GAME_STATUS_FOR_PLAYER1,
	    DISPLAYING_WINNER_MESSAGE_FOR_PLAYER1,
	    WAITING_FOR_PLAYER2S_TURN,	
	    CHECKING_PLAYER2S_TURN,
	    CHECKING_GAME_STATUS_FOR_PLAYER2,
	    DISPLAYING_WINNER_MESSAGE_FOR_PLAYER2,
	    DISPLAYING_NO_WINNER_MESSAGE
	}
	
	
	/**
	 * Stores the current status.
	 */
	private ControllerState state;
	
	/**
	 * Stores a reference to the user interface.
	 */
	private IfcUserInterface ui = null;

	/**
	 * Stores a reference to the <code>Controller</code> instance.
	 */
	private static Controller instance;
}
