Feature: MainPageFeature
  Main page manipulations. Such as changing language, searching and sign in.

  Background:
    Given User is on the main page

  Scenario Outline: Changing language to <language>
    When User changes language to <language>
    Then Current language is <language>
    Examples:
      | language    |
      | 'Polski'    |
      | 'Russian'   |
      | 'Ukrainian' |

  Scenario: Searching hotels on main page
    When User enters correct data to search fields
    Then Search result page is appears

  Scenario: Registered user signing in
    When User sign in
    Then Username is on the top of the page