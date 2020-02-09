package UI;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductsPage extends TestBase{
    public ProductsPage goToCategories() {
        open("/category.html");
        return this;
    }
    public void nineItemsClick(){
        $(By.xpath("//*[@class=\"btn btn-default btn-sm\"][last()]")).click();
    }
    public String findSocks(){
        String socks = $(By.xpath("//*[text()='Nerd leg']")).getText();
        return socks;
    }
    public CartPage addToCart(){
        $(By.xpath("//*[@onclick=\"addToCart('a0a4f044-b040-410d-8ead-4de0446aec7e')\"]")).click();
        return new CartPage();
    }

}
