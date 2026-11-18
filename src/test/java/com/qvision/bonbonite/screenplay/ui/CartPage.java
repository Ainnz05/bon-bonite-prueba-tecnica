package com.qvision.bonbonite.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public final class CartPage {

    private CartPage() {
    }

    public static final Target PRODUCTO_AGREGADO =
            Target.the("producto agregado al carrito")
                    .locatedBy(
                            "//form[contains(@class,'woocommerce-cart-form')]" +
                                    "//*[contains(normalize-space(.),'Llavero de cerezas en cuero y textil')]"
                    );

    public static final Target BOTON_FINALIZAR_COMPRA =
            Target.the("botón Finalizar compra")
                    .locatedBy(
                            "//div[contains(@class,'wc-proceed-to-checkout')]" +
                                    "//a[contains(normalize-space(.),'Finalizar compra')]"
                    );
}