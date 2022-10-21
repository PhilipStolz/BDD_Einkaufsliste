/**
 * File: SimpleUserInterface.java
 * Creation Date: 07.01.2015
 *
 * Copyright © 2015 by HOOD GmbH – all rights reserved 
 */
package com.hoodgroup.tictactoe.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.hoodgroup.tictactoe.controller.Controller;
import com.hoodgroup.tictactoe.controller.IfcUserInterface;
import com.hoodgroup.tictactoe.controller.Controller.ControllerState;

/**
 * Implements a simple user interface.
 * 
 * @author p_stolz
 *
 */
public class SimpleUserInterface extends JFrame implements ActionListener, IfcUserInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleUserInterface() {
		
		controller = Controller.getInstance();
		controller.setUi(this);
		
		this.playerNamesDialog = new PlayerNamesDialog(this);
		
		this.setTitle("TicTacToe - Simple User Interface");
		
		loadIcons();
		
		this.gameboard = new JButton[3][3];
		
		Container contentPanel = this.getContentPane();
		contentPanel.setLayout(new GridLayout(3, 3));
		
		for(int rowIdx = 0; rowIdx < 3; rowIdx ++) {			
			for(int colIdx = 0; colIdx < 3; colIdx ++) {
				JButton newButton = new JButton(this.emptyIcon);
				gameboard[rowIdx][colIdx] = newButton;
				newButton.setActionCommand("TURN");
				newButton.addActionListener(this);
				contentPanel.add(newButton);
			}
		}
		
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		promptUserForPlayerNames();
	}

	
	
	private void promptUserForPlayerNames() {
		if(controller.getState() 
				== ControllerState.WAITING_FOR_PLAYER_NAMES) {
		    if(!this.playerNamesDialog.isVisible()) {
		    	this.playerNamesDialog.setVisible(true);
		    }
		}
	}
	
	
	
	/**
	 * Updates the game board according to the controller.
	 */
	private void updateGameBoard() {
		String gameBoardContent = controller.getGameBoardContent();
		
		for(int rowIdx = 0; rowIdx < 3; rowIdx ++) {
			for(int colIdx = 0; colIdx < 3; colIdx ++) {
				JButton button = this.gameboard[rowIdx][colIdx];
				
				switch(gameBoardContent.charAt(rowIdx * 4 + colIdx)) {
				case 'X':
					button.setIcon(this.xIcon);
					break;
				case 'O':
					button.setIcon(this.oIcon);
					break;
				default:
					button.setIcon(this.emptyIcon);
				}
			}
		}
	}


	private void loadIcons() {
		oIcon     = new ImageIcon(getClass().getResource("/com/hoodgroup/tictactoe/gui/resources/O.png"));
		xIcon     = new ImageIcon(getClass().getResource("/com/hoodgroup/tictactoe/gui/resources/X.png"));
		emptyIcon = new ImageIcon(getClass().getResource("/com/hoodgroup/tictactoe/gui/resources/empty.png"));		
	}
	
	
	private JButton[][] gameboard = null;
	
	private final Controller controller; 
	
	private ImageIcon oIcon = null;
	private ImageIcon xIcon = null;
	private ImageIcon emptyIcon = null;
	
	private PlayerNamesDialog playerNamesDialog;

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("TURN")) {
		    Object srcButton = event.getSource();
		    
		    boolean turnEntered = false;
		    
			for(int rowIdx = 0; (rowIdx < 3) && (!turnEntered); rowIdx ++) {			
				for(int colIdx = 0; (colIdx < 3) && (!turnEntered); colIdx ++) {
					if(srcButton == gameboard[rowIdx][colIdx]) {
						controller.enterTurn(colIdx, rowIdx);
						turnEntered = true;
					}
				}
			}			
			
			if(turnEntered) {
				updateGameBoard();
			}
		}
	}



	@Override
	public void display(String message) {
        updateGameBoard();
        JOptionPane.showMessageDialog(this, message);
        controller.confirmMessage();
        promptUserForPlayerNames();
	}
}
