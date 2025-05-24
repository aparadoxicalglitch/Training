package com.firstcry.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"./src/resources/features/InvalidFirstCryFlow.feature",
				"./src/resources/features/ValidFirstCryFlow.feature"},
		glue = {"com.firstcry.stepdefinitions", "com.firstcry.base"},
		plugin = {
				"pretty",
				"html:target/cucumber-reports"},
		monochrome = true,
		tags = "@valid"
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}