package com.nttdata.page;

import org.openqa.selenium.By;

public class LogueoPage {

    //Localizadores de elementos

    public static By IniciarSesionInput = By.cssSelector("div.user-info a");
    public static By usuarioInput = By.id("field-email");
    public static By contraseñaInput = By.id("field-password");
    public static By iniciarButton = By.id("submit-login");


    public void login(String usuario, String clave) {
    }
}
