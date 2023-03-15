Feature: Filtering scenarios include choice different type of filter for

  @Gume
  Scenario Outline: Auto letnje gume [more parameters]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    And user adds tires in the shopping basket
    And user clicks dodaj button
    And user clicks back button
    And user clicks pretraga guma filter
    When user clicks primeni filter button
    And user adds tires in the shopping basket
    And user clicks dodaj button
    And user clicks back button
    And user clicks korpa button
    Then user should be verify number of items in the basket


    Examples:
      | TC_ID  |
      | SI_020 |

  @Gume
  Scenario Outline: Try to buy more than is offered

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu subsub title
    And user adds tires in the shopping basket
    And user clicks dodaj button
    And user clicks back button
    And user clicks dodaj button
    Then user should verify negative toast message II


    Examples:
      | TC_ID  |
      | SI_003 |

  @Gume
  Scenario Outline: Buy more items and than verified the basket

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    And user clicks main menu title
    And user clicks main menu subsub title
    And user adds more items in the shopping basket
    Then user should be verify number of items in the basket

    Examples:
      | TC_ID  |
      | SI_003 |

  @Gume
  Scenario Outline: Delete all produts from the basket
    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    And user clicks main menu title
    And user clicks main menu subsub title
    And user adds more items in the shopping basket
    Then user delete all items from the basket

    Examples:
      | TC_ID  |
      | SI_003 |