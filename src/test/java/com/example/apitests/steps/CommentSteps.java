package com.example.apitests.steps;

import com.example.apitests.context.TestContext;
import io.cucumber.java.en.When;

public class CommentSteps {

    private final TestContext context;

    public CommentSteps(TestContext context) {
        this.context = context;
    }

    @When("I request comments for post {int}")
    public void iRequestCommentsForPost(int postId) {
        context.setResponse(context.request().queryParam("postId", postId).get("/comments"));
    }
}
