Feature: PolicemanGame

  Scenario: game
    Given I have my policeman game
    When I load my set of question from this "set1.in" file
    Then number of questions must be more then 0
    And questions have 4 answers
    And every question has right answer

  Scenario Outline: checking assignment
    Given I have my policeman game
    When I load my set of question from this "set1.in" file
    Then number of questions must be more then 0
    And you see question number "<question>"
    And you choose answer number "<answer>"
    Then result will be this "<result>"

    Examples:
      |question |answer |result |
      |0        |2      |true   |
      |1        |3      |true   |
      |2        |1      |false  |
      |3        |2      |false  |

  Scenario: setting limits
    Given I have my policeman game
    When I load my set of question from this "set1.in" file
    Then number of questions must be more then 0
    And Question length must be less then 400
    And Answer length must be less then 100