package com.qvision.bonbonite.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class AccountPage {

    private AccountPage() {
    }

    // Registro: estos selectores se conservan tal como estaban en el flujo funcional.
    public static final Target BOTON_ABRIR_REGISTRO =
            Target.the("botón Regístrate")
                    .located(By.id("show_register"));

    public static final Target CEDULA_REGISTRO = Target.the("cédula de registro")
            .located(By.id("reg_username"));

    public static final Target NOMBRES_REGISTRO = Target.the("nombres de registro")
            .located(By.id("first_name"));

    public static final Target APELLIDOS_REGISTRO = Target.the("apellidos de registro")
            .located(By.id("last_name"));

    public static final Target EMAIL_REGISTRO = Target.the("correo electrónico de registro")
            .located(By.id("reg_email"));

    public static final Target PASSWORD_REGISTRO = Target.the("contraseña de registro")
            .located(By.id("reg_password"));

    public static final Target CONFIRMAR_PASSWORD = Target.the("confirmación de contraseña")
            .located(By.id("reg_password2"));

    public static final Target AUTORIZACION_DATOS = Target.the("autorización de tratamiento de datos")
            .located(By.id("privacy_policy_reg"));

    public static final Target BOTON_REGISTRAR = Target.the("botón Registrarme")
            .located(By.name("register"));

    // Inicio de sesión.
    public static final Target CEDULA_LOGIN = Target.the("cédula de inicio de sesión")
            .located(By.id("username"));

    public static final Target PASSWORD_LOGIN = Target.the("contraseña de inicio de sesión")
            .located(By.id("password"));

    public static final Target BOTON_INICIAR_SESION = Target.the("botón Iniciar Sesión")
            .located(By.name("login"));

    public static final Target CERRAR_SESION = Target.the("enlace Cerrar sesión")
            .locatedBy("//a[contains(@href,'customer-logout') or contains(normalize-space(.),'Cerrar sesión')]");
}
