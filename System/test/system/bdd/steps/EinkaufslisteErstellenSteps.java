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

public class EinkaufslisteErstellenSteps implements SchnittstelleZumKonsument {

	private SchnittstelleVomKonsument app;	
	private Collection<String> einkaufsliste;
	
	public EinkaufslisteErstellenSteps() {
		app = new EinkaufsApp(this);
	}

	
	@Given("eine leere Einkaufsliste")
	public void eine_leere_einkaufsliste() {
		// intentionally left empty, nothing has to be done to get a leere Einkaufsliste
	}
	
	@When("ich schreibe {string} in die Einkaufsliste")
	public void ich_schreibe_in_die_einkaufsliste(String string) {
		app.schreibeInEinkaufsliste(string);
	}
	
	@Then("die Einkaufsliste sollte den Eintrag {string} enthalten.")
	public void sollte_die_einkaufsliste_den_eintrag_enthalten(String string) {
		assertNotNull(einkaufsliste);
		assertTrue(einkaufsliste.contains(string));
	}


	@Override
	public void zeigeEinkaufsliste(Collection<String> einkaufsliste) {
		this.einkaufsliste = einkaufsliste;
	}
	
	@Given("folgende Einkaufsliste:")
	public void folgende_einkaufsliste(io.cucumber.datatable.DataTable dataTable) {
		int listLength = dataTable.height();
		for(int idx = 0; idx < listLength; idx++) {
		    String posten = dataTable.cell(idx, 0);
		    app.schreibeInEinkaufsliste(posten);
		}
	}
	
	@Then("die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:")
	public void sollte_die_einkaufsliste_folgende_einträge_in_beliebiger_reihenfolge_enthalten(io.cucumber.datatable.DataTable dataTable) {
		int listLength = dataTable.height();
		for(int idx = 0; idx < listLength; idx++) {
		    String posten = dataTable.cell(idx, 0);
		    assertTrue(einkaufsliste.contains(posten));
		}
		
		assertEquals(listLength, einkaufsliste.size());
	}

	@Then("die Einkaufsliste sollte {int} Posten enthalten")
	public void sollte_die_einkaufsliste_posten_enthalten(Integer anzahlPosten) {
		assertEquals((long) anzahlPosten, (long) (einkaufsliste.size()));
	}
	
	@When("ich den Eintrag {string} aus der Einkaufsliste entferne")
	public void ich_den_eintrag_aus_der_einkaufsliste_entferne(String posten) {
	    app.entferneAusEinkaufsliste(posten);
	}

	
}





