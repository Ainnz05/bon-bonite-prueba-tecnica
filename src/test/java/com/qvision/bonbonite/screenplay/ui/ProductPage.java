package com.qvision.bonbonite.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class ProductPage {

    private ProductPage() {
    }

    public static final Target TITULO_PRODUCTO = Target.the("título del producto")
            .locatedBy("//*[self::h1 or self::h2][contains(normalize-space(.),'Llavero de cerezas en cuero y textil')]");

    public static final Target BOTON_AGREGAR_CARRITO = Target.the("botón Añadir al carrito")
            .locatedBy("css:button.single_add_to_cart_button");

    public static final Target VER_CARRITO = Target.the("icono ir al carrito")
            .located(By.cssSelector("a.cart-contents[href*='/carrito/']"));
}
