package com.example.apitests.hooks;

import com.example.apitests.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("START: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (context.getResponse() != null) {
            scenario.attach(context.getResponse().asPrettyString(),
                    "application/json", "Last API response");
        }
        System.out.println("END: " + scenario.getName() + " -> " + scenario.getStatus());
    }
}