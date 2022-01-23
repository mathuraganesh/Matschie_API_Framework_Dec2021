package salesForce_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/salesForce_Features/Contact.feature",
				 glue = {"salesForce_steps","salesForce_hooks"},
				 monochrome = true)

public class RunTest extends AbstractTestNGCucumberTests{

}

