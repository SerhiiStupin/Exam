package UI;

import API.Preconditions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage extends Preconditions {
    @Step("Opening cart page")
    public CartPage openPage() {
        open("/basket.html");
        return this;
    }
    @Step("Getting pageTitle")
    public String title(){
        String h1 = $(By.cssSelector("h1")).getText();
        return h1;
    }
    @Step("ItemName check")
    public String itemCheck(){
        String item = $(By.xpath("//*[text()='Nerd leg']")).getText();
        return item;
    }
    @Step("Checking total sum in the cart")
    public String total(){
        String total = $(By.id("cartTotal")).getText();
        return total;
    }
    @Step("Click on the Change Address Button")
    public void changeAddressClick(){
        $(By.xpath("//*[@data-target=\"#address-modal\"]")).click();
    }
    @Step("Setting the street")
    public void streetSet(String street){
        $(By.id("form-street")).setValue(street);
    }
    @Step("Setting the houseNumber")
    public void houseNumberSet(String number){
        $(By.id("form-number")).setValue(number);
    }
    @Step("Setting the city")
    public void citySet(String city){
        $(By.id("form-city")).setValue(city);
    }
    @Step("Setting the post code")
    public void postSet(String post){
        $(By.id("form-post-code")).setValue(post);
    }
    @Step("Setting the country")
    public void countrySet(String country){
        $(By.id("form-country")).setValue(country);
    }
    @Step("Saving of entered data")
    public void addressUpdateClick(){
        $(By.xpath("//*[@onclick=\"return address()\"]")).click();
    }
    @Step("Setting the card number")
    public void cardNumberSet(String card){
        $(By.id("form-card-number")).setValue(card);
    }
    @Step("Setting the expiration date")
    public void expireSet(String expire){
        $(By.id("form-expires")).setValue(expire);
    }
    @Step("Setting the CVV code")
    public void ccvSet(String ccv){
        $(By.id("form-ccv")).setValue(ccv);
    }
    @Step("Change payment data button click")
    public void paymentChange(){
        $(By.xpath("//*[@data-target=\"#card-modal\"]")).click();
    }
    @Step("Uodating payment data")
    public void paymentUpdateClick(){
        $(By.xpath("//*[@onclick=\"return card()\"]")).click();
    }
    @Step("Checkout proceed")
    public OrdersPage checkoutClick(){
        $(By.id("orderButton")).click();
        return new OrdersPage();
    }
}
