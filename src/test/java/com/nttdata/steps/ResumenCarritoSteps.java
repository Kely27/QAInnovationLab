package com.nttdata.steps;

import com.nttdata.page.ResumenCarritoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static com.nttdata.page.ResumenCarritoPage.montTotalInput;
import static com.nttdata.page.ResumenCarritoPage.paginaTitle;

public class ResumenCarritoSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    //constructor
    public ResumenCarritoSteps(WebDriver driver){
        this.driver = driver;
    }
    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getTitle(){
        return this.driver.findElement(paginaTitle).getText();
    }
    public double obtenerMontoTotalCarrito() {
        WebElement montoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(montTotalInput));
        String textoMonto = montoElement.getText().replace("S/", "").replace("$", "").replace("€", "").trim();
        return Double.parseDouble(textoMonto.replace(",", "."));
    }

}
