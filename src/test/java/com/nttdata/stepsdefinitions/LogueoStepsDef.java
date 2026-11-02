package com.nttdata.stepsdefinitions;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.CompraPage;
import com.nttdata.page.LogueoPage;
import com.nttdata.steps.*;
import io.cucumber.java.After;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class LogueoStepsDef {

    private WebDriver driver;
    // Instancias de tus Page Objects
    LogueoPage logueoPage = new LogueoPage();
    CompraPage compraPage = new CompraPage();
    CarritoPage carritoPage = new CarritoPage();

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String contraseña) {
        LogueoSteps logueoSteps = new LogueoSteps(driver);
        logueoSteps.ingressCredencial(email,contraseña);
        screenShot();
        // Utiliza los métodos de tu LogueoSteps
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoLaCategoriaYSubcategoria(String categoria, String subcategoria) {
        CarritoSteps carritoSteps = new CarritoSteps();
        CarritoSteps.seleccionarPrimerProducto();
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        CarritoSteps carritoSteps = new CarritoSteps();
        carritoSteps.configurarCantidadYAgregar(cantidad);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        CompraSteps compraSteps = new CompraSteps(driver); // O CompraPage según corresponda
        Assert.assertTrue("El popup no es visible", compraSteps.esPopupVisible());
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        CompraSteps compraSteps = new CompraSteps(driver); // O CompraPage según donde tengas el método
        double montoTotal = compraSteps.obtenerMontoTotalPopup();
        Assert.assertTrue("El monto total debe ser mayor a 0", montoTotal > 0);
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        CompraSteps compraSteps = new CompraSteps(driver); // O CompraSteps según tu estructura
        compraSteps.irACheckoutDesdePopup();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        ResumenCarritoSteps resumenCarritoSteps = new ResumenCarritoSteps(driver); // Instancias la página
        String titulo = resumenCarritoSteps.getTitle();                      // Llamas al método desde la instancia
        Assert.assertTrue("El título no contiene Carrito", titulo.toUpperCase().contains("CARRITO"));

    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
        ResumenCarritoSteps resumenCarritoSteps = new ResumenCarritoSteps(driver);
        double montoCarrito = resumenCarritoSteps.obtenerMontoTotalCarrito();
        Assert.assertTrue("El monto en el carrito es inválido", montoCarrito > 0);
    }
}



