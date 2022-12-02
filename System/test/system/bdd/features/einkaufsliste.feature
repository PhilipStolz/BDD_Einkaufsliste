Feature: Einkaufsliste erstellen
  Als Konsument möchte ich Dinge, die ich einkaufen möchte, in einer Liste zusammenstellen, damit ich während des Einkaufs nichts vergesse.

  Scenario: Einkaufsliste kann einen Eintrag aufnehmen
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
  
	Scenario: Einkaufsliste enthält jeden Eintrag nur einmal
	  Given folgende Einkaufsliste:
	    | Mehl |
	    | Eier |
	  When ich schreibe "Eier" in die Einkaufsliste
	  Then die Einkaufsliste sollte 2 Einträge enthalten
	  
  Scenario: Anwender kann einen Eintrag aus Liste entfernen
    Given folgende Einkaufsliste:
    	| Gries |
    	| Suppe |
    	| Tomatensuppe |
    When ich den Eintrag "Suppe" aus der Einkaufsliste entferne
    Then die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:
    	| Gries |
    	| Tomatensuppe |
	  
  Scenario: Anwender kann keine Einträge aus Liste entfernen, die nicht in Liste enthalten sind.
    Given folgende Einkaufsliste:
    	| Gries |
    	| Tomatensuppe |
    When ich den Eintrag "Suppe" aus der Einkaufsliste entferne
    Then die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:
    	| Gries |
    	| Tomatensuppe |
    	
  Scenario: Anwender kann Einkaufsliste leeren
    Given folgende Einkaufsliste:
      | Truthahn |
      | Ente     |
    When ich die Einkaufsliste leere
    Then die Einkaufsliste sollte 0 Einträge enthalten
    
  Scenario: Anwender kann Einträge um Kommentare ergänzen
    Given folgende Einkaufsliste:
      | Truthahn |
      | Ente     |
    When ich den Eintrag "Truthahn" um den Kommentar "vom Biohof" ergänze
    Then die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:
      | Truthahn | vom Biohof |
      | Ente     |            |
      
  Scenario: Anwender fügt durch Kommentierung nicht vorhandener Einträge keine ungewollten Einträge hinzu
    Given eine leere Einkaufsliste
    When ich den Eintrag "Tomaten" um den Kommentar "vom Biohof" ergänze
    Then die Einkaufsliste sollte 0 Einträge enthalten
    
  Scenario: Eintrag erledigen
	  Given folgende Einkaufsliste: 
	    | Quark |
	    | Milch |
	    | Öl    |
	  When ich den Eintrag "Quark" erledige
	  Then die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:
	    | Milch  |
	    | Öl     |