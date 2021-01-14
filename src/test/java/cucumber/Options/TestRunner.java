package cucumber.Options;

import stepdefinitions.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

//import common.CommonUtils;

import features.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
features="src/test/java/features",
monochrome = true,
plugin = {"json:target/jsonReports/cucumber-report.json","rerun:target/failedtestcases.txt"
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
glue="stepdefinitions"
)
public class TestRunner {

	
	@BeforeClass
	public static void runbeforeClass()
	{
		System.out.println("===================== Run once before whole feature file ======================");
	}
	

	@AfterClass
	public static void runafterClass()
	{

		//Reporter.loadXMLConfig(new File(CommonUtils.getReportConfigPath()));
		
		System.out.println("===================== Run once after whole feature file =======================");
	}
	
	/*@CucumberOptions(
	features="src/test/java/features", glue="stepdefinitions",tags= {"@addplace"},
plugin= {"json:target/jsonreports/cucumberreports.json", 
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)*/

}
