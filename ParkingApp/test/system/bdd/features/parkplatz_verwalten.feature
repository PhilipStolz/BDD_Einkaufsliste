
@tag
Feature: Parkplatz verwalten
  Ich möchte Parkplätze anlegen, bearbeiten und löschen können

  @tag1
  Scenario: Parkplatz anlegen
    Given Parkplatzbesitzer "Hans Huber" besitzt einen Parkplatz
    When Parkplatzbestizer legt den Parkplatz mit der Id 1 in der "Hansstraße 1, 83026 Rosenheim" für 2 €/h
    Then Parkplatz mit der Id 1 in der Übersicht vorhanden


