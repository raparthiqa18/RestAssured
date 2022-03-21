
  Feature: demo to DBS

    Scenario Outline: To demonstrate BDD knowledge
      Given I login to PayMe application
      When I search for consumer using "<MemberID>"
      Then I want to check if the consumer is found
      And Validate if the consumer status is "<Status>"
      Examples:
      |MemberID|Status|
      |M2727262|Active|

