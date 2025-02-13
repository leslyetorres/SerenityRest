#language: es
@stepsGet
Característica: Obtener la lista de todos los productos
  @traerProductos
  Esquema del escenario: Obtener la lista de productos exitosamente
    Dado que el usuario tiene acceso a la API de productos para GET
    Cuando realiza una petición GET al consumir el recurso "<recurso>"
    Entonces la respuesta debe tener un código de estado exitosa
    Ejemplos:
      | recurso       |
      | /productsList |