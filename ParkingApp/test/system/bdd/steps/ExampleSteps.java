package system.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleSteps {

	@Given("{string} has been authenticated")
	public void has_been_authenticated(String client) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("the balance is {int}€")
	public void the_balance_is(Integer amount) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the 100€ button has been pressed")
	public void the_button_has_been_pressed(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the system should dispense {int}€")
	public void the_system_dispenses(Integer amount) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the balance should be {int}€")
	public void the_balance_should_be(Integer amount) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}	
}
