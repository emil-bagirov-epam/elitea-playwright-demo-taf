package com.elitea.tests.api;

import com.elitea.core.config.Config;
import com.elitea.core.config.ConfigLoader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseApiTest {
    protected static Config config;

    @BeforeAll
    static void beforeAll() {
        config = ConfigLoader.load();
        RestAssured.baseURI = config.getApiBaseUrl();
    }

    @BeforeEach
    void setUp() {
        RestAssured.requestSpecification = RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(config.getApiBaseUrl())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");
    }
}


