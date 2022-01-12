
Feature: Put Request

  Background:
    Given the baseURI is set


  Scenario: Verify a new todo for a new user is created
    And the user sends a get request to "/todos/11" end point
    And the id of the response payload matches with the request id 11
    And the userId of the response payload is kept
    And the request body contains userId: keptId title:"Read 50 more pages" and completed:"false"
    When the user sends a put request to "/todos" end point for a new user
    Then the response payload data should match with the request body