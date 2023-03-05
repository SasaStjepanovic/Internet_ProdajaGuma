Feature: Filtering scenarios include choice different type of filter for

  @Gume
  Scenario Outline: Auto gume zimske

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_001 |

  @Gume
  Scenario Outline: Auto gume letnje

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_002 |

  @Gume
  Scenario Outline: Auto gume za sve sezone

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_003 |

  @Gume
  Scenario Outline: Kombi gume zimske

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_004 |

  @Gume
  Scenario Outline: Kombi gume letnje

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_005 |

  @Gume
  Scenario Outline: Kombi gume za sve sezone

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_006 |

  @Gume
  Scenario Outline: SUV zimske gume

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_007 |

  @Gume
  Scenario Outline: SUV letnje

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_008 |

  @Gume
  Scenario Outline: SUV gume za sve sezone

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_009 |

  @Gume
  Scenario Outline: Moto letnje gume

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_010 |

  @Gume
  Scenario Outline: Skuter letnje gume

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_011 |

  @Gume
  Scenario Outline: Traktor letnje gume

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_012 |

  @Gume
  Scenario Outline: Motor zimske gume [negative scenario]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify negative toast message

    Examples:
      | TC_ID  |
      | SI_013 |

  @Gume
  Scenario Outline: Motor letnje i zimske gume [negative scenario]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify negative toast message

    Examples:
      | TC_ID  |
      | SI_014 |

  @Gume
  Scenario Outline: Skuter zimske gume [negative scenario]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify negative toast message

    Examples:
      | TC_ID  |
      | SI_015 |

  @Gume
  Scenario Outline: Skuter letnje i zimske gume [negative scenario]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify negative toast message

    Examples:
      | TC_ID  |
      | SI_016 |

  @Gume
  Scenario Outline: Agro zimske gume [negative scenario]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify negative toast message

    Examples:
      | TC_ID  |
      | SI_017 |

  @Gume
  Scenario Outline: Agro letnje i zimske gume [negative scenario]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify negative toast message

    Examples:
      | TC_ID  |
      | SI_018 |

  @Gume
  Scenario Outline: Auto letnje gume [more parameters]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user clicks pretraga guma filter
    And user clicks detaljan pretraga filter
    When user clicks primeni filter button
    Then user should verify filtered values

    Examples:
      | TC_ID  |
      | SI_019 |

  @Gumet
  Scenario Outline: Auto letnje gume [more parameters]

    Given a user reads test data from "prodajaguma" "gume" by id "<TC_ID>"
    And user clicks main menu title
    And user clicks main menu sub title
    And user check number of availavle tires

    Examples:
      | TC_ID  |
      | SI_009 |