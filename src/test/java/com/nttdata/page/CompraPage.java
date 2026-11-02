package com.nttdata.page;

import org.openqa.selenium.By;

public class CompraPage {

    public static By popupModal = By.id("blockcart-modal");
    public static By confirmacionElemetInput = By.cssSelector("modal-title h6 text-sm-center");
    public static By obtenermontoInput = By.cssSelector(".product-total .value");
    public static By finalizarCompraButton = By.cssSelector(".cart-content-btn a.btn-primary");
}
