package UI;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.security.PublicKey;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage extends TestBase{
    @Step("Opening NewOwners page")
    public CartPage openPage() {
        open("/basket.html");
        return this;
    }
    public String title(){
        String h1 = $(By.cssSelector("h1")).getText();
        return h1;
    }
    public String itemCheck(){
        String item = $(By.xpath("//*[text()='Nerd leg']")).getText();
        return item;
    }
    public String total(){
        String total = $(By.id("cartTotal")).getText();
        return total;
    }
    public void changeAddressClick(){
        $(By.xpath("//*[@data-target=\"#address-modal\"]")).click();
    }
    public void streetSet(String street){
        $(By.id("form-street")).setValue(street);
    }
    public void houseNumberSet(String number){
        $(By.id("form-number")).setValue(number);
    }
    public void citySet(String city){
        $(By.id("form-city")).setValue(city);
    }
    public void postSet(String post){
        $(By.id("form-post-code")).setValue(post);
    }
    public void countrySet(String country){
        $(By.id("form-country")).setValue(country);
    }
    public void addressUpdateClick(){
        $(By.xpath("//*[@onclick=\"return address()\"]")).click();
    }
    public void cardNumberSet(String card){
        $(By.id("form-card-number")).setValue(card);
    }
    public void expireSet(String expire){
        $(By.id("form-expires")).setValue(expire);
    }
    public void ccvSet(String ccv){
        $(By.id("form-ccv")).setValue(ccv);
    }
    public void paymentChange(){
        $(By.xpath("//*[@data-target=\"#card-modal\"]")).click();
    }
    public void paymentUpdateClick(){
        $(By.xpath("//*[@onclick=\"return card()\"]")).click();
    }
    public OrdersPage checkoutClick(){
        $(By.id("orderButton")).click();
        return new OrdersPage();
    }
}
