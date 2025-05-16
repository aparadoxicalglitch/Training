package awesomeqaTest;

import org.testng.annotations.Test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/awesomeqaTest/awesomeqa.feature",
	    glue = "awesomeqaTest",                                 
	    tags = "@tag1 or @tag2"
	)

public class runner extends AbstractTestNGCucumberTests{

}