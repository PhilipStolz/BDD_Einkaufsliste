package system.outsideinteraction;

public class BankkundenGUI extends GUInterface implements SchnittstelleZumBankkunden {

	private static final long serialVersionUID = 1L;
	
	private static final String WAEHLE_AUSGABEBETRAG = "Wähle Ausgabebetrag";	
	
	private SchnittstelleVomBankkunden geldautomat;

	public BankkundenGUI(SchnittstelleVomBankkunden geldautomat) {
		super("Bankkunde");
		this.geldautomat = geldautomat;		
		addActorAction(WAEHLE_AUSGABEBETRAG);
	}

	@Override
	public void erhalte(int auszahlungsbetrag) {
		StringBuilder sb = new StringBuilder();
		sb.append("Auszahlung -> ");
		sb.append(auszahlungsbetrag);
		displayIncomingSystemAction(sb.toString());
	}

	@Override
	void actorActionTriggered(String actorAction) {
		if(actorAction.equals(WAEHLE_AUSGABEBETRAG)) {
			Integer ausgabebetrag = readInteger(WAEHLE_AUSGABEBETRAG);
			if(ausgabebetrag != null)
				geldautomat.waehleAusgabebetrag(ausgabebetrag);
		}
	}
	

}
