/**
 * File: TicTacToe.java
 * Creation Date: 07.01.2015
 *
 * Copyright © 2015 by HOOD GmbH – all rights reserved 
 */
package com.hoodgroup.tictactoe;

import javax.swing.SwingUtilities;

import com.hoodgroup.tictactoe.gui.SimpleUserInterface;

/**
 * This class is the main class of the TicTacToe game.
 * 
 * @author p_stolz
 *
 */
public class TicTacToe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			    public void run() {
			    	new SimpleUserInterface();
			    }
			  });        
	}

}
