package system.bdd.steps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.Geldautomat;
import system.outsideinteraction.SchnittstelleZumBanksystem;
import system.outsideinteraction.SchnittstelleVomBankkunden;
import system.outsideinteraction.SchnittstelleVomBanksystem;
import system.outsideinteraction.SchnittstelleZumBankkunden;

public class GeldAbhebenSteps implements SchnittstelleZumBanksystem, SchnittstelleZumBankkunden {

	private Geldautomat geldautomat = new Geldautomat(this, this);
	private SchnittstelleVomBanksystem vomBanksystem = geldautomat;
	private SchnittstelleVomBankkunden vomBankkunden = geldautomat; 
	
	@Given("das Banksystem meldet Kontostand = {int}€")
	public void das_banksystem_meldet_kontostand(Integer kontostand) {
		vomBanksystem.meldeKontostand(kontostand);
	}
	
	@When("der Kunde wählt Ausgabebetrag = {int}€")
	public void der_kunde_waehlt_ausgabebetrag(Integer ausgabebetrag) {
	    vomBankkunden.waehleAusgabebetrag(ausgabebetrag);
	}
	
	@Then("der Geldautomat sollte {int}€ an den Kunden ausgeben")
	public void der_geldautomat_sollte_an_den_kunden_ausgeben(int sollAuszahlungsbetrag) {
	    assertEquals(sollAuszahlungsbetrag, auszahlungsbetrag);
	}
	
	@Then("der Geldautomat sollte dem Banksystem melden: {int}€ ausgegeben")
	public void der_geldautomat_sollte_dem_banksystem_melden(int sollGemeldeterAusgabebetrag) {
		assertEquals(sollGemeldeterAusgabebetrag, meldungAuszahlungsbetrag);
	}

	@Override
	public void erhalte(int auszahlungsbetrag) {
		this.auszahlungsbetrag = auszahlungsbetrag;
	}

	@Override
	public void meldeAuszahlungsbetrag(int auszahlungsbetrag) {
		this.meldungAuszahlungsbetrag = auszahlungsbetrag;
	}	
	
	int auszahlungsbetrag = 0;
    int meldungAuszahlungsbetrag = 0;


}
