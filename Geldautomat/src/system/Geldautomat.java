package system;

import system.outsideinteraction.BanksystemGUI;
import system.outsideinteraction.SchnittstelleZumBanksystem;
import system.outsideinteraction.BankkundenGUI;
import system.outsideinteraction.SchnittstelleVomBanksystem;
import system.outsideinteraction.SchnittstelleVomBankkunden;
import system.outsideinteraction.SchnittstelleZumBankkunden;

public class Geldautomat implements SchnittstelleVomBanksystem, SchnittstelleVomBankkunden {

	private SchnittstelleZumBankkunden bankkunde = null;
	private SchnittstelleZumBanksystem banksystem = null;
	
	
	public Geldautomat() {
	}

	
	public Geldautomat(SchnittstelleZumBankkunden bankkunde, SchnittstelleZumBanksystem banksystemSchn) {
		this.bankkunde = bankkunde;
		this.banksystem = banksystemSchn;
	}
	
	public void meldeKontostand(Integer kontostand) {
	}

	public void waehleAusgabebetrag(Integer ausgabebetrag) {
		bankkunde.erhalte(ausgabebetrag);
		banksystem.meldeAuszahlungsbetrag(ausgabebetrag);
	}
		
	public void setKunde(SchnittstelleZumBankkunden bankkunde) {
		this.bankkunde = bankkunde;
	}

	public void setBanksystem(SchnittstelleZumBanksystem banksystem) {
		this.banksystem = banksystem;
	}

	public static void main(String[] args) {
		Geldautomat geldautomat = new Geldautomat();
	   
		geldautomat.setBanksystem(new BanksystemGUI(geldautomat));
		geldautomat.setKunde(new BankkundenGUI(geldautomat));
	}
}
