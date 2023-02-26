Feature: Letenje gume scenarios include choice different type of summer tires

  @Gume
  Scenario Outline: Letnje gume

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_001 |

  @Gume
  Scenario Outline: Letnje Auto gume

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_002 |

  @Gume
  Scenario Outline: Letnje gume za kombi

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_003 |

  @Gume
  Scenario Outline: Letnje gume za SUV

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_004 |

  @Gume
  Scenario Outline: Letnje gume za skuter

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_005 |

  @Gume
  Scenario Outline: Letnje gume za motor

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_006 |

  @Gume
  Scenario Outline: Letnje gume za traktor

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    Then user should be verify chosen elements

    Examples:
      | TC_ID  |
      | SI_007 |
