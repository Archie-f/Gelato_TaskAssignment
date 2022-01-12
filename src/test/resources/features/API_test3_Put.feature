@wip
Feature: Put Request


  Scenario: Verify a todo of a user is updated
    Given the baseURI is set
    And the user sends a get request to "/todos/11" end point
    And the id of the response payload matches with the request id 11
    And the userId of the response payload is kept
    And the request body contains userId: keptId title:"Read 50 more pages" and completed:"false"
    When the user sends a put request to "/todos/" end point with the userId
    Then the response payload data should match with the request body