package com.nttdata.steps;

import com.nttdata.screens.SauceLabsLoginScreen;
import com.nttdata.screens.MiAppScreen;

/**
        * Caso de uso de login en la app movil de Sauce Labs.
        * Delega toda la interaccion de UI en {@link SauceLabsLoginScreen}.
        * No sabe nada de como se levanta o se cierra la app: eso lo maneja
 * {@link AppConfigSteps} / {@code AppConfigScreen}.
 */

public class MiAppSteps {

    private final MiAppScreen screen = new MiAppScreen();

    public void ingresarUsuario(String usuario) {
        System.out.println("[MiAppSteps] ingresarUsuario -> " + usuario);
        screen.escribirUsuario(usuario);
    }

    public void ingresarClave(String clave) {
        System.out.println("[MiAppSteps] ingresarClave");
        screen.escribirClave(clave);
    }

    public void clicEnLogin() {
        System.out.println("[MiAppSteps] clicEnLogin");
        screen.clicEnLogin();
    }

    public boolean loginFueExitoso() {
        System.out.println("[MiAppSteps] loginFueExitoso: validando resultado...");
        return screen.estaEnPantallaDeProductos();
    }
}


