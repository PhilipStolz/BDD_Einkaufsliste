/**
 * File: Game.java
 * Creation Date: 23.12.2014
 *
 * Copyright © 2014 by HOOD GmbH – all rights reserved 
 */
package com.hoodgroup.tictactoe.model;

/**
 * This class implements the model of a tic tac toe game.
 * 
 * @author p_stolz
 *
 */
public class Game {
	
	/**
	 * Constructor.
	 *
	 */
	public Game(String name1, String name2) {
	    this.name1 = name1;
	    this.name2 = name2;
	    gameBoard = new char[][] {{' ', ' ', ' '},
	    		                  {' ', ' ', ' '},
	    		                  {' ', ' ', ' '}};
	    
	    lastPlayerNumber = -1;
	}
	
	/**
	 * This method checks a player's turn and returns true if the turn is OK,
	 * false else.
	 * 
	 * @param playerNumber 1 for player 1 or 2 for player 2
	 * @param x the column of the player's turn
	 * @param y the row of the player's turn
	 * @return true if the turn is OK, false else
	 */
	public boolean isTurnOK(int playerNumber, int x, int y) {
		
		if(playerNumber != lastPlayerNumber) {
		    if(gameBoard[y][x] == ' ') {
		    	return true;
		    }
		}
		
        return false;		
	}
	
	
	/**
	 * This method applies a player's turn.
	 * 
	 * @param playerNumber 1 for player 1 or 2 for player 2
	 * @param x the column of the player's turn
	 * @param y the row of the player's turn
	 */
	public void enterTurn(int playerNumber, int x, int y) {
		gameBoard[y][x] = ((playerNumber == 1)?'X':'O');	    
		lastPlayerNumber = playerNumber;
	}
	
	
	/**
	 * Returns the status of the game.
	 * 
	 * @return one of the following: GAME_ONGOING, GAME_WON or GAME_ENDED
	 */
	public GameState getState() {
		GameState result = GameState.GAME_ONGOING;

		for(int x = 0; (x < 3) && (result == GameState.GAME_ONGOING); x++) {
			if((gameBoard[0][x] == gameBoard[1][x]) && (gameBoard[0][x] == gameBoard[2][x]) 
					&& (gameBoard[0][x] != ' ')) {
				result = GameState.GAME_WON;
			}
		}
				
		for(int y = 0; (y < 3) && (result == GameState.GAME_ONGOING); y ++) {
			if((gameBoard[y][0] == gameBoard[y][1]) && (gameBoard[y][0] == gameBoard[y][2]) 
					&& (gameBoard[y][0] != ' ')) {
				result = GameState.GAME_WON;
			}			
		}
		
		if((gameBoard[0][0] == gameBoard[1][1]) && (gameBoard[1][1] == gameBoard[2][2])
				&& (gameBoard[0][0] != ' ')) {
			result = GameState.GAME_WON;
		}

		if((gameBoard[2][0] == gameBoard[1][1]) && (gameBoard[0][2] == gameBoard[1][1])
				&& (gameBoard[2][0] != ' ')) {
			result = GameState.GAME_WON;
		}
		
		if(result == GameState.GAME_ONGOING) {
			result = GameState.GAME_ENDED;
            for(int y = 0; (y < 3) && (result == GameState.GAME_ENDED); y++) {
            	for(int x = 0; (x < 3) && (result == GameState.GAME_ENDED); x++) {
            	    if(gameBoard[y][x] == ' ') {
            	    	result = GameState.GAME_ONGOING;
            	    }
            	}
            }
		}
		
		return result;
	}
	

	
	
	/**
	 * Returns the 1st player's name.
	 *
	 * @return the 1st player'sname
	 */
	public String getName1() {
		return name1;
	}


	/**
	 * Returns the name2.
	 *
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}


	/**
	 * Returns the gameBoard.
	 *
	 * @return the gameBoard as a <code>String</code>
	 */
	public String getGameBoard() {
		StringBuffer buf = new StringBuffer();
		
		for(int rowIdx = 0; rowIdx < 3; rowIdx ++) {
			for(int colIdx = 0; colIdx < 3; colIdx ++) {
				buf.append(this.gameBoard[rowIdx][colIdx]);
			}
			buf.append('\n');
		}
		
		return buf.toString();
	}



	public enum GameState {
		/**
		 * Indicates that the game is not finished yet.
		 */
		GAME_ONGOING,

		/**
		 * Indicates that the game has been won by a player.
		 */
		GAME_WON,

		/**
		 * Indicates that the game has ended but hasn't been won by anybody.
		 */
		GAME_ENDED
	}
	
	/**
	 * Stores the 1st player's name.
	 */
	private String name1;
	
	/**
	 * Stores the 2nd player's name.
	 */
	private String name2;
	
	/**
	 * Stores the last player's number.
	 */
	private int lastPlayerNumber;
	
	/**
	 * Stores the gameBoard
	 */
	private char [][] gameBoard;
}
