package com.example.apitests.context;

import com.example.apitests.utils.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {

    private Response response;

    // A fresh request each time, because RestAssured specs are mutable
    public RequestSpecification request() {
        return RestAssured.given()
                .baseUri(Config.get("api.baseUrl"))
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().ifValidationFails();
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}