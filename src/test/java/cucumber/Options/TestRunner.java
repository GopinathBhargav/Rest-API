package cucumber.Options;

import stepdefinitions.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import common.CommonUtils;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import features.*;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue="stepdefinitions",tags= {"@addplace"},format = {"pretty", "html:target/Destination"},
plugin="json:target/jsonreports/cucumberreports.json" )
//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"

public class TestRunner {
	
	@BeforeClass
	public static void runbeforeClass()
	{
		System.out.println("=====================Run once before class======================");
	}
	

	@AfterClass
	public static void runafterClass()
	{

		//Reporter.loadXMLConfig(new File(CommonUtils.getReportConfigPath()));
		
		System.out.println("=====================Run once after class=======================");
	}
	
	

}
