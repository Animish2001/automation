package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        //If we want to use multiple feature files then we can use below
        //features = {"src/test/resources/features/login.feature", "src/test/resources/features/clauseLibrary.feature"},
        glue = "stepdefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@ai_feature" //Specify the tag of scenario which we want to run
        //tags = "@sanity" //Basic sanity suite
        //tags = "@regression" //Basic regression suites

)
public class TestRunner {
}