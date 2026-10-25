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

  @US2002
  Scenario: Create a post
    When I create a post with:
      | title  | Hello Cucumber |
      | body   | My first post  |
      | userId | 1              |
    Then the response status code should be 201
    And the response field "title" should be "Hello Cucumber"

  @US2003
  Scenario: Update a post
    When I update post 1 with title "Updated title"
    Then the response status code should be 200
    And the response field "title" should be "Updated title"

  @US2004
  Scenario: Delete a post
    When I delete post 1
    Then the response status code should be 200

  @US2005
  Scenario: Filter posts by user
    When I request posts for user 1
    Then the response status code should be 200
    And the response should contain 10 items