# Bon-Bonite - Prueba técnica QA Automation

Automatización de pruebas funcionales del sitio [Bon-Bonite](https://www.bon-bonite.com/) con **Java 17, Serenity BDD (Screenplay), Cucumber y Gradle**.

## Escenarios

Los escenarios están en `src/test/resources/features/bon_bonite.feature` y se pueden ejecutar por etiqueta:

| Etiqueta | Escenario | Validación |
|----------|-----------|------------|
| `@registro` | Registrar un usuario nuevo | Aparece el enlace "Cerrar sesión" |
| `@login` | Iniciar sesión con el usuario registrado | Aparece el enlace "Cerrar sesión" |
| `@compra` | Agregar un producto al carrito y avanzar al checkout | El producto aparece en el carrito y la URL contiene `finalizar-compra` |

## Estructura del proyecto

```text
src/test
├── java/com/qvision/bonbonite
│   ├── runner             TestSuite (ejecutor Cucumber/JUnit Platform)
│   ├── stepdefinitions    BonBoniteStepDefinitions, Hooks
│   └── screenplay
│       ├── tasks          AbrirBonBonite, RegistrarUsuario, IniciarSesion,
│       │                  AgregarProductoCarrito, FinalizarCompra
│       ├── interactions   AceptarCookiesSiAparecen
│       ├── ui             AccountPage, ProductPage, CartPage (Targets)
│       └── utils          Urls
└── resources/features     bon_bonite.feature
```

- **Actor:** Juan, con la habilidad `BrowseTheWeb` (Serenity `OnlineCast`).
- **Tasks:** acciones de negocio del usuario.
- **Targets:** localizadores centralizados en `screenplay/ui`.

## Requisitos

- JDK 17
- Google Chrome (el driver se descarga automáticamente)
- Acceso a internet

`gradle.properties` define `org.gradle.java.home` con una ruta de Windows. Si tu JDK 17 está en otra ubicación, ajusta o elimina esa línea.

## Ejecución

Todos los escenarios:

```bash
./gradlew clean test aggregate
```

Un escenario por etiqueta (Linux/macOS):

```bash
CUCUMBER_FILTER_TAGS="@login" ./gradlew test
```

Un escenario por etiqueta (PowerShell):

```powershell
$env:CUCUMBER_FILTER_TAGS="@login"
.\gradlew test
```

Sin ventana del navegador:

```bash
./gradlew clean test aggregate -Dheadless.mode=true
```

## Reporte

Al terminar, el reporte de Serenity queda en:

```text
target/site/serenity/index.html
```

Las capturas de pantalla se generan solo cuando una prueba falla.

## Datos de prueba y consideraciones

- Los datos de registro y de inicio de sesión están definidos directamente en `RegistrarUsuario.java` e `IniciarSesion.java`.
- `@login` depende de que `@registro` haya creado antes el usuario. Si se vuelve a ejecutar `@registro`, el sitio puede rechazar una cédula o un correo que ya existan, por lo que hay que cambiar esos valores.
- `@compra` abre un producto concreto definido en `Urls.PRODUCTO`. Como es una tienda real, el inventario puede cambiar. Si el producto deja de estar disponible, actualiza `Urls.PRODUCTO` y el nombre del producto en `ProductPage` y `CartPage`.


## Integración continua

`.github/workflows/qa.yml` ejecuta las pruebas en GitHub Actions en modo headless y publica el reporte de Serenity como artefacto.