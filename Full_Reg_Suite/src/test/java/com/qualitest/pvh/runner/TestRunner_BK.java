package com.qualitest.pvh.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {
		        
		"src/test/resources/features/TestDemo_Module/Automationdemo.feature",
				
				},
		glue = {"com.qualitest.pvh.stepdefinitions","com.qualitest.pvh.hooks"}
		)
public class TestRunner_BK {}  