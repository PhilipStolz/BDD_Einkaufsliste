package system.bdd.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.Parkplatz;
import system.Parkplatzbesitzer;

public class parkplatz_verwalten_steps {

	Parkplatzbesitzer besitzer;
	Parkplatz parkplatz;
	@Given("Parkplatzbesitzer {string} besitzt einen Parkplatz")
	public void parkplatzbesitzer_besitzt_einen_parkplatz(String name) {
		besitzer = new Parkplatzbesitzer(name);
		parkplatz = new Parkplatz();
	}


	@When("Parkplatzbestizer legt den Parkplatz mit der Id {int} in der {string} für {int} €\\/h")
	public void parkplatzbestizer_legt_den_parkplatz_mit_der_id_in_der_für_€_h(Integer id, String adresse, Integer preis) {
		parkplatz.setAdresse(adresse);
		parkplatz.setId(id);
		parkplatz.setPreis(preis);
		List<Parkplatz> liste = besitzer.getParkplaetze();
		liste.add(parkplatz);
		besitzer.setParkplaetze(liste);
	}
	@Then("Parkplatz mit der Id {int} in der Übersicht vorhanden")
	public void parkplatz_mit_der_id_in_der_übersicht_vorhanden(Integer int1) {
	    assertTrue(besitzer.getParkplaetze().contains(parkplatz));
	}


}
