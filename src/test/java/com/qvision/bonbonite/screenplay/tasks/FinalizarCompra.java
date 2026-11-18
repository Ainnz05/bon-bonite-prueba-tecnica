package com.qvision.bonbonite.screenplay.tasks;

import com.qvision.bonbonite.screenplay.ui.CartPage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public final class FinalizarCompra {

    private FinalizarCompra() {
    }

    private static void pausa() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Performable hastaCheckout() {

        return Task.where(
                "{0} avanza hasta finalizar la compra",

                actor -> {

                    // Esperar que el botón aparezca
                    actor.attemptsTo(
                            WaitUntil.the(
                                    CartPage.BOTON_FINALIZAR_COMPRA,
                                    isVisible()
                            ).forNoMoreThan(15).seconds()
                    );

                    pausa();

                    // Colocar el botón abajo de la pantalla
                    // para evitar que el header fijo quede encima
                    actor.attemptsTo(
                            Scroll.to(
                                    CartPage.BOTON_FINALIZAR_COMPRA
                            ).andAlignToBottom()
                    );

                    pausa();

                    // Clic mediante JavaScript para evitar
                    // ElementClickInterceptedException
                    actor.attemptsTo(
                            JavaScriptClick.on(
                                    CartPage.BOTON_FINALIZAR_COMPRA
                            )
                    );

                    pausa();
                }
        );
    }
}