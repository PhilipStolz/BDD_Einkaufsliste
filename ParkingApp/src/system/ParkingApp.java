package system;

import system.outsideinteraction.FahrerGUI;
import system.outsideinteraction.SchnittstelleVomFahrer;
import system.outsideinteraction.SchnittstelleZumFahrer;

public class ParkingApp implements SchnittstelleVomFahrer {

	private SchnittstelleZumFahrer fahrer;

	public ParkingApp() {
	}

	
	public ParkingApp(SchnittstelleZumFahrer fahrer) {
		this.fahrer = fahrer;
	}	

	
	public void setFahrer(SchnittstelleZumFahrer fahrer) {
		this.fahrer = fahrer;
	}


	public static void main(String[] args) {
		ParkingApp parkingApp = new ParkingApp();
		   
		parkingApp.setFahrer(new FahrerGUI(parkingApp));
	}

}
