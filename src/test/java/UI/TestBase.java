package UI;

import API.Preconditions;
import API.User;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class TestBase extends Preconditions {
    User user = new User();
    Random random = new Random();
    static {
        Configuration.baseUrl = "http://167.172.110.35";
    }

//        public void addOwnerAndPets () {
//            user.setUsername("Sponge" + random);
//            user.setFirstName("Sponge");
//            user.setLastName("Bob");
//            user.setEmail("spongebob@meil.com");
//            user.setPassword("123456");
//            user = RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .body(user)
//                    .post("/register")
//                    .then()
//                    .statusCode(200)
//                    .extract().body()
//                    .as(User.class);
//    }
}
