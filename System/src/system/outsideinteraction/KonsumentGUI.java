package system.outsideinteraction;

import java.util.Collection;

public class KonsumentGUI extends GUInterface implements SchnittstelleZumKonsument {

	private static final long serialVersionUID = 1L;

	private SchnittstelleVomKonsument einkaufsApp;
	
	private static final String SCHREIBE_IN_EINKAUFSLISTE = "Schreibe in Einkaufsliste";
	private static final String ENTFERNE_AUS_EINKAUFSLISTE = "Entferne aus Einkaufsliste";	
	private static final String EINTRAG = "Eintrag";	
	
	public KonsumentGUI(SchnittstelleVomKonsument einkaufsApp) {
		super("Konsument");
		this.einkaufsApp = einkaufsApp;
		addActorAction(SCHREIBE_IN_EINKAUFSLISTE);
		addActorAction(ENTFERNE_AUS_EINKAUFSLISTE);		
	}

	@Override
	void actorActionTriggered(String actorAction) {
		if(actorAction.equals(SCHREIBE_IN_EINKAUFSLISTE)) {
			String eintrag = readString(EINTRAG);
			if(eintrag != null)
				einkaufsApp.schreibeInEinkaufsliste(eintrag);
		}
		else if(actorAction.equals(ENTFERNE_AUS_EINKAUFSLISTE)) {
			String eintrag = readString(EINTRAG);
			if(eintrag != null)
				einkaufsApp.entferneAusEinkaufsliste(eintrag);
		}
	}

	@Override
	public void zeigeEinkaufsliste(Collection<String> einkaufsliste) {
		displayIncomingSystemAction("Einkaufliste: " + einkaufsliste.toString());
		
	}	
	
}
