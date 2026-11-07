package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MiAppSteps;
import com.nttdata.steps.Producto1Steps;
import com.nttdata.support.ScreenshotAttacher;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class ProductosStepsDefs {

    private final Producto1Steps producto1Steps = new Producto1Steps();

    private Scenario scenario;

    @Before
    public void configurarScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {
    boolean visible = producto1Steps.pantallaProductos();
    assertTrue("La galería de productos no cargó correctamente", visible);}

    @When("Selecciono el primer producto{string}")
    public void Seleccion_el_primer_producto(String nombreProducto) {
        producto1Steps.cantidadPrimerProducto();
    }

    @And("Selecciono la cantidad del producto")
    public void Seleccion_la_cantidad_del_producto() {
        producto1Steps.clicEnPrimerProducto();
    }

    @And("agrego el producto al carrito")
    public void agrego_el_producto_al_carrito() {
        producto1Steps.agregarPrimerProducto();
        ScreenshotAttacher.attach(scenario, "Despues selecionar el producto");
    }

    @And("retorno a la lista de productos ")
    public void retorno_a_la_lista_de_productos() {
        producto1Steps.volverListaProducto();
        ScreenshotAttacher.attach(scenario, "Despues de hacer login");
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void valido_el_carrito_de_compra_actualice_correctamente() {
        boolean actualizado = producto1Steps.irACarrito();
        assertTrue("El carrito de compras no se actualizó correctamente", actualizado);
    }

}
