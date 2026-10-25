@api @smoke @US2001
Feature: Posts API

  Scenario: Retrieve a single post
    When I request the post with id 1
    Then the response status code should be 200
    And the response field "id" should be "1"
    And the response field "userId" should be "1"

  Scenario: Retrieve all posts
    When I request all posts
    Then the response status code should be 200
    And the response should contain 100 items

  Scenario: Requesting a post that does not exist
    When I request the post with id 9999
    Then the response status code should be 404