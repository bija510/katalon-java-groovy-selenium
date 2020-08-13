#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#<---------------We can run from here also just click run from TOP as usual or from test case lavel call it----------------->
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <nameFN>
    When I check for the <nameLN> in step
    And I verify the <address> in step
    Then Close browser

    Examples: 
      | nameFN | nameLN | address      |
      | bijaya | thapa  | 123 bogus dr |
      | david  | Lee    | 456 alpha dr |
