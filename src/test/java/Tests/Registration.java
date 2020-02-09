package Tests;

import API.Preconditions;
import API.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Random;

public class Registration extends Preconditions{
    User user = new User();
    Random random = new Random();

    @Test
    public void userCreation() {
        user.setUsername("Test"+random);
        user.setEmail(user.getUsername() + "@mail.com");
        user.setPassword("1234567");
        user = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/register")
                .then()
                .statusCode(200)
                .extract().body()
                .as(User.class);
    }
}
