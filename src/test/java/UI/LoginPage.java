package UI;

import API.Preconditions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class LoginPage extends Preconditions {
    @Step("Checking the current URL")
    public void assertUrl(String url){
        String currentUrl = url();
        assertEquals(currentUrl, url);
    }
    @Step("Opening home page")
    public LoginPage openPage() {
        open("/index.html");
        return this;
    }
    @Step("Login click")
    public void loginBtnClick(){
        $(By.id("login")).click();
    }
    @Step("Entering the username")
    public void usernameEnter(String username){
        $(By.id("username-modal")).setValue(username);
    }
    @Step("Entering the password")
    public void passwordEnter(String password){
        $(By.id("password-modal")).setValue(password);
    }
    @Step("Login button click")
    public void loginClick(){
        $(By.xpath("//*[@onclick=\"return login()\"]")).click();
    }
    @Step("Checking the user is logged in")
    public String loggedIn(){
        return $(By.xpath("//*[text()='Logged in as  ']")).getText();
    }
//    public String logoutBtn(){
//        $(By.xpath("//*[@onclick=\"logout()\"]")).getText();
//        re
//    }
}
