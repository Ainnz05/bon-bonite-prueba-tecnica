package com.qvision.bonbonite.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AceptarCookiesSiAparecen implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        var driver = BrowseTheWeb.as(actor).getDriver();
        List<By> candidatos = List.of(
                By.xpath("//button[contains(normalize-space(.),'Aceptar todas')]") ,
                By.xpath("//button[normalize-space()='Aceptar']"),
                By.xpath("//button[normalize-space()='Acepto']")
        );

        for (By locator : candidatos) {
            List<WebElement> elementos = driver.findElements(locator);
            if (!elementos.isEmpty() && elementos.get(0).isDisplayed() && elementos.get(0).isEnabled()) {
                elementos.get(0).click();
                break;
            }
        }
    }

    public static Performable ahora() {
        return Tasks.instrumented(AceptarCookiesSiAparecen.class);
    }
}
