Feature: DeletePosts
  Test the delete operation

  Scenario: Verify the DELETE operation after POST
    Given I ensure to Perform Post operation for "/posts" with body as
      | id | title              | author          |
      | 22 | API Testing course | Rakesh Raparthi |
    And I perform DELETE operation for "/posts/{postID}"
    |postID|
    |22    |
    And I perform GET operation with path parameter for "/posts/{postID}"
      |postID|
      |22    |
    Then I should not see the body with title as "API Testing courses"

