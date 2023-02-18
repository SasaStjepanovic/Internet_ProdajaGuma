Feature:

  @Gume
  Scenario Outline: Enter own data (fizicka lica)

    Given a user reads test data from "prodajaguma" "profile" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on profile button
    And user enters profile own data

    Examples:
      | TC_ID  |
      | SI_001 |