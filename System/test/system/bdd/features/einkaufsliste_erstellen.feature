Feature: Einkaufsliste erstellen
  Als Konsument möchte ich Dinge, die ich einkaufen möchte, in einer Liste zusammenstellen, damit ich während des Einkaufs nichts vergesse.

  Scenario: Einkaufsliste kann ersten Eintrag aufnehmen
    Given eine leere Einkaufsliste
    When ich schreibe "Quark" in die Einkaufsliste 
    Then sollte die Einkaufsliste den Eintrag "Quark" enthalten. 

  