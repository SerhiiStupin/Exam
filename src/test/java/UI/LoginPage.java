package UI;

import org.openqa.selenium.By;

import java.security.PublicKey;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends TestBase {
    public LoginPage openPage() {
        open("http://167.172.110.35/index.html");
        return this;
    }
    public void loginBtnClick(){
        $(By.id("login")).click();
    }
    public void usernameEnter(String username){
        $(By.id("username-modal")).setValue(username);
    }

    public void passwordEnter(String password){
        $(By.id("password-modal")).setValue(password);
    }
    public void loginClick(){
        $(By.xpath("//*[@onclick=\"return login()\"]")).click();
    }
    public String loggedIn(){
        return $(By.xpath("//*[text()='Logged in as  ']")).getText();
    }
//    public String logoutBtn(){
//        $(By.xpath("//*[@onclick=\"logout()\"]")).getText();
//        re
//    }
}
