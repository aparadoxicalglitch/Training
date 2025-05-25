package com.firstcry.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "./src/resources/features/FindStoreAndPreschool.feature",
		glue = {"com.firstcry.stepdefinitions", "com.firstcry.base"},
		plugin = { "pretty",
				"html:target/cucumber-reports"},
		monochrome = true,
		tags = "@regression"
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}