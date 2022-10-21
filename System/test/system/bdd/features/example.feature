Feature: example feature
  The customer shall be able to withdraw cash from his/her bank account.

  Scenario: withdraw pre-configured amount
    Given "Hermann Reich" has been authenticated
    And the balance is 800€
    When the 100€ button has been pressed
    Then the system should dispense 100€ 
    And the balance should be 700€
