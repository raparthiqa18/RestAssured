Feature:
  Verify different Post operations using Rest Assured

  Scenario: Verify Post operation for profile
    Given I perform Post operation for "/posts/{profileNo}/profile" with body
    | name | profile |
    | sams | 2       |
    Then I should see the body has name as "sam"


#  Scenario: Verify Posting a new author of the post
#    Given I perform POST operation for "/posts", "21"
#    Then I should see the author name as "typicode21"