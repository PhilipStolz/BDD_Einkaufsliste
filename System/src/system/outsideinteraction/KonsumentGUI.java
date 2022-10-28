package system.outsideinteraction;

import system.EinkaufsApp;

public class KonsumentGUI extends GUInterface {

	private EinkaufsApp einkaufsApp;
	
	public KonsumentGUI(SchnittstelleVomKonsument einkaufsApp) {
		super("Konsument");
		this.einkaufsApp = this.einkaufsApp;		
	}	
	
}
