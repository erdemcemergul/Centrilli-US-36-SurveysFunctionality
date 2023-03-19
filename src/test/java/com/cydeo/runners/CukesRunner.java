package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin= {
           //     "pretty",
                "json:target/cucumber.join",
                "html:target/cucumber-report.html",
                "junit:taget/junit/junit-report.xml",
                "rerun:target/rerun.txt",
            "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definition",
        dryRun=false,
        tags = "@surveys",
        publish = true

)
public class CukesRunner {
}
