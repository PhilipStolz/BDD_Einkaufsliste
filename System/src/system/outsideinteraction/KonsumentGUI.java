package system.outsideinteraction;

import java.util.Collection;

public class KonsumentGUI extends GUInterface implements SchnittstelleZumKonsument {

	private static final long serialVersionUID = 1L;
	
	private static final String SCHREIBE_IN_EINKAUFSLISTE = "Schreibe in Einkaufsliste";
	private static final String ENTFERNE_AUS_EINKAUFSLISTE = "Entferne aus Einkaufsliste";	
	private static final String EINTRAG = "Eintrag";	
	
	public KonsumentGUI(SchnittstelleVomKonsument einkaufsApp) {
		super("Konsument");
		addActorAction(SCHREIBE_IN_EINKAUFSLISTE, einkaufsApp, "schreibeInEinkaufsliste", EINTRAG);
		addActorAction(ENTFERNE_AUS_EINKAUFSLISTE, einkaufsApp, "entferneAusEinkaufsliste", EINTRAG);		
	}
	
	@Override
	public void zeigeEinkaufsliste(Collection<String> einkaufsliste) {
		displayIncomingSystemAction("Einkaufliste: " + einkaufsliste.toString());	
	}	
	
}
