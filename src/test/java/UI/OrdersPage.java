package UI;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrdersPage {
    public OrdersPage openPage(){
        open("/customer-orders.html");
        return this;
    }
    public String title(){
        String title = $(By.cssSelector("h1")).getText();
        return title;
    }
    public String statusCheck(){
        String status = $(By.xpath("//*[@class=\"label label-success\"]")).getText();
        return status;
    }
}
