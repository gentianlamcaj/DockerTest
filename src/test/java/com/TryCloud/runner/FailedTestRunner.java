package com.TryCloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "@target/rerun.text",
            glue = "com/cydeo/step_definition"
    )
    public class FailedTestRunner {



}
