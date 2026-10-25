package com.example.apitests.steps;

import com.example.apitests.context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.Map;

public class PostSteps {

    private final TestContext context;

    public PostSteps(TestContext context) {
        this.context = context;
    }

    @When("I request all posts")
    public void iRequestAllPosts() {
        context.setResponse(context.request().get("/posts"));
    }

    @When("I request the post with id {int}")
    public void iRequestThePostWithId(int id) {
        context.setResponse(context.request().get("/posts/{id}", id));
    }

    @When("I request posts for user {int}")
    public void iRequestPostsForUser(int userId) {
        context.setResponse(context.request().queryParam("userId", userId).get("/posts"));
    }

    @When("I create a post with:")
    public void iCreateAPostWith(DataTable table) {
        Map<String, String> body = table.asMap(String.class, String.class);
        context.setResponse(context.request().body(body).post("/posts"));
    }

    @When("I update post {int} with title {string}")
    public void iUpdatePost(int id, String title) {
        Map<String, Object> body = Map.of("title", title);
        context.setResponse(context.request().body(body).put("/posts/{id}", id));
    }

    @When("I delete post {int}")
    public void iDeletePost(int id) {
        context.setResponse(context.request().delete("/posts/{id}", id));
    }
}