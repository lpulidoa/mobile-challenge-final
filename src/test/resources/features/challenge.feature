Feature: IMDB

  Scenario: Verify searching functionality skipping login
    Given the user wants to make a search skipping login
    When the user searches for the movie "the northman"
    Then the user should see the correct overview in the first result page

  Scenario: Check successful watchlist addition
    Given the user logs in
    And the user wants to make a search
    When the user searches for the movie "the fifth element"
    And the user adds a result to their watchlist
    Then the user must see the movie in their watchlist

  Scenario: Authenticate movie rating functionality
    Given the user logs in
    And the user wants to make a search
    When the user searches for the movie "joker"
    And the user rates the first result 8 stars
    Then the user should see the correct rating displayed in the movie page
    #Then the user should see a saved rating message

  Scenario: Verify list creation
    Given the user logs in
    When the user creates a list with the following characteristics
      | name           | My awesome test list                        |
      | description    | Just an awesome test list for the challenge |
      | type           | Name                                        |
    Then the user should see the number of existing lists increase

