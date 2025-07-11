import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoPostRawTextTest {

    @Test
    public void verifyRawTextResponseFields() {
        RestAssured.baseURI = "https://postman-echo.com";
        String rawText = "Text";
        given()
                .header("Content-Type", "text/plain")
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawText))
                .body("json", nullValue())
                .body("args", anEmptyMap())
                .body("url", equalTo("https://postman-echo.com/post"));
    }
}