package com.nttdata.steps;

import com.nttdata.page.CompraPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nttdata.page.CompraPage.finalizarCompraButton;
import static com.nttdata.page.CompraPage.obtenermontoInput;


public class CompraSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    //constructor
    public CompraSteps(WebDriver driver){
        this.driver = driver;
    }

    public boolean esPopupVisible() {
        WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.popupModal));
        return popupElement.isDisplayed();
    }
    public String obtenerMensajeConfirmacion() {
        WebElement mensajeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.confirmacionElemetInput));
        return mensajeElement.getText();
    }
    public double obtenerMontoTotalPopup() {
        WebElement montoElement = driver.findElement(obtenermontoInput);
        String textoMonto = montoElement.getText().replace("S/", "").replace("$", "").replace("€", "").trim();
        return Double.parseDouble(textoMonto.replace(",", "."));
    }
    public void irACheckoutDesdePopup() {
      WebElement checkoutElement = wait.until(ExpectedConditions.elementToBeClickable(finalizarCompraButton));
        checkoutElement.click();
    }
}
