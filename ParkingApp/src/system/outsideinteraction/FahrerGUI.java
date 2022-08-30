package system.outsideinteraction;

public class FahrerGUI extends GUInterface implements SchnittstelleZumFahrer {

	private static final long serialVersionUID = 1L;
	
	
	private SchnittstelleVomFahrer parkingApp;
	
	public FahrerGUI(SchnittstelleVomFahrer parkingApp) {
		super("Fahrer");
		this.parkingApp = parkingApp;
	}
	
	@Override
	void actorActionTriggered(String actorAction) {
		// TODO Auto-generated method stub

	}

}
