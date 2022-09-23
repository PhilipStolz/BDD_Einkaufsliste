/**
 * File: PlayerNamesDialog.java
 * Creation Date: 08.01.2015
 *
 * Copyright © 2015 by HOOD GmbH – all rights reserved 
 */
package com.hoodgroup.tictactoe.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hoodgroup.tictactoe.controller.Controller;

/**
 * This class implements the dialog for entering the player names.
 * 
 * @author p_stolz
 *
 */
public class PlayerNamesDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayerNamesDialog(Frame owner) {
		super(owner);
		this.setTitle("Enter Players' Names");
		
		Container contentPane = this.getContentPane();
		
		JPanel playerNamesPanel = new JPanel(new GridBagLayout());
		contentPane.add(playerNamesPanel, BorderLayout.CENTER);
		
		GridBagConstraints gc = null;
		
		gc = new GridBagConstraints();
		gc.gridx      = 0;
		gc.gridy      = 0;
		gc.gridwidth  = 5;
		gc.gridheight = 1;
		gc.insets = new Insets(10, 10, 10, 10);
		
		playerNamesPanel.add(new JLabel("1st player's name:"), gc);
		gc.gridy      = 1;
		playerNamesPanel.add(new JLabel("2nd player's name:"), gc);
		
		gc = new GridBagConstraints();
		gc.gridx      = 5;
		gc.gridy      = 0;
		gc.gridwidth  = 7;
		gc.gridheight = 1;
		gc.insets = new Insets(10, 10, 10, 10);
		playerNamesPanel.add(player1Name = new JTextField(20), gc);
		gc.gridy      = 1;		
		playerNamesPanel.add(player2Name = new JTextField(20), gc);
		this.setResizable(false);
		this.setModal(true);
		
		JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.setMnemonic(java.awt.event.KeyEvent.VK_O);
		okButton.addActionListener(this);
		buttonPanel.add(Box.createVerticalStrut(okButton.getPreferredSize().height + 20));
		buttonPanel.add(okButton);
		okButton.setToolTipText("starts the game");
		buttonPanel.add(Box.createHorizontalStrut(10));
		
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.pack();
	}

	private JTextField player1Name = null;
	private JTextField player2Name = null;

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("OK")) {
		    this.setVisible(false);	
		    Controller.getInstance().enterPlayerNames(player1Name.getText(), player2Name.getText());
		}
	}

	
	
}
