$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Feature1.feature");
formatter.feature({
  "line": 1,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "get crane details for the city",
  "description": "",
  "id": "login-action;get-crane-details-for-the-city",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user wants crane details for \"\u003ccityName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user clicks on view on the map button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "login-action;get-crane-details-for-the-city;",
  "rows": [
    {
      "cells": [
        "cityName"
      ],
      "line": 9,
      "id": "login-action;get-crane-details-for-the-city;;1"
    },
    {
      "cells": [
        "seattle"
      ],
      "line": 10,
      "id": "login-action;get-crane-details-for-the-city;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "get crane details for the city",
  "description": "",
  "id": "login-action;get-crane-details-for-the-city;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user wants crane details for \"seattle\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user clicks on view on the map button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "seattle",
      "offset": 30
    }
  ],
  "location": "StepDefinition.user_wants_crane_details_for(String)"
});
formatter.result({
  "duration": 10371932901,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_on_view_on_the_map_button()"
});
