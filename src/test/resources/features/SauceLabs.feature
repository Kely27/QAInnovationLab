# language: es
Característica: Inicio de sesion en Sauce Labs Sample App

  Como usuario de la app movil de Sauce Labs
  Quiero iniciar sesion con credenciales validas
  Para acceder al catalogo de productos

  @SauceLabsLogin @Smoke
  Escenario: Login exitoso con credenciales validas
    Dado ingreso al aplicativo "miApp"
    Cuando ingreso el usuario1 "bod@example.com"
    Y ingreso la clave1 "10203040"
    Y hago clic en boton login
    Entonces valido el login correctamente
    Y cierro el aplicativo "com.mi.paquete"
