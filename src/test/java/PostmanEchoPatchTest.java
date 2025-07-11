import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoPatchTest {

    @Test
    public void testPatchFormData() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParam("email", "test@example.com")
                .formParam("status", "active")
                .formParam("priority", "high")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("form.email", equalTo("test@example.com"))
                .body("form.status", equalTo("active"))
                .body("form.priority", equalTo("high"))
                .body("data", is(emptyOrNullString()))
                .body("args", anEmptyMap())
                .body("url", equalTo("https://postman-echo.com/patch"));
    }
}