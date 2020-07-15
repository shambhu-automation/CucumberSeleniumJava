$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GoogleSearchResultTest.feature");
formatter.feature({
  "line": 1,
  "name": "As a Google user I should be able to get clarivate.com as the first result on google search",
  "description": "",
  "id": "as-a-google-user-i-should-be-able-to-get-clarivate.com-as-the-first-result-on-google-search",
  "keyword": "Feature"
});
formatter.before({
  "duration": 35674189000,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Validate clarivate.com is the first result on google search",
  "description": "",
  "id": "as-a-google-user-i-should-be-able-to-get-clarivate.com-as-the-first-result-on-google-search;validate-clarivate.com-is-the-first-result-on-google-search",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@BrowserAutomation"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User navigates to \"https://www.google.com/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User search for \"Clarivate Analytics\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User validates \"https://clarivate.com/\" is the first search result",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.google.com/",
      "offset": 19
    }
  ],
  "location": "StepDefinitions.UserNavigatesTo(String)"
});
formatter.result({
  "duration": 6498324200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Clarivate Analytics",
      "offset": 17
    }
  ],
  "location": "StepDefinitions.UserSearchFor(String)"
});
formatter.result({
  "duration": 4352485000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://clarivate.com/",
      "offset": 16
    }
  ],
  "location": "StepDefinitions.UserValidatesTheSearchResult(String)"
});
formatter.result({
  "duration": 14881794900,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 4359792100,
  "status": "passed"
});
});