import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoPutTest {

    @Test
    public void testPutWithJsonBody() {
        RestAssured.baseURI = "https://postman-echo.com";

        String jsonBody = "{ \"name\": \"Alice\", \"age\": 25 }";

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("Alice"))
                .body("json.age", equalTo(25))
                .body("url", equalTo("https://postman-echo.com/put"));
    }
}