package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoPage {
    public static By primerElementInput = By.cssSelector(".product-miniature:first-child img");
    public static By elementCantidadInput = By.id("quantity_wanted");
    public static By agregarButton = By.cssSelector(".add-to-cart");
}
