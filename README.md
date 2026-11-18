# Bon-Bonite - Prueba Técnica QA Automation con Screenplay

Proyecto de automatización de **Bon-Bonite** usando **Java 17 + Serenity BDD + Screenplay + Cucumber + Gradle**.

## Escenarios automatizados

El proyecto queda enfocado en tres escenarios simples:

1. **@registro**: registra un usuario y modifica sus datos. Este flujo se conserva tal como estaba funcionando.
2. **@login**: inicia sesión con un usuario previamente registrado y valida que la sesión quede autenticada.
3. **@compra**: agrega un producto disponible al carrito y valida que aparezca dentro del carrito.

## Estructura Screenplay

- **Actor**: Juan.
- **Ability**: `BrowseTheWeb`, proporcionada por Serenity/OnlineCast.
- **Tasks**: `AbrirBonBonite`, `RegistrarUsuario`, `ActualizarCuenta`, `IniciarSesion`, `AgregarProductoCarrito`.
- **Interactions**: `Open`, `Enter`, `Click`, `Clear`, `Scroll`, `WaitUntil` y `AceptarCookiesSiAparecen`.
- **Targets**: centralizados en `screenplay/ui`.


## Ejecutar una prueba a la vez en PowerShell

Registro:

```powershell
$env:CUCUMBER_FILTER_TAGS="@registro"
.\gradlew test
```

Login:

```powershell
$env:CUCUMBER_FILTER_TAGS="@login"
.\gradlew test
```

Agregar producto al carrito:

```powershell
$env:CUCUMBER_FILTER_TAGS="@compra"
.\gradlew test
```


## Reporte Serenity

Después de ejecutar las pruebas:

```text
target/site/serenity/index.html
```

## Datos usados para login

El flujo de login usa la misma cédula y contraseña del usuario de prueba que ya fue registrado en el flujo existente.

## Producto usado

El escenario `@compra` abre directamente un producto del catálogo y lo agrega al carrito. Como Bon-Bonite es un ecommerce real, el inventario puede cambiar. Si el producto deja de estar disponible, basta con cambiar `Urls.PRODUCTO` y el texto del producto en `ProductPage` y `CartPage`.
