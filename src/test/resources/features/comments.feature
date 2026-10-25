@api @US2006
Feature: Comments API

  Scenario: Retrieve comments for a post
    When I request comments for post 1
    Then the response status code should be 200
    And the response should contain 5 items