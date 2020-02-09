package Tests;

import API.Preconditions;
import UI.*;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("SocksShop")
@Feature("UI Tests")
public class UiTests extends Preconditions{
    @BeforeClass()
    public void userRegistration(){
        userCreation();
    }

    @Test (priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Sign in process")
    @TmsLink("index.html")
    @Issue("Bug-1")
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.loginBtnClick();
        loginPage.usernameEnter("Sponge");
        loginPage.passwordEnter("123456");
        loginPage.loginClick();
        assertThat(loginPage.loggedIn()).isEqualTo("Logged in as");
    }
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Adding the item to cart")
    @TmsLink("category.html")
    @Issue("Bug-2")
    public void addToCartTest(){
        ProductsPage productsPage = new ProductsPage();
        productsPage.goToCategories();
        productsPage.nineItemsClick();
        productsPage.findSocks();
        assertThat(productsPage.findSocks()).isEqualTo("Nerd leg");
        productsPage.addToCart();
    }
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Checking the item in the cart")
    @TmsLink("basket.html")
    @Issue("Bug-3")
    public void cartCheck(){
        CartPage cartPage = new CartPage();
        cartPage.openPage();
        assertThat(cartPage.title()).isEqualTo("Shopping cart");
        assertThat(cartPage.itemCheck()).isEqualTo("Nerd leg");
        assertThat(cartPage.total()).isEqualTo("$7.99");
    }
    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Checkout process generation")
    @TmsLink("basket.html")
    @Issue("Bug-4")
    public void setUserPaymentDataandCheckout(){
        CartPage cartPage = new CartPage();
        cartPage.openPage();
        cartPage.changeAddressClick();
        cartPage.houseNumberSet("155");
        cartPage.streetSet("Gagarina");
        cartPage.citySet("Dnipro");
        cartPage.postSet("90210");
        cartPage.countrySet("Ukraine");
        cartPage.addressUpdateClick();
        cartPage.paymentChange();
        cartPage.cardNumberSet("1234567890123456");
        cartPage.expireSet("12/12");
        cartPage.ccvSet("123");
        cartPage.paymentUpdateClick();
        OrdersPage ordersPage = cartPage.checkoutClick();
        ordersPage.openPage();
        assertThat(ordersPage.title()).isEqualTo("My orders");
        assertThat(ordersPage.statusCheck()).isEqualTo("Shipped");
    }
    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Story("Sign out")
    @TmsLink("basket.html")
    @Issue("Bug-5")
    public void signOutTest(){
        OrdersPage ordersPage = new OrdersPage();
        LoginPage loginPage = ordersPage.logoutBtnClick();
        loginPage.assertUrl(url());
    }
}
