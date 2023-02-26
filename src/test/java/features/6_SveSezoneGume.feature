Feature: Za sve sezone gume scenarios include choice different type of all season tires

  @Gume
  Scenario Outline: Gume za sve sezone

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_012 |

  @Gume
  Scenario Outline: Auto gume za sve sezone

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_013 |

  @Gume
  Scenario Outline: Kombi gume za sve sezonme

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_014 |

  @Gume
  Scenario Outline: Gume za SUV

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_015 |