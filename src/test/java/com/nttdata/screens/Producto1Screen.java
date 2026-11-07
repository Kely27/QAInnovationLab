package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.nttdata.screens.AppConfigScreen.getDriver;
import static com.nttdata.screens.BaseScreen.TIMEOUT;

public class Producto1Screen {

    AndroidDriver driver = getDriver();

private WebElement esperar(By localizador) {
    WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
    return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    // Elemento que solo existe en la pantalla de productos, tras un login exitoso
private final By tituloProductos =
            AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]");

//1. Declarar el localizador correctamente
    private final By titleProducto1 =
            AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]");

    private final By cantidadProducto1 =
            AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Increase item quantity\"]");
    private final By agregarACarrito =
            By.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private final By btnCarrito =
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"Displays number of items in your cart\"]/android.widget.ImageView");

    public boolean estaEnPantallaProductos() {
        System.out.println("[Producto1Screen] Validando que se llego a la pantalla de productos...");

        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        WebElement titulo = wait.until(ExpectedConditions.presenceOfElementLocated(tituloProductos));
        boolean visible = titulo.isDisplayed();

        System.out.println("[Producto1Screen] Pantalla de productos visible: " + visible);
        return visible;}

    public void abrirPrimerProducto()
    { System.out.println("[Producto1Screen] Abriendo el primer producto");
        esperar(titleProducto1);
        getDriver().findElements(titleProducto1).get(0).click();
    }
    public void btnCantidad() {
        System.out.println("[Producto1Screen] Haciendo clic en el boton cantidad");

        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement botonLogin = wait.until(ExpectedConditions.presenceOfElementLocated(cantidadProducto1));
        botonLogin.click();
    }
    public void btnAgregar() {
        System.out.println("[Producto1Screen] Haciendo clic en el boton cantidad");

        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement botonLogin = wait.until(ExpectedConditions.presenceOfElementLocated(agregarACarrito));
        botonLogin.click();}

    public void volverALaLista() {
        System.out.println("[Producto1Screen] Volviendo a la lista");
        getDriver().navigate().back();}

    public void irAlCarrito() {
        System.out.println("[ProductosScreen] Abriendo el carrito");
        esperar(btnCarrito).click();
    }

}
