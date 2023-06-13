package br.com.chronosacademy.ecommerce.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@createNewAccount",
        glue = "br.com.chronosacademy.ecommerce.steps",
        plugin = {"json:target/reports/cucumberReportsEcommerce.json", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
