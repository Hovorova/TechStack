Feature: Main page manipulations. Such as changing language, searching and sign in.

  Scenario Outline: Changing language to <language>
    Given User is on the main page
    When User changes language to <language>
    Then Current language is <language>
    Examples:
      | language    |
      | 'Polski'    |
      | 'English'   |
      | 'Russian'   |
      | 'Ukrainian' |

  Scenario: Searching hotels on main page
    Given User is on the main page
    When User enters correct data to search fields
    Then Search result page is appears

  Scenario: Registered user signing in
    Given User is on the main page
    When User sign in
    Then Username is on the top of the page