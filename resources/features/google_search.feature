Feature: As a Google user I should be able to get clarivate.com as the first result on google search

  Scenario: Validate clarivate.com is the first result on google search
  	Given User navigates to "https://www.google.com/"
  	When User search for "Clarivate Analytics"
  	Then User validates "https://clarivate.com/" is the first search result 
   
 
   
