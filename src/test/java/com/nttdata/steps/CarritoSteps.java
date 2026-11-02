package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarritoSteps {
    private WebDriver driver;
    private static WebDriverWait wait;

    //constructor
    public CarritoSteps(){
        this.driver = driver;
    }

    public static void seleccionarPrimerProducto() {
        wait.until(ExpectedConditions.elementToBeClickable(CarritoPage.primerElementInput)).click();}


    public void configurarCantidadYAgregar(int cantidad) {
        WebElement cantidadInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.elementCantidadInput));
        cantidadInputElement.clear();
        cantidadInputElement.sendKeys(String.valueOf(cantidad));

        // Usamos el nombre correcto de la variable del botón
        WebElement agregarButton = driver.findElement(CarritoPage.agregarButton);
        agregarButton.click();
    }

}
