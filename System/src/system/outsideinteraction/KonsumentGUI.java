package system.outsideinteraction;

import java.util.Collection;

import system.EinkaufsApp;

public class KonsumentGUI extends GUInterface implements SchnittstelleZumKonsument {

	private SchnittstelleVomKonsument einkaufsApp;
	
	private static final String SCHREIBE_IN_EINKAUFSLISTE = "Schreibe in Einkaufsliste";
	private static final String EINTRAG = "Eintrag";	
	
	public KonsumentGUI(SchnittstelleVomKonsument einkaufsApp) {
		super("Konsument");
		this.einkaufsApp = einkaufsApp;
		addActorAction(SCHREIBE_IN_EINKAUFSLISTE);
	}

	@Override
	void actorActionTriggered(String actorAction) {
		if(actorAction.equals(SCHREIBE_IN_EINKAUFSLISTE)) {
			String eintrag = readString(EINTRAG);
			if(eintrag != null)
				einkaufsApp.schreibeInEinkaufsliste(eintrag);;
		}
	}

	@Override
	public void zeigeEinkaufsliste(Collection<String> einkaufsliste) {
		displayIncomingSystemAction("Einkaufliste: " + einkaufsliste.toString());
		
	}	
	
}
