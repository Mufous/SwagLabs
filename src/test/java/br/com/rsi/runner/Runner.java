package br.com.rsi.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "br.com.rsi.steps", //
		features = "classpath:features", //
		tags = "@google", //
		plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json" }, //
		monochrome = true)
public class Runner {

}
