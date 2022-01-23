package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/JIRAIssues.feature",
				 glue = {"JIRAsteps","JIRAhooks"},
				 monochrome = true)

public class RunTest_JIRAIssue extends AbstractTestNGCucumberTests{

}

