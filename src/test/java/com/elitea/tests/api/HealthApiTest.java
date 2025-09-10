package com.elitea.tests.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class HealthApiTest extends BaseApiTest {

    @Test
    void healthEndpointResponds() {
        given()
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("url", notNullValue());
    }
}


