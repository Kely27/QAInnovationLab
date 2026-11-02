package com.nttdata.steps;

import com.nttdata.page.LogueoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.esperaImplicita;

public class LogueoSteps {
    private WebDriver driver;
    //constructor

    public LogueoSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Hacer click en el botón login
     */

    public void clickLoginButton(){
        WebElement loginButtonElement = driver.findElement(LogueoPage.IniciarSesionInput);
        loginButtonElement.click();
    }

    /**
     * Escribir el usuario
     * @param email el usuario
     */
    public void typeUser(String email){
        WebElement userInputElement = driver.findElement(LogueoPage.usuarioInput);
        userInputElement.clear();
        userInputElement.sendKeys(email);

        //Espera implicita

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        //Espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogueoPage.iniciarButton));
    }

    /**
     * Escribir la contraseña
     * @param contraseña el password del usuario
     */
    public void typePassword(String contraseña){
        this.driver.findElement(LogueoPage.contraseñaInput).sendKeys(contraseña);
    }

    /**
     * Hacer click en el botón login
     */
    public void clickinicioSesion(){
        WebElement submitLoginElement = driver.findElement(LogueoPage.iniciarButton);
        submitLoginElement.click();
    }


    public void ingressCredencial(String email, String contraseña) {
        typeUser(email);
        typePassword(contraseña);
        esperaImplicita();
        clickinicioSesion();



    }
}


