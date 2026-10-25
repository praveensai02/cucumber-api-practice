package com.example.apitests.steps;

import com.example.apitests.context.TestContext;
import io.cucumber.java.en.When;

public class UserSteps {

    private final TestContext context;

    public UserSteps(TestContext context) {
        this.context = context;
    }

    @When("I request the user with id {int}")
    public void iRequestTheUserWithId(int id) {
        context.setResponse(context.request().get("/users/{id}", id));
    }
}