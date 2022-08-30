package com.hoodgroup.tictactoe.bdd.steps;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import com.hoodgroup.tictactoe.controller.Controller;
import com.hoodgroup.tictactoe.controller.IfcUserInterface;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GamePlayingSteps implements IfcUserInterface {


	public GamePlayingSteps() {
		controller.setUi(this);
	}
	
	private Controller controller = Controller.getInstance();
	private String messageDisplayed = null;
	
	
	@When("a turn on {int},{int} is made")
	public void whenTurnIsMade(int column, int row){
		 controller.enterTurn(column, row);
	}

	@Given("a game with first player {string} and second player {string}")
	public void givenAGameWithPlayers(String player1, String player2){
		 controller.enterPlayerNames(player1, player2);
	}
	
	@Then("{string} shall win the game.")
	public void thenPlayerShallWinTheGame(String player){
		assertNotNull("No message was displayed!", this.messageDisplayed);
		assertTrue("Error in winner message!", this.messageDisplayed.startsWith(player));
	}

	@Override
	public void display(String message) {
	    this.messageDisplayed = message;
	}
	
	
	

	
	

	@Given("a board like this:")
	public void a_board_like_this(io.cucumber.datatable.DataTable dataTable) {
		int height = dataTable.height();
		int width = dataTable.width();
		
		LinkedList<Integer[]> xMoves = new LinkedList<>(); 
		LinkedList<Integer[]> oMoves = new LinkedList<>();
		
		for(int colIdx = 0; colIdx < width; colIdx ++) {
			for(int rowIdx = 0; rowIdx < height; rowIdx ++) {
		        if((colIdx > 0) && (rowIdx > 0)) {
		        	String coin = dataTable.cell(rowIdx, colIdx);
	        		Integer[] move = new Integer[2];
                    move[0] = colIdx - 1;
                    move[1] = rowIdx - 1;
                    if(coin != null)
                    	if(coin.equals("x"))
                    		xMoves.add(move);
                    	else if(coin.equals("o")) 
                    		oMoves.add(move);
		        }
			}
		}

		int turnCount = 0;
		while((oMoves.size() > 0) || (xMoves.size() > 0)) {

			List<Integer[]> moves;
			if((turnCount % 2) == 0) {
				moves = xMoves;
			}
			else {
				moves = oMoves;
			}

			if(moves.size() == 0) {
				fail("Wrong number of coins on board in given example.");
			}

			Integer[] move = moves.get(0);
			moves.remove(0);

			controller.enterTurn(move[0], move[1]);

			turnCount ++;
		}

	}
		
	
}