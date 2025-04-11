package com.juancff.greet_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetControllerShould {

    @LocalServerPort
    int port;

    @Test
    void returns_a_generic_welcome_message_when_user_name_is_not_specified() {
        given()
            .port(port)
        .when()
            .get("/greet")
        .then()
            .statusCode(200)
            .body(equalTo("¡Hola mundo!"));
    }

}
