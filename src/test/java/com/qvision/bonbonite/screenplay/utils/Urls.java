package com.qvision.bonbonite.screenplay.utils;

public final class Urls {

    public static final String BASE = System.getProperty("base.url", "https://www.bon-bonite.com");
    public static final String INICIO = BASE + "/";
    public static final String MI_CUENTA = BASE + "/mi-cuenta/";
    public static final String EDITAR_CUENTA = BASE + "/mi-cuenta/edit-account/";
    public static final String PRODUCTO = BASE + "/producto/llavero-de-cerezas-en-cuero-y-textil/";

    private Urls() {
    }
}
