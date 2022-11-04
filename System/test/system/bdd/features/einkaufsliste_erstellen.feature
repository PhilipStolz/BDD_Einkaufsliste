Feature: Einkaufsliste erstellen
  Als Konsument möchte ich Dinge, die ich einkaufen möchte, in einer Liste zusammenstellen, damit ich während des Einkaufs nichts vergesse.

  Scenario: Einkaufsliste kann ersten Eintrag aufnehmen
    Given eine leere Einkaufsliste
    When ich schreibe "Quark" in die Einkaufsliste 
    Then sollte die Einkaufsliste den Eintrag "Quark" enthalten. 

	Scenario: Einkaufsliste kann mehrere Einträge enthalten
	  Given folgende Einkaufsliste: 
	    | "Quark" |
	    | "Milch" |
	  When ich schreibe "Butter" in die Einkaufsliste
	  Then sollte die Einkaufsliste folgende Einträge in beliebiger Reihenfolge enthalten:
	    | "Milch"  |
	    | "Butter" |
	    | "Quark"  |
  