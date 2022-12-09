package system.outsideinteraction;

public class BesitzerGUI extends GUInterface {

	private static final long serialVersionUID = 1L;
	
	
	@SuppressWarnings("unused")
	private SchnittstelleZumFahrer parkingApp;
	
	public BesitzerGUI(SchnittstelleZumFahrer parkingApp) {
		super("Besitzer");
		this.parkingApp = parkingApp;
	}
	
	@Override
	void actorActionTriggered(String actorAction) {
		// TODO Auto-generated method stub

	}

}
