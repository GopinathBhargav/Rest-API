package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
	
	public static String dir = System.getProperty("user.dir");
	ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void runbefore(Scenario scenario)
	{
		
		System.out.println("==========================before get method=================");
		 String testcase = scenario.getName();
		 System.out.println("Starting - " + testcase);
			String reportpath = dir + "/APIExtentreports/reports.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
			reporter.config().setDocumentTitle("rest Api results");
			reporter.config().setReportName("API test cases");
			 extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester","Gopi");
			 test =  extent.createTest(testcase);
		 
	}
	
	@After
	public void runafter(Scenario scenario) {
	    System.out.println("-------------after get method-----------------");
	    System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
	    String s = scenario.getStatus();
	    
	    if(s.equalsIgnoreCase("passed"))
	    {
	    test.log(Status.PASS, "test case passed");	
	    }
	   
	    extent.flush();
	    System.out.println("------------------------------");
	    
	}

}
