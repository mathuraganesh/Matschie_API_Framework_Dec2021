package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/CreateAndUpdateIncident.feature",
				 glue = {"steps","hooks"},
				 monochrome = true)

public class RunTest_CreateandUpdate extends AbstractTestNGCucumberTests{

}

