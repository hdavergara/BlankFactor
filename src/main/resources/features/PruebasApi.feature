Feature: Consultas Api

  Scenario Outline: Buscar cerveceria por nombre
    Given Que tenemos la api de cervecerias
    When Ejecutamos el servicio para buscar la cerverceria <NombreCerveceria>
    Then Obtenemos la respuesta del parametro dado

    Examples:
      | NombreCerveceria |
      | lagunita         |

#  Scenario Outline: Obtener cervecerias por nombre
#    Given Que tenemos la api de cervecerias
#    When Ejecutamos el servicio para buscar la cerverceria <NombreCerveceria>
#    Then Obtenemos las cervecerias filtradas por el nombre buscado
#
#    Examples:
#      | NombreCerveceria |
#      | lagunita         |