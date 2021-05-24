$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/PruebasApi.feature");
formatter.feature({
  "line": 1,
  "name": "Consultas Api",
  "description": "",
  "id": "consultas-api",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Buscar cerveceria por nombre",
  "description": "",
  "id": "consultas-api;buscar-cerveceria-por-nombre",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Que tenemos la api de cervecerias",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Ejecutamos el servicio para buscar la cerverceria \u003cNombreCerveceria\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Obtenemos la respuesta del parametro dado",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "consultas-api;buscar-cerveceria-por-nombre;",
  "rows": [
    {
      "cells": [
        "NombreCerveceria"
      ],
      "line": 9,
      "id": "consultas-api;buscar-cerveceria-por-nombre;;1"
    },
    {
      "cells": [
        "lagunita"
      ],
      "line": 10,
      "id": "consultas-api;buscar-cerveceria-por-nombre;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "Buscar cerveceria por nombre",
  "description": "",
  "id": "consultas-api;buscar-cerveceria-por-nombre;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Que tenemos la api de cervecerias",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Ejecutamos el servicio para buscar la cerverceria lagunita",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Obtenemos la respuesta del parametro dado",
  "keyword": "Then "
});
formatter.match({
  "location": "StepApi.queTenemosLaApiDeCervecerias()"
});
formatter.result({
  "duration": 209897000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lagunita",
      "offset": 50
    }
  ],
  "location": "StepApi.ejecutamosElServicioParaBuscarLaCerverceria(String)"
});
formatter.result({
  "duration": 2437866600,
  "status": "passed"
});
formatter.match({
  "location": "StepApi.obtenemosLaRespuestaDelParametroDado()"
});
