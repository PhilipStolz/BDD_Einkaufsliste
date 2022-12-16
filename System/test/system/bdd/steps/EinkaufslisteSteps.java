package system.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.EinkaufsApp;
import system.outsideinteraction.SchnittstelleVomKonsument;
import system.outsideinteraction.SchnittstelleZumKonsument;

public class EinkaufslisteSteps implements SchnittstelleZumKonsument {

	private SchnittstelleVomKonsument app;	
	private Collection<String> einkaufsliste = null;
	
	public EinkaufslisteSteps() {
		app = new EinkaufsApp(this);
	}
	
	@Given("eine leere Einkaufsliste")
	public void eine_leere_einkaufsliste() {
		// intentionally left empty, nothing has to be done to get a leere Einkaufsliste
	}
	
	@When("ich schreibe {string} in die Einkaufsliste")
	public void ich_schreibe_in_die_einkaufsliste(String eintrag) {
		app.schreibeInEinkaufsliste(eintrag);
	}
	
	@Then("die Einkaufsliste sollte den Eintrag {string} enthalten.")
	public void die_einkaufsliste_sollte_den_eintrag_enthalten(String eintrag) {
		assertNotNull(einkaufsliste);
		assertTrue(einkaufsliste.contains(eintrag));
	}

	@Given("folgende Einkaufsliste:")
	public void folgende_einkaufsliste(io.cucumber.datatable.DataTable vorgegebeneEinkaufsliste) {
		int listLength = vorgegebeneEinkaufsliste.height();
		for(int idx = 0; idx < listLength; idx++) {
		    String eintrag = vorgegebeneEinkaufsliste.cell(idx, 0);
		    app.schreibeInEinkaufsliste(eintrag);
		}
	}
	
	@Then("die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:")
	public void die_einkaufsliste_sollte_genau_folgende_einträge_in_beliebiger_reihenfolge_enthalten(io.cucumber.datatable.DataTable vorgegebeneEinkaufsliste) {
		int listLength = vorgegebeneEinkaufsliste.height();

		for(int idx = 0; idx < listLength; idx++) {
		    String eintrag = vorgegebeneEinkaufsliste.cell(idx, 0);
		    assertTrue(einkaufsliste.contains(eintrag));
		}
		
		assertEquals(listLength, einkaufsliste.size());
	}


	
	@Override
	public void zeigeEinkaufsliste(Collection<String> einkaufsliste) {
		this.einkaufsliste = einkaufsliste;
	}
	
}





