package system;

import java.util.Collection;
import java.util.HashSet;

import system.outsideinteraction.KonsumentGUI;
import system.outsideinteraction.SchnittstelleVomKonsument;
import system.outsideinteraction.SchnittstelleZumKonsument;

// Erste Änderung

public class EinkaufsApp implements SchnittstelleVomKonsument {

	private SchnittstelleZumKonsument konsument;
	
	private Collection<String> einkaufsliste = new HashSet<String>();
	
	public EinkaufsApp() {
		
	}
	
	public EinkaufsApp(SchnittstelleZumKonsument konsument) {
		this.konsument = konsument;
	}

	public static void main(String[] args) {
		EinkaufsApp einkaufsApp = new EinkaufsApp(); 
		einkaufsApp.setKonsument(new KonsumentGUI(einkaufsApp));
	}

	private void setKonsument(SchnittstelleZumKonsument konsument) {
		this.konsument = konsument;
	}

	@Override
	public void schreibeInEinkaufsliste(String posten) {
		einkaufsliste.add(posten);
		konsument.zeigeEinkaufsliste(einkaufsliste);
	}

	@Override
	public void entferneAusEinkaufsliste(String posten) {
		einkaufsliste.remove(posten);
		konsument.zeigeEinkaufsliste(einkaufsliste);
	}
	
	public void hallo() {
		
	}
}
