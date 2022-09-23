package system.outsideinteraction;

public class FahrerGUI extends GUInterface implements SchnittstelleZumFahrer {

	private static final long serialVersionUID = 1L;
	
	
	private SchnittstelleVomFahrer parkingApp;
	
	public FahrerGUI(SchnittstelleVomFahrer parkingApp) {
		super("Fahrer");
		this.parkingApp = parkingApp;
		this.addActorAction("Tue dies");
	}
	
	@Override
	void actorActionTriggered(String actorAction) {
		// TODO Auto-generated method stub
		String name = this.readString("Gib Deinen Namen ein:");
		parkingApp.tueDies(name);
		
	}

	@Override
	public void bestaetigeTueDies() {
		this.displayIncomingSystemAction("Tue dies bestätigt!");
		
	}

}
