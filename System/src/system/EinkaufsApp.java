package system;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import system.outsideinteraction.KonsumentGUI;
import system.outsideinteraction.SchnittstelleVomKonsument;
import system.outsideinteraction.SchnittstelleZumKonsument;

// Erste Änderung

public class EinkaufsApp implements SchnittstelleVomKonsument {

	private SchnittstelleZumKonsument konsument;
	
	private HashMap<String,String> einkaufsliste = new HashMap<>();
	
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
	public void schreibeInEinkaufsliste(String eintrag) {
		einkaufsliste.put(eintrag, null);
		konsument.zeigeEinkaufsliste(einkaufsliste);
	}

	@Override
	public void entferneAusEinkaufsliste(String eintrag) {
		einkaufsliste.remove(eintrag);
		konsument.zeigeEinkaufsliste(einkaufsliste);
	}

	@Override
	public void leereEinkaufsliste() {
		einkaufsliste.clear();
		konsument.zeigeEinkaufsliste(einkaufsliste);
	}

	@Override
	public void ergaenzeUmKommentar(String eintrag, String kommentar) {
		if(einkaufsliste.containsKey(eintrag)) {
			einkaufsliste.put(eintrag, kommentar);
		}
		konsument.zeigeEinkaufsliste(einkaufsliste);		
	}

	@Override
	public void erledigeEintrag(String eintrag) {
		entferneAusEinkaufsliste(eintrag);
	}
}
