Feature: Login scenarios include valid login and invalid login with combination of wrong credentials

  @Gume
  Scenario Outline: Login valid user

    Given a user reads test data from "prodajaguma" "general" by id "<TC_ID>"

    Examples:
      | TC_ID  |
      | SI_001 |
