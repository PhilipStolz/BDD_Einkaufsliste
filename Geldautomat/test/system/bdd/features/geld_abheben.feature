Feature: Geld abheben
Kunden können sich am Geldautomaten Bargeld ausgeben lassen.

Scenario: Genug Geld auf Konto verfügbar
   Given das Banksystem meldet Kontostand = 100€
   When der Kunde wählt Ausgabebetrag = 100€
   Then der Geldautomat sollte 100€ an den Kunden ausgeben
   And der Geldautomat sollte dem Banksystem melden: 100€ ausgegeben