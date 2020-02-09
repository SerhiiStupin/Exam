package Tests;

import API.Preconditions;
import API.User;
import UI.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UiTests extends TestBase {
    LoginPage loginPage = new LoginPage();
    User user = new User();
    Preconditions preconditions = new Preconditions();
    @BeforeClass()
    public void userRegistration(){
        preconditions.userCreation();
    }

    @Test (priority = 1)
    public void loginTest(){
        loginPage.openPage();
        loginPage.loginBtnClick();
        loginPage.usernameEnter(user.getUsername());
        loginPage.passwordEnter(user.getPassword());
        loginPage.loginClick();
        assertThat(loginPage.loggedIn()).isEqualTo("Logged in as");
    }
    @Test(priority = 2)
    public void addToCartTest(){
        ProductsPage productsPage = new ProductsPage();
        productsPage.goToCategories();
        productsPage.nineItemsClick();
        productsPage.findSocks();
        assertThat(productsPage.findSocks()).isEqualTo("Nerd leg");
        productsPage.addToCart();
    }
    @Test(priority = 3)
    public void cartCheck(){
        CartPage cartPage = new CartPage();
        cartPage.openPage();
        assertThat(cartPage.title()).isEqualTo("Shopping cart");
        assertThat(cartPage.itemCheck()).isEqualTo("Nerd leg");
        assertThat(cartPage.total()).isEqualTo("$7.99");
    }
    @Test(priority = 4)
    public void setUserData(){
        CartPage cartPage = new CartPage();
        cartPage.changeAddressClick();
        cartPage.houseNumberSet("12");
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
        cartPage.checkoutClick();
        OrdersPage ordersPage = new OrdersPage();
        ordersPage.openPage();
        assertThat(ordersPage.title()).isEqualTo("My orders");
        assertThat(ordersPage.statusCheck()).isEqualTo("Shipped");
    }

}
