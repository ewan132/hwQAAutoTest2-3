import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class PostmanEchoTest {

    @Test
    void shouldReturnJSON() {
        // Given - When - Then
        given()
                .baseUri("https://postman-echo.com")
                .body("Ouch")
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Ouch"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}
