Feature:Profile scenarios include entering own data for Fizicka & Pravna lica, separate entering address and verification entered data

  @Gume
  Scenario Outline: Enter own data (fizicka lica)

    Given a user reads test data from "prodajaguma" "profile" by id "<TC_ID>"
    And users clicks on prijava button
    When user enters email and password for login
    And users clicks on profile button
    When user enters profile own data
    And user clicks azuriraj button
    When user reverts on the base url page
    And users clicks on profile button
    Then user should verify changed customer data in the profile section


    Examples:
      | TC_ID  |
      | SI_001 |

  @Gume
  Scenario Outline: Enter own data (fizicka & pravna lica)

    Given a user reads test data from "prodajaguma" "profile" by id "<TC_ID>"
    And users clicks on prijava button
    When user enters email and password for login
    And users clicks on profile button
    When user enters profile own data
    And user clicks azuriraj button
    When user reverts on the base url page
    And users clicks on profile button
    Then user should verify changed customer data in the profile section

    Examples:
      | TC_ID  |
      | SI_002 |

  @Gume
  Scenario Outline: Enter own empty data (fizicka & pravna lica) and verify that is not saved empty

    Given a user reads test data from "prodajaguma" "profile" by id "<TC_ID>"
    And users clicks on prijava button
    When user enters email and password for login
    And users clicks on profile button
    When user enters profile own data
    And user clicks azuriraj button
    When user reverts on the base url page
    And users clicks on profile button
    When user enters profile own empty data
    And user clicks azuriraj button
    When user reverts on the base url page
    And users clicks on profile button
    Then user should verify changed customer data in the profile section

    Examples:
      | TC_ID  |
      | SI_002 |

  @Gume
  Scenario Outline: Enter delivery address

    Given a user reads test data from "prodajaguma" "profile" by id "<TC_ID>"
    And users clicks on prijava button
    When user enters email and password for login
    And users clicks on profile button
    When user enters delivery address
    And user clicks azuriraj button
    When user reverts on the base url page
    And users clicks on profile button
    Then user should verify changed delivery data in the profile section

    Examples:
      | TC_ID  |
      | SI_002 |