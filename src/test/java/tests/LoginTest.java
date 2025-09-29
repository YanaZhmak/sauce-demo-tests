package tests;

import base.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {
        ProductsPage productsPage = loginPage.loginAs("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header must be displayed");
    }

    @Test
    public void loginWithLockedOutUser() {
        loginPage.loginAs("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Sorry, this user has been locked out."), "Error message must contain 'Sorry, this user has been locked out.'");
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.loginAs("standard_user", "123");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match any user in this service"), "Error message must contain 'Username and password do not match any user in this service'");
    }

    @Test
    public void loginWithEmptyFields() {
        loginPage.loginAs("", "");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"), "Error message must contain 'Username is required'");
    }
}
