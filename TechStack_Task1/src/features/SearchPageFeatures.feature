Feature: SearchPageFeature
  Search result page manipulations. Such as sort from lowest price, adding to favorites and booking a room.

  Scenario: Sort result of hotels by lowest price
    Given User is on the search result page
    When User click on sort from lowest price button
    Then Sort from lowest price button is enabled

  Scenario: Adding to favorites
    Given User is on the search result page
    When User add hotel to the favorites
    Then Succesfulbanner is displayed

  Scenario: User is booking a room
    Given User is on the hotel page
    When User pick a room and fill UserInfo form
    Then User is on the finalStep page and succesfulbanner is displayed