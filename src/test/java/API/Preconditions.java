package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Preconditions {
    User user = new User();
    Random random = new Random();
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://167.172.110.35";
        RestAssured.port = 80;
        RestAssured.defaultParser = Parser.JSON;
    }
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
//    @Test
//    public void addOwnerAndPets() {
//        user.setUsername("Sponge"+ random);
//        user.setFirstName("Sponge");
//        user.setLastName("Bob");
//        user.setEmail("spongebob@meil.com");
//        user.setPassword("123456");
//        user = RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body(user)
//                .post("/register")
//                .then()
//                .statusCode(200)
//                .extract().body()
//                .as(User.class);
//    }
}
