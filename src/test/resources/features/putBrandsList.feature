#language: es
@stepsPut
Característica: Actualizar la marca en la lista de marcas
  @actualizandoMarca
  Esquema del escenario: Actualizar una marca existente en la lista
  Dado que el usuario tiene acceso a la API de marcas
  Cuando realiza una petición al consumir el recurso "/brandsList" con el body:
  """
      {
        "id": <id>,
        "brand": "<nuevaMarca>"
      }
      """
Entonces la respuesta de la actualizacion debe tener un código de metodo de solicitud no es soportado

Ejemplos:
| id           | nuevaMarca       |
| 2           | "Nuevo H&M"      |
| 3           | "Nueva Marca"    |
| 5           | "Marca Actualizada" |