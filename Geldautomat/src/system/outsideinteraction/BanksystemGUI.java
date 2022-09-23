package system.outsideinteraction;

public class BanksystemGUI extends GUInterface implements SchnittstelleZumBanksystem {

	private static final long serialVersionUID = 8698362944391479596L;
	private static final String MELDE_KONTOSTAND = "Melde Kontostand";		
	
	private SchnittstelleVomBanksystem geldautomat;
	
	public BanksystemGUI(SchnittstelleVomBanksystem geldautomat) {
		super("Banksystem");
		this.geldautomat = geldautomat;
		addActorAction(MELDE_KONTOSTAND);
	}

	@Override
	public void meldeAuszahlungsbetrag(int auszahlungsbetrag) {
		StringBuilder sb = new StringBuilder();
		sb.append("Meldung Auszahlungsbetrag = ");
		sb.append(auszahlungsbetrag);
		displayIncomingSystemAction(sb.toString());
	}

	@Override
	void actorActionTriggered(String actorAction) {
		if(actorAction.equals(MELDE_KONTOSTAND)) {
			Integer kontostand = readInteger(MELDE_KONTOSTAND);
			if(kontostand != null)
				geldautomat.meldeKontostand(kontostand);
		}
	}
	
}
