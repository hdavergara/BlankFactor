Feature: Buscar articulo en Fravega

  Scenario: Buscar Heladera
    Given Que estamos en la pagina principal Fravega
    When Busque el articulo Heladera
    And Aplique los filtros Heladeras
    And Filtre por marca
    Then Se muestran los articulos filtrados y se hacen validaciones
