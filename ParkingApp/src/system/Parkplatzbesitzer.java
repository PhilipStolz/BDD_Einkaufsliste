package system;

import java.util.ArrayList;
import java.util.List;

public class Parkplatzbesitzer {
	private String name;
	private List<Parkplatz> parkplaetze;

	public Parkplatzbesitzer(String name) {
		this.name = name;
		this.parkplaetze = new ArrayList<Parkplatz>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Parkplatz> getParkplaetze() {
		return parkplaetze;
	}

	public void setParkplaetze(List<Parkplatz> parkplaetze) {
		this.parkplaetze = parkplaetze;
	}
	
	

}
