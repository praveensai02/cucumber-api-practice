package com.example.apitests.steps;

import com.example.apitests.context.TestContext;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

    private final TestContext context;

    public CommonSteps(TestContext context) {
        this.context = context;
    }

    @Then("the response status code should be {int}")
    public void statusCodeShouldBe(int expected) {
        assertThat(context.getResponse().getStatusCode()).isEqualTo(expected);
    }

    @Then("the response field {string} should be {string}")
    public void fieldShouldBe(String path, String expected) {
        assertThat(context.getResponse().jsonPath().getString(path)).isEqualTo(expected);
    }

    @Then("the response should contain {int} items")
    public void shouldContainItems(int count) {
        assertThat(context.getResponse().jsonPath().getList("$")).hasSize(count);
    }

    @Then("the response header {string} should contain {string}")
    public void headerShouldContain(String name, String expected) {
        assertThat(context.getResponse().getHeader(name)).contains(expected);
    }
}