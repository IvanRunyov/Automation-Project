package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:resources",
        glue = {"stepDefinition", "hooks", "org.example"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"}
)
public class RunCucumberTest {
}