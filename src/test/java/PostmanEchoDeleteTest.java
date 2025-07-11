import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoDeleteTest {

    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .queryParam("param1", "value1")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.param1", equalTo("value1"))
                .body("url", equalTo("https://postman-echo.com/delete?param1=value1"));
    }
}