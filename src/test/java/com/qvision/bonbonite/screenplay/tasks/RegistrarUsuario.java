package com.qvision.bonbonite.screenplay.tasks;

import com.qvision.bonbonite.screenplay.ui.AccountPage;
import com.qvision.bonbonite.screenplay.utils.Urls;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public final class RegistrarUsuario {

    private RegistrarUsuario() {
    }

    private static void pausa() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Performable conDatosFijos() {

        return Task.where(
                "{0} registra una nueva cuenta con datos fijos",

                actor -> {
                    actor.attemptsTo(Open.url(Urls.MI_CUENTA));
                    pausa();

                    actor.attemptsTo(
                            Click.on(AccountPage.BOTON_ABRIR_REGISTRO)
                    );
                    pausa();

                    actor.attemptsTo(
                            WaitUntil.the(
                                    AccountPage.CEDULA_REGISTRO,
                                    isVisible()
                            ).forNoMoreThan(10).seconds()
                    );

                    actor.attemptsTo(
                            Enter.theValue("1010061901")
                                    .into(AccountPage.CEDULA_REGISTRO)
                    );
                    pausa();

                    actor.attemptsTo(
                            Enter.theValue("Juan Camilo")
                                    .into(AccountPage.NOMBRES_REGISTRO)
                    );
                    pausa();

                    actor.attemptsTo(
                            Enter.theValue("Pulido Vargas")
                                    .into(AccountPage.APELLIDOS_REGISTRO)
                    );
                    pausa();

                    actor.attemptsTo(
                            Enter.theValue("qa.juan.pulido.17112026.2@example.com")
                                    .into(AccountPage.EMAIL_REGISTRO)
                    );
                    pausa();

                    actor.attemptsTo(
                            Enter.theValue("QaBonBonite#2026!")
                                    .into(AccountPage.PASSWORD_REGISTRO)
                    );
                    pausa();

                    actor.attemptsTo(
                            Enter.theValue("QaBonBonite#2026!")
                                    .into(AccountPage.CONFIRMAR_PASSWORD)
                    );
                    pausa();

                    actor.attemptsTo(
                            Click.on(AccountPage.AUTORIZACION_DATOS)
                    );
                    pausa();


                    actor.attemptsTo(
                            Click.on(AccountPage.BOTON_REGISTRAR)
                                    .afterWaitingUntilEnabled()
                    );
                    pausa();
                }
        );
    }
}