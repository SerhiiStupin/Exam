package Tests;

import API.Preconditions;
import API.User;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Random;

@Epic("SocksShop")
@Feature("API Registration")
public class Registration extends Preconditions{
    User user = new User();
    Random random = new Random();
    int name = random.nextInt();

    @Test(description = "Registration of the new user")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Registration of the new user")
    @TmsLink("index.html")
    @Issue("Bug-20")
    public void userRegistration(){
        user.setUsername("Sponge");
        user.setEmail(user.getUsername() + "@mail.com");
        user.setPassword("123456");
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/register")
                .then()
                .statusCode(200)
                .extract().body()
                .as(User.class);
    }

}
