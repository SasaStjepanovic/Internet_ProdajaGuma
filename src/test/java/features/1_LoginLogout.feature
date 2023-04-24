Feature: Login scenarios include valid and invalid logins with combination of wrong credentials and Logout scenario

  @Gume
  Scenario Outline: Login valid user

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    Then user should be verified login action

    Examples:
      | TC_ID  |
      | SI_001 |

  @Gume
  Scenario Outline: Login invalid user (empty email)

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    Then user should be verified login action

    Examples:
      | TC_ID  |
      | SI_002 |

  @Gume
  Scenario Outline: Login invalid user (empty password)

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    Then user should be verified login action

    Examples:
      | TC_ID  |
      | SI_003 |

  @Gume
  Scenario Outline: Login invalid user (empty email&password)

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    Then user should be verified login action

    Examples:
      | TC_ID  |
      | SI_004 |

  @Gume
  Scenario Outline: Login invalid user (invalid password)

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    Then user should be verified login action

    Examples:
      | TC_ID  |
      | SI_005 |

  @Gume
  Scenario Outline: Login invalid user (invalid email)

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    Then user should be verified login action

    Examples:
      | TC_ID  |
      | SI_006 |

  @Gume
  Scenario Outline: Login invalid user (invalid email&password)

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"
    And users clicks on prijava button
    And user enters email and password for login
    Then user should be verified login action

    Examples:
      | TC_ID  |
      | SI_007 |

  @Gume
  Scenario Outline: Logout user

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"

    And users clicks on prijava button
    And user enters email and password for login
    Then user should be verified login action
    And users clicks on odjavi se button
    Then user should be verified logout action

    Examples:
      | TC_ID  |
      | SI_001 |
