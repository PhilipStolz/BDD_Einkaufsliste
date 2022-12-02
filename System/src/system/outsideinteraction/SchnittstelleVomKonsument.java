package system.outsideinteraction;

public interface SchnittstelleVomKonsument {

	void schreibeInEinkaufsliste(String eintrag);

	void entferneAusEinkaufsliste(String eintrag);

	void leereEinkaufsliste();

	void ergaenzeUmKommentar(String eintrag, String kommentar);

	void erledigeEintrag(String eintrag);

}
