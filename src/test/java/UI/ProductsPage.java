package UI;

import API.Preconditions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductsPage extends Preconditions {
    @Step("Openin categories page")
    public ProductsPage goToCategories() {
        open("/category.html");
        return this;
    }
    @Step("Opening all items on the page")
    public void nineItemsClick(){
        $(By.xpath("//*[@class=\"btn btn-default btn-sm\"][last()]")).click();
    }
    @Step("Finding the item")
    public String findSocks(){
        String socks = $(By.xpath("//*[text()='Nerd leg']")).getText();
        return socks;
    }
    @Step("Adding to the cart")
    public CartPage addToCart(){
        $(By.xpath("//*[@onclick=\"addToCart('a0a4f044-b040-410d-8ead-4de0446aec7e')\"]")).click();
        return new CartPage();
    }

}
