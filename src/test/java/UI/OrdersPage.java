package UI;

import API.Preconditions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrdersPage extends Preconditions{
    @Step("Opening orders page")
    public OrdersPage openPage(){
        open("/customer-orders.html");
        return this;
    }
    @Step("Getting the page title")
    public String title(){
        String title = $(By.cssSelector("h1")).getText();
        return title;
    }
    @Step("Checking the status of shipping")
    public String statusCheck(){
        String status = $(By.xpath("//*[@class=\"label label-success\"]")).getText();
        return status;
    }
    @Step("Logout button click")
    public LoginPage logoutBtnClick(){
        $(By.xpath("//*[@onclick=\"logout()\"]")).click();
        return new LoginPage();
    }
}
