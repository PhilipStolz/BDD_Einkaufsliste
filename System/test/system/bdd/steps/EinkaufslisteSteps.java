package system.bdd.steps;

import system.EinkaufsApp;
import system.outsideinteraction.SchnittstelleVomKonsument;
import system.outsideinteraction.SchnittstelleZumKonsument;

public class EinkaufslisteSteps implements SchnittstelleZumKonsument {

	@SuppressWarnings("unused")
	private SchnittstelleVomKonsument app;	
	
	public EinkaufslisteSteps() {
		app = new EinkaufsApp(this);
	}
}





