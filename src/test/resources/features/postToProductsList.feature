# language: es
@stepsPost
Característica: Agregar productos a la lista de productos
  @insertarProducto
  Esquema del escenario: Insertar un nuevo producto

    Dado que el usuario tiene acceso a la API de productos para POST
    Cuando realiza una solicitud POST al recurso "/productsList" con el body:
      """
      {
        "name": "<nombreProducto>",
        "price": "<precio>",
        "brand": "<marca>",
        "category": {
          "usertype": {
            "usertype": "<usertype>"
          },
          "category": "<categoria>"
        }
      }
      """
    Entonces la respuesta de la insercion debe tener un código de metodo de solicitud no es soportado

    Ejemplos:
      | nombreProducto | precio  | marca   | usertype | categoria |
      | ZAPATO    | Rs. 800 | ADIDAS    | Women    | SHOES      |