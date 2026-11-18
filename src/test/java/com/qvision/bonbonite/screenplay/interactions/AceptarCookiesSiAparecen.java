package com.qvision.bonbonite.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AceptarCookiesSiAparecen implements Interaction {

    public static AceptarCookiesSiAparecen ahora() {
        return Tasks.instrumented(AceptarCookiesSiAparecen.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until(d -> Boolean.TRUE.equals(
                    ((JavascriptExecutor) d).executeScript(
                            "return typeof CookieScript !== 'undefined' " +
                                    "&& CookieScript.instance != null;"
                    )
            ));

            ((JavascriptExecutor) driver).executeScript(
                    "CookieScript.instance.acceptAllAction();"
            );

            wait.until(d -> Boolean.TRUE.equals(
                    ((JavascriptExecutor) d).executeScript(
                            "var e = document.getElementById('cookiescript_injected');" +
                                    "return !e || e.offsetParent === null;"
                    )
            ));

        } catch (Exception ignored) {
            // Si el banner no aparece, la prueba continúa normalmente.
        }
    }
}