Feature: Einkaufswagen füllen
  Als Konsument möchte ich Dinge die Einkaufsliste durchgehen, um beim Befüllen des Einkaufswagens nichts zu vergessen.

  Scenario: Eintrag erledigen
	  Given folgende Einkaufsliste: 
	    | Quark |
	    | Milch |
	  When ich den Eintrag "Quark" erledige
	  Then die Einkaufsliste sollte genau folgende Einträge in beliebiger Reihenfolge enthalten:
	    | Milch  |
