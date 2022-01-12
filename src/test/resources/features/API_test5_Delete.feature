@wip
Feature: Delete Request


  Scenario: Verify a completed status of a user is updated
    Given the baseURI is set
    When the user sends a delete request to "/todos/" end point with the userId 15
    Then the response payload data should be empty