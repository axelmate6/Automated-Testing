import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoPostFormDataTest {

    @Test
    public void testPostFormData() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParam("name", "John")
                .formParam("age", "30")
                .formParam("city", "New York")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.name", equalTo("John"))
                .body("form.age", equalTo("30"))
                .body("form.city", equalTo("New York"))
                .body("data", is(emptyOrNullString()))
                .body("args", anEmptyMap())
                .body("url", equalTo("https://postman-echo.com/post"));
    }
}