/**
 * File: IfcUserInterface.java
 * Creation Date: 07.01.2015
 *
 * Copyright © 2015 by HOOD GmbH – all rights reserved 
 */
package com.hoodgroup.tictactoe.controller;

/**
 * This Interface defines the routines a user interface must implement in order
 * to interoperate with the <code>Controller</code>. 
 * 
 * @author p_stolz
 *
 */
public interface IfcUserInterface {

	/**
	 * Displays a message that has to be confirmed.
	 * 
	 * @param message
	 */
	void display(String message);
	
}
