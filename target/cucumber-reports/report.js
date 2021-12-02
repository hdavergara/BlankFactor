$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/Test.feature");
formatter.feature({
  "line": 1,
  "name": "Navigate in BlankFactor",
  "description": "",
  "id": "navigate-in-blankfactor",
  "keyword": "Feature"
});
formatter.before({
  "duration": 405521600,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Technical test",
  "description": "",
  "id": "navigate-in-blankfactor;technical-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "We are on the BlankFactor main page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "We look for a given blog",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "We validate that the page shown is the correct one",
  "keyword": "Then "
});
formatter.match({
  "location": "StepTest.weAreOnTheBlankFactorMainPage()"
});
formatter.result({
  "duration": 5860609200,
  "status": "passed"
});
formatter.match({
  "location": "StepTest.weLookForAgivenBlog()"
});
formatter.result({
  "duration": 5768712000,
  "status": "passed"
});
formatter.match({
  "location": "StepTest.weValidateThatThePageShownIsTheCorrectOne()"
});
formatter.result({
  "duration": 12219440300,
  "status": "passed"
});
formatter.after({
  "duration": 692756500,
  "status": "passed"
});
});