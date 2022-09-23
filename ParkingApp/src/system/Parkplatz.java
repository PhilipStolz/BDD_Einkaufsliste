package system;

public class Parkplatz {
	private String adresse;
	private int id;
	private int preis;

	public Parkplatz() {};
	
	public Parkplatz(int id, String adresse, int preis) {
		this.id = id;
		this.adresse = adresse;
		this.preis = preis;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	
	

}
