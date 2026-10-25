@api @regression @US2010
Feature: Users API

  Scenario Outline: Retrieve users by id
    When I request the user with id <id>
    Then the response status code should be 200
    And the response field "name" should be "<name>"
    And the response header "Content-Type" should contain "application/json"

    Examples:
      | id | name             |
      | 1  | Leanne Graham    |
      | 2  | Ervin Howell     |
      | 3  | Clementine Bauch |