Feature: Search

  Scenario: Test 1
    Given the user wants to make a search skipping login
    When the user searches for the movie "men in black"
    Then the user should see the correct overview in the first result page

  Scenario: Test 2
    Given the user logs in
    And the user wants to make a search
    When the user searches for the movie "the fifth element"
    And the user adds a result to their watchlist
    Then the user must see the movie in their watchlist

  Scenario: Test 3
    Given the user logs in
    And the user wants to make a search
    When the user searches for the movie "the menu"
    And the user rates the first result 8 stars
    Then the user should see the correct rating displayed in the movie page
    #Then the user should see a saved rating message

