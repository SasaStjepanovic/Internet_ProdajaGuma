Feature: Zimske gume scenarios include choice different type of winter tires

  @Gume
  Scenario Outline: Zimske gume

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_008 |

  @Gume
  Scenario Outline: Zimske Auto gume

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_009 |

  @Gume
  Scenario Outline: Zimske gume za kombi

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_010 |

  @Gume
  Scenario Outline: Zimske gume za SUV

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_011 |