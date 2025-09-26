package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductsPage extends BasePage {

    private By productsHeader = By.xpath("//span[text()='Products']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsHeaderDisplayed() {
        waitForVisible(productsHeader, Duration.ofSeconds(3));
        return isDisplayed(productsHeader);
    }
}
