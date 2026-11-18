package com.qvision.bonbonite.screenplay.tasks;

import com.qvision.bonbonite.screenplay.interactions.AceptarCookiesSiAparecen;
import com.qvision.bonbonite.screenplay.utils.Urls;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public final class AbrirBonBonite {

    private AbrirBonBonite() {
    }

    public static Performable enInicio() {
        return Task.where("{0} abre el sitio Bon-Bonite",
                Open.url(Urls.INICIO),
                AceptarCookiesSiAparecen.ahora()
        );
    }
}
