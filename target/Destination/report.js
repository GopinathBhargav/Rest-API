$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AddPlace.feature");
formatter.feature({
  "line": 2,
  "name": "adding a place",
  "description": "",
  "id": "adding-a-place",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@addplace"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Adding a place and verifying it",
  "description": "",
  "id": "adding-a-place;adding-a-place-and-verifying-it",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@add"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "the environment URL",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "header values are passed",
  "rows": [
    {
      "cells": [
        "Content-Type",
        "application/json"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "query parameters are passed",
  "rows": [
    {
      "cells": [
        "key",
        "qaclick123"
      ],
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "payload is passed with the expected values",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 11,
      "value": "#|lat|lng|accuracy|name|phone_number|address|type1|type2|website      |language|"
    },
    {
      "line": 12,
      "value": "#|123|-50|50      |vgb |897712120   |vhs    |ship |ment |www.gmail.com|eng|"
    }
  ],
  "line": 14,
  "name": "pass the \"post\" resource name",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "validate the status as \"200\"",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "retrieve the \"place_id\" value",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "the environment URL",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "query parameters are passed",
  "rows": [
    {
      "cells": [
        "key",
        "qaclick123"
      ],
      "line": 19
    },
    {
      "cells": [
        "place_id",
        "ENV-place_id"
      ],
      "line": 20
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "pass the \"get\" resource name passed",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "validate the status as \"200\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "verify name in post and get are same",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.the_environment_URL()"
});
formatter.result({
  "duration": 852642940,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.header_values_are_passed(String,String\u003e)"
});
formatter.result({
  "duration": 173027051,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.queryParamValues(String,String\u003e)"
});
formatter.result({
  "duration": 8751838,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.payload_is_passed_with_the_expected_values()"
});
formatter.result({
  "duration": 391483813,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "post",
      "offset": 10
    }
  ],
  "location": "StepDefinitions.pass_the_resource_name(String)"
});
formatter.result({
  "duration": 1157222024,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.validate_the_status_as(String)"
});
formatter.result({
  "duration": 34623618,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "place_id",
      "offset": 14
    }
  ],
  "location": "StepDefinitions.retrieve_the_value(String)"
});
formatter.result({
  "duration": 363642758,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.the_environment_URL()"
});
formatter.result({
  "duration": 436221,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.queryParamValues(String,String\u003e)"
});
formatter.result({
  "duration": 369921,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "get",
      "offset": 10
    }
  ],
  "location": "StepDefinitions.getresource_name(String)"
});
formatter.result({
  "duration": 330963952,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.validate_the_status_as(String)"
});
formatter.result({
  "duration": 700179,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.verify_name_in_post_and_get_are_same()"
});
formatter.result({
  "duration": 2292155,
  "status": "passed"
});
});