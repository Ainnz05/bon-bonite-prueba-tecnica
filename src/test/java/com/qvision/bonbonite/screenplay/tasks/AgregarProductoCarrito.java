package com.qvision.bonbonite.screenplay.tasks;

import com.qvision.bonbonite.screenplay.ui.ProductPage;
import com.qvision.bonbonite.screenplay.utils.Urls;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public final class AgregarProductoCarrito {

    private AgregarProductoCarrito() {
    }

    private static void pausa() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Performable productoDisponible() {

        return Task.where(
                "{0} agrega un producto disponible al carrito",

                actor -> {

                    // Abrir producto
                    actor.attemptsTo(
                            Open.url(Urls.PRODUCTO)
                    );

                    pausa();

                    // Esperar que cargue el producto
                    actor.attemptsTo(
                            WaitUntil.the(
                                    ProductPage.TITULO_PRODUCTO,
                                    isVisible()
                            ).forNoMoreThan(15).seconds()
                    );

                    pausa();

                    // Ir al botón agregar al carrito
                    actor.attemptsTo(
                            Scroll.to(
                                    ProductPage.BOTON_AGREGAR_CARRITO
                            )
                    );

                    pausa();

                    // Agregar producto
                    actor.attemptsTo(
                            Click.on(
                                    ProductPage.BOTON_AGREGAR_CARRITO
                            )
                    );

                    pausa();

                    // Esperar botón "Ver carrito"
                    actor.attemptsTo(
                            WaitUntil.the(
                                    ProductPage.VER_CARRITO,
                                    isVisible()
                            ).forNoMoreThan(15).seconds()
                    );

                    pausa();

                    // Ir al carrito
                    actor.attemptsTo(
                            Click.on(
                                    ProductPage.VER_CARRITO
                            )
                    );

                    pausa();
                }
        );
    }
}