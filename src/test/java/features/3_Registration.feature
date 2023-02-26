Feature:Registration scenarios include

#  @Gume
#  Scenario Outline: Valid Registration (random name & email)
#
#    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
#    And users clicks on prijava button
#    And user clicks on registruj se button
#    When user enter registration data
#    Then user should be verified registration action
#
#    Examples:
#      | TC_ID  |
#      | SI_008 |

  @Gume
  Scenario Outline: Invalid Registration (empty name & username)

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    When user enter registration data
    Then user should be verified registration action

    Examples:
      | TC_ID  |
      | SI_001 |

  @Gume
  Scenario Outline: Invalid Registration (empty email)

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    When user enter registration data
    Then user should be verified registration action

    Examples:
      | TC_ID  |
      | SI_002 |

  @Gume
  Scenario Outline: Invalid Registration (empty password)

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    When user enter registration data
    Then user should be verified registration action

    Examples:
      | TC_ID  |
      | SI_003 |

  @Gume
  Scenario Outline: Invalid Registration (empty confirm password)

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    When user enter registration data
    Then user should be verified registration action

    Examples:
      | TC_ID  |
      | SI_004 |

  @Gume
  Scenario Outline: Invalid Registration (password & confirm password are not equal)

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    When user enter registration data
    Then user should be verified registration action

    Examples:
      | TC_ID  |
      | SI_005 |

  @Gume
  Scenario Outline: Invalid Registration (email format is not valid)

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    When user enter registration data
    Then user should be verified registration action

    Examples:
      | TC_ID  |
      | SI_006 |

  @Gume
  Scenario Outline: Invalid Registration (password doesn't contain min character)

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    When user enter registration data
    Then user should be verified registration action

    Examples:
      | TC_ID  |
      | SI_007 |

  @Gume
  Scenario Outline: Registruj se button is disabled

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    Then user should be verified that registryj se button is disabled

    Examples:
      | TC_ID  |
      | SI_001 |

  @Gume
  Scenario Outline: Registruj se button is enabled

    Given a user reads test data from "prodajaguma" "registration" by id "<TC_ID>"
    And users clicks on prijava button
    And user clicks on registruj se button
    And user check prihvatam checkbox
    Then user should be verified that registryj se button is enabled

    Examples:
      | TC_ID  |
      | SI_001 |



