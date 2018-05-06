Feature: PolicemanGame

  Scenario: game
    Given I have my policeman game
    When I load my set of question from this "set1.in" file
    Then number of questions must be more then 0
    And questions have 4 answers
    And every question has right answer