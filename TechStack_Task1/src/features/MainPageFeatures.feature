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

  Scenario Outline: Searching hotels on main page
    When User enters correct data to search fields: <cityName>, <dateCheckIn> and <dateCheckOut>
    Then Search result page is appears with <cityName> in title
    Examples:
      | cityName  | dateCheckIn  | dateCheckOut |
      | 'Kharkiv' | '2022-03-28' | '2022-03-30' |
      | 'Kyiv'    | '2022-03-01' | '2022-03-08' |
      | 'Odesa'   | '2022-03-04' | '2022-03-06' |

  Scenario: Registered user signing in
    When User sign in
    Then Username is on the top of the page