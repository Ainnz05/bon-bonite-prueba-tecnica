package com.qvision.bonbonite.stepdefinitions;

import com.qvision.bonbonite.screenplay.tasks.AbrirBonBonite;
import com.qvision.bonbonite.screenplay.tasks.AgregarProductoCarrito;
import com.qvision.bonbonite.screenplay.tasks.FinalizarCompra;
import com.qvision.bonbonite.screenplay.tasks.IniciarSesion;
import com.qvision.bonbonite.screenplay.tasks.RegistrarUsuario;

import com.qvision.bonbonite.screenplay.ui.AccountPage;
import com.qvision.bonbonite.screenplay.ui.CartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.ensure.Ensure;

import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BonBoniteStepDefinitions {

    @Given("que {word} ingresa a Bon-Bonite")
    public void ingresarABonBonite(String nombreActor) {

        theActorCalled(nombreActor).attemptsTo(
                AbrirBonBonite.enInicio()
        );
    }

    // =========================
    // REGISTRO
    // =========================

    @When("registra un usuario nuevo con datos válidos")
    public void registrarUsuarioNuevo() {

        theActorInTheSpotlight().attemptsTo(
                RegistrarUsuario.conDatosFijos()
        );
    }

    @Then("la cuenta debe quedar creada correctamente")
    public void validarCuentaCreada() {

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(
                        AccountPage.CERRAR_SESION
                                .waitingForNoMoreThan(Duration.ofSeconds(15))
                ).isDisplayed()
        );
    }

    // =========================
    // INICIO DE SESIÓN
    // =========================

    @When("inicia sesión con credenciales válidas")
    public void iniciarSesion() {

        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.conCredencialesValidas()
        );
    }

    @Then("debe visualizar su cuenta autenticada")
    public void validarInicioSesion() {

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(
                        AccountPage.CERRAR_SESION
                                .waitingForNoMoreThan(Duration.ofSeconds(15))
                ).isDisplayed()
        );
    }

    // =========================
    // COMPRA / CARRITO
    // =========================

    @When("agrega un producto disponible al carrito")
    public void agregarProductoAlCarrito() {

        theActorInTheSpotlight().attemptsTo(
                AgregarProductoCarrito.productoDisponible()
        );
    }

    @Then("el producto debe visualizarse en el carrito")
    public void validarProductoEnCarrito() {

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(
                        CartPage.PRODUCTO_AGREGADO
                                .waitingForNoMoreThan(Duration.ofSeconds(15))
                ).isDisplayed()
        );
    }

    @When("finaliza la compra hasta el checkout")
    public void finalizarCompraHastaCheckout() {

        theActorInTheSpotlight().attemptsTo(
                FinalizarCompra.hastaCheckout()
        );
    }

    @Then("debe visualizar la página de finalizar compra")
    public void validarPaginaFinalizarCompra() {

        theActorInTheSpotlight().attemptsTo(
                Ensure.thatTheCurrentPage()
                        .currentUrl()
                        .contains("finalizar-compra")
        );
    }
}