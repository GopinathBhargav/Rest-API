package runner;

import stepdefinitions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import features.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue="stepdefinitions",tags= {"@add"},format = {"pretty", "html:target/Destination"} )
public class TestRunner {
	
	@BeforeClass
	public static void runbeforeClass()
	{
		System.out.println("=====================Run once before class======================");
	}
	

	@AfterClass
	public static void runafterClass()
	{
		System.out.println("=====================Run once after class=======================");
	}

}
