package system.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.EinkaufsApp;
import system.outsideinteraction.SchnittstelleVomKonsument;
import system.outsideinteraction.SchnittstelleZumKonsument;

public class EinkaufslisteSteps implements SchnittstelleZumKonsument {

	private SchnittstelleVomKonsument app;	
	private Map<String, String> einkaufsliste;
	
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
	public void sollte_die_einkaufsliste_den_eintrag_enthalten(String eintrag) {
		assertNotNull(einkaufsliste);
		assertTrue(einkaufsliste.containsKey(eintrag));
	}


	@Override
	public void zeigeEinkaufsliste(Map<String, String> einkaufsliste) {
		this.einkaufsliste = einkaufsliste;
	}
	
	@Given("folgende Einkaufsliste:")
	public void folgende_einkaufsliste(io.cucumber.datatable.DataTable dataTable) {
		int listLength = dataTable.height();
		for(int idx = 0; idx < listLength; idx++) {
		    String eintrag = dataTable.cell(idx, 0);
		    app.schreibeInEinkaufsliste(eintrag);
		}
	}
	
	@Then("die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:")
	public void sollte_die_einkaufsliste_folgende_einträge_in_beliebiger_reihenfolge_enthalten(io.cucumber.datatable.DataTable dataTable) {
		int listLength = dataTable.height();
		int listWidth  = dataTable.width();
		for(int idx = 0; idx < listLength; idx++) {
		    String eintrag = dataTable.cell(idx, 0);
		    assertTrue(einkaufsliste.containsKey(eintrag));
		    
		    if(listWidth > 1) {
		    	String kommentar = dataTable.cell(idx, 1);
		    	assertEquals(kommentar, einkaufsliste.get(eintrag));
		    }
		}
		
		assertEquals(listLength, einkaufsliste.size());
	}

	@When("ich den Eintrag {string} erledige")
	public void ich_den_eintrag_erledige(String eintrag) {
		app.erledigeEintrag(eintrag);
	}
	
	@Then("die Einkaufsliste sollte {int} Einträge enthalten")
	public void sollte_die_einkaufsliste_eintraege_enthalten(Integer anzahlEintraege) {
		assertEquals((long) anzahlEintraege, (long) (einkaufsliste.size()));
	}
	
	@When("ich den Eintrag {string} aus der Einkaufsliste entferne")
	public void ich_den_eintrag_aus_der_einkaufsliste_entferne(String eintrag) {
	    app.entferneAusEinkaufsliste(eintrag);
	}

	@When("ich die Einkaufsliste leere")
	public void ich_die_einkaufsliste_leere() {
		app.leereEinkaufsliste();
	}

	@When("ich den Eintrag {string} um den Kommentar {string} ergänze")
	public void ich_den_eintrag_um_den_kommentar_ergänze(String eintrag, String kommentar) {
	    app.ergaenzeUmKommentar(eintrag, kommentar);
	}

}





