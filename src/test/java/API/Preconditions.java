package API;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;

import java.util.Random;

public class Preconditions{
    Random random = new Random();
    int name = random.nextInt();
    static {
        //Configuration.baseUrl = "http://167.172.110.35";
        Configuration.baseUrl = "http://localhost";
    }
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        //RestAssured.baseURI = "http://167.172.110.35";
        RestAssured.port = 80;
        RestAssured.defaultParser = Parser.JSON;
    }
    public User userCreation() {
        User user = new User();
        user.setUsername("Test" + name);
        user.setEmail(user.getUsername() + "@mail.com");
        user.setPassword("123456");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/register")
                .then()
                .statusCode(200)
                .extract().body()
                .as(User.class);
    }
}
