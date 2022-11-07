Feature: Einkaufsliste erstellen
  Als Konsument möchte ich Dinge, die ich einkaufen möchte, in einer Liste zusammenstellen, damit ich während des Einkaufs nichts vergesse.

  Scenario: Einkaufsliste kann ersten Eintrag aufnehmen
    Given eine leere Einkaufsliste
    When ich schreibe "Quark" in die Einkaufsliste 
    Then die Einkaufsliste sollte den Eintrag "Quark" enthalten. 

	Scenario: Einkaufsliste kann mehrere Einträge enthalten
	  Given folgende Einkaufsliste: 
	    | Quark |
	    | Milch |
	  When ich schreibe "Butter" in die Einkaufsliste
	  Then die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:
	    | Milch  |
	    | Butter |
	    | Quark  |
  
	Scenario: Einkaufsliste kann mehrere Einträge enthalten
	  Given folgende Einkaufsliste:
	    | Mehl |
	    | Eier |
	  When ich schreibe "Eier" in die Einkaufsliste
	  Then die Einkaufsliste sollte 2 Posten enthalten
	  
  Scenario: Anwender kann einen Posten aus Liste entfernen
    Given folgende Einkaufsliste:
    	| Gries |
    	| Suppe |
    	| Tomatensuppe |
    When ich den Eintrag "Suppe" aus der Einkaufsliste entferne
    Then die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:
    	| Gries |
    	| Tomatensuppe |
	  
  Scenario: Anwender kann keine Posten aus Liste entfernen, die nicht in Liste enthalten sind.
    Given folgende Einkaufsliste:
    	| Gries |
    	| Tomatensuppe |
    When ich den Eintrag "Suppe" aus der Einkaufsliste entferne
    Then die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:
    	| Gries |
    	| Tomatensuppe |
    