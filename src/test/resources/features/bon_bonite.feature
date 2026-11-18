# language: es
@bonbonite @screenplay

Característica: Validación funcional automatizada del sitio Bon-Bonite

  @registro
  Escenario: Registrar un usuario exitosamente
    Dado que Juan ingresa a Bon-Bonite
    Cuando registra un usuario nuevo con datos válidos
    Entonces la cuenta debe quedar creada correctamente

  @login
  Escenario: Iniciar sesión con un usuario registrado
    Dado que Juan ingresa a Bon-Bonite
    Cuando inicia sesión con credenciales válidas
    Entonces debe visualizar su cuenta autenticada

  @compra
  Escenario: Agregar un producto y avanzar hasta finalizar la compra
    Dado que Juan ingresa a Bon-Bonite
    Cuando agrega un producto disponible al carrito
    Entonces el producto debe visualizarse en el carrito
    Cuando finaliza la compra hasta el checkout
    Entonces debe visualizar la página de finalizar compra