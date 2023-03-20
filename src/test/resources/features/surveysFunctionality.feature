@surveys
Feature: Verify the Surveys Functionality
  Background: user is log on the home page

    Given user is on the surveys module page of web table app

  Scenario: Verify that user can create a survey
    When user click the Create Button
    And user write any "title" on Title label
    And user click the Save Button
    Then user should create a survey

  Scenario: Verify that user cannot create a survey without typing title (empty title)
    When user click the Create Button
    And user click the Save Button
    Then user should not create a survey

  Scenario: Verify that user can cancel the process by clicking Discard button
    When user click the Create Button
    And user click the Discard Button
    Then user should cancel the process

  Scenario: Verify that page title is changed to the new survey name after user create the survey
    When user click the Create Button
    And user write any "title" on Title label
    And user click the Save Button
    And user click the Edit Button
    And user write any "new title" on Title label
    And user click the Save Button
    Then user should see the page title is changed to the new survey name after user create the survey

  Scenario: Verify that “Survey created” message is displayed at the bottom of the page (after creating a new survey).
    When user click the Create Button
    And user write any "title" on Title label
    And user click the Save Button
    Then user should see Survey created message is displayed at the bottom of the page (after creating a new survey)

  Scenario: Verify that user can find the new created survey under permanent survey list by using search box.
    When user click the Create Button
    And user write any "title" on Title label
    And user click the Save Button
    And user click the List button
    And  user write new created "title" under permanent survey list by using search box.
    Then user should find the new created survey

  Scenario: Verify that user can change surveys display to Kanban
    When user click the Kanban button
    Then user should see the data like as Kanban type

  Scenario: Verify that user can change surveys display to List
    When user click the List button
    Then user should see the data like as List type

  Scenario: Verify that the number of surveys increased 1
    When user click the List button
    And user click the Create Button
    And user write any "title" on Title label
    And user click the Save Button
    Then user should see the number of surveys increased 1