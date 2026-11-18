package com.qvision.bonbonite.screenplay.tasks;

import com.qvision.bonbonite.screenplay.ui.AccountPage;
import com.qvision.bonbonite.screenplay.utils.Urls;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public final class IniciarSesion {

    private IniciarSesion() {
    }

    private static void pausa() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Performable conCredencialesValidas() {
        return Task.where(
                "{0} inicia sesión con credenciales válidas",
                actor -> {
                    actor.attemptsTo(Open.url(Urls.MI_CUENTA));
                    pausa();

                    actor.attemptsTo(
                            WaitUntil.the(AccountPage.CEDULA_LOGIN, isVisible())
                                    .forNoMoreThan(10).seconds()
                    );

                    actor.attemptsTo(
                            Enter.theValue("1010061901")
                                    .into(AccountPage.CEDULA_LOGIN)
                    );
                    pausa();

                    actor.attemptsTo(
                            Enter.theValue("QaBonBonite#2026!")
                                    .into(AccountPage.PASSWORD_LOGIN)
                    );
                    pausa();

                    actor.attemptsTo(
                            Click.on(AccountPage.BOTON_INICIAR_SESION)
                    );
                    pausa();
                }
        );
    }
}
