package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MiAppSteps;
import com.nttdata.support.ScreenshotAttacher;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class MiAppStepsDefs {
    private final MiAppSteps miAppSteps = new MiAppSteps();

    private Scenario scenario;

    @Before
    public void configurarScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @When("ingreso el usuario1 {string}")
    public void ingreso_el_usuario1(String usuario) {
        miAppSteps.ingresarUsuario(usuario);
    }

    @And("ingreso la clave1 {string}")
    public void ingreso_la_clave1(String clave) {
        miAppSteps.ingresarClave(clave);
    }

    @And("hago clic en boton login")
    public void hago_clic_en_boton_login() {
        miAppSteps.clicEnLogin();
        ScreenshotAttacher.attach(scenario, "Despues de hacer login");
    }

    @Then("valido el login correctamente")
    public void valido_el_login_correctamente() {
        assertTrue(
                "No se encontro la pantalla de productos: el login no fue exitoso",
                miAppSteps.loginFueExitoso()
        );
    }
}
