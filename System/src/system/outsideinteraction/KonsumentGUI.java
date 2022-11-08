package system.outsideinteraction;

import java.util.Map;

public class KonsumentGUI extends GUInterface implements SchnittstelleZumKonsument {

	private static final long serialVersionUID = 1L;
	
	public KonsumentGUI(SchnittstelleVomKonsument einkaufsApp) {
		super("Konsument");
		addActorActions(SchnittstelleVomKonsument.class, einkaufsApp);
	}
	
	@Override
	public void zeigeEinkaufsliste(Map<String, String> einkaufsliste) {
		displayIncomingSystemAction("Einkaufliste: " + einkaufsliste.toString());
	}		
}
