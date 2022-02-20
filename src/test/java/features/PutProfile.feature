Feature: PUTPost
  Test the Put operation

  Scenario: Verify the PUT operation after POST
    Given I ensure to Perform Post operation for "/posts" with body as
      | id | title              | author          |
      | 23 | API Testing course | Rakesh Raparthi |
    And I perform PUT operation for "/posts/{postID}"
      | id | title       | author          |
      | 23 | API Testing | Rakesh Raparthi |
    And I perform GET operation with path parameter for "/posts/{postID}"
      | postID |
      | 23     |
    Then I should see the body with title as "API Testing"

