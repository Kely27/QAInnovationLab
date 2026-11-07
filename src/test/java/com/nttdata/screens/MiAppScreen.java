package com.nttdata.screens;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.screens.AppConfigScreen.getDriver;


public class MiAppScreen {

        private static final Duration TIMEOUT = Duration.ofSeconds(20);

    private final By txtUsuario =
            AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]");

    private final By txtClave =
            AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]");

    private final By btnLogin =
            AppiumBy.accessibilityId("Tap to login with given credentials");
    // Elemento que solo existe en la pantalla de productos, tras un login exitoso
    private final By tituloProductos =
            AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]");

    public void escribirUsuario(String usuario) {
        System.out.println("[MiAppScreen] Escribiendo usuario: " + usuario);

        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        WebElement campoUsuario = wait.until(ExpectedConditions.presenceOfElementLocated(txtUsuario));
        campoUsuario.sendKeys(usuario);
    }

    public void escribirClave(String clave) {
        System.out.println("[MiAppScreen] Escribiendo clave...");

        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        WebElement campoClave = wait.until(ExpectedConditions.presenceOfElementLocated(txtClave));
        campoClave.sendKeys(clave);
    }

    public void clicEnLogin() {
        System.out.println("[MiAppScreen] Haciendo clic en el boton LOGIN");

        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        WebElement botonLogin = wait.until(ExpectedConditions.presenceOfElementLocated(btnLogin));
        botonLogin.click();
    }

    public boolean estaEnPantallaDeProductos() {
        System.out.println("[MiAppScreen] Validando que se llego a la pantalla de productos...");

        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        WebElement titulo = wait.until(ExpectedConditions.presenceOfElementLocated(tituloProductos));
        boolean visible = titulo.isDisplayed();

        System.out.println("[MiAppScreen] Pantalla de productos visible: " + visible);
        return visible;
    }
}



