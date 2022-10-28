package system;

import system.outsideinteraction.BankkundenGUI;
import system.outsideinteraction.BanksystemGUI;

// Erste Änderung

public class EinkaufsApp {

	public static void main(String[] args) {
		EinkaufsApp einkaufsApp = new EinkaufsApp();
		   
		einkaufsApp.setKonsument(new KonsumentGUI(einkaufsApp));
	}

}
