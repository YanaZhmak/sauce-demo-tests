package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField,password);
    }

    public ProductsPage goToProductsPage() {
        click(loginButton);
        return new ProductsPage(driver);
    }

    public ProductsPage loginAs(String username, String password) {
        setUsername(username);
        setPassword(password);
        return goToProductsPage();
    }

}
