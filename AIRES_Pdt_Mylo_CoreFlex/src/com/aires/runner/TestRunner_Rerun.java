package com.aires.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt", plugin = {"pretty", "junit:target1/cucumber-results.xml", "html:target1/cucumber-results",
				"json:target1/cucumber-results.json"}, glue = { "stepDefinitions" })

public class TestRunner_Rerun {

}
