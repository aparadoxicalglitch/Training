package loginDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="./Features/LoginDemo.feature", 
		glue="loginDefinitions",
		monochrome = true
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}