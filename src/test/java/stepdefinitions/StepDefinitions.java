package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;

//import com.sun.tools.sjavac.Log;

import common.CommonUtils;

import static io.restassured.RestAssured.*;

import io.cucumber.java.Scenario;
/*import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;*/
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.Location;
import payloads.Pojo;
import payloads.TestData;

public class StepDefinitions {
	
	@Before
	public void beforeeverymethod()
	{
		System.out.println("************** before method *****************");
	}

	public static RequestSpecification rs;
	public static Response res;
	public JsonPath js; 
	public String body;
	public static Scenario step;
	public static String systempath = System.getProperty("user.dir");

	@Given("^the environment URL$")
	public void the_environment_URL() throws Throwable {

		RestAssured.baseURI = CommonUtils.baseurl();
		// prop.getProperty("mainurl");;

		RestAssured.urlEncodingEnabled = false;
		RestAssured.useRelaxedHTTPSValidation();
		
	}
	
	/*
	 * public void set() 
	 * { 
	 * RestAssured.given().auth().oauth2(accessToken); 
	 * }
	 */
	
	//Set<Entry<String, String>> set = arg1.entrySet();
	//Iterator<Entry<String, String>> it = set.iterator();
	//while (it.hasNext()) {	
	//	Entry<String, String> entry = it.next();
	//	String key = entry.getKey();
	//	String value = entry.getValue();
	//	rs = rs.header(key, value);}

	@When("^header values are passed$")
	public void header_values_are_passed(Map<String, String> arg1) throws Throwable {

		try {
			// to print output in text --> PrintStream log = new PrintStream(new FileOutputStream("outputlog.txt"));
			// to print log in output file --> rs = given().filter(new RequestLoggingFilter(log)).filter(new
			// ResponseLoggingFilter(log));
			
			rs = given().filter(new RequestLoggingFilter()).filter(new ResponseLoggingFilter());
			HashMap<String,Object> header = new HashMap<String,Object>();
			Set<Entry<String, String>> set = arg1.entrySet();
			Iterator<Entry<String, String>> it = set.iterator();
			while (it.hasNext()) {	
				
				Entry<String, String> entry = it.next();
			String key = entry.getKey();
				String value = entry.getValue();
				header.put(key, value);
			}
			rs.headers(header);
		} catch (Exception e) {
			step.write("exception occured:" + e.toString());
		}
	}

	@When("^query parameters are passed$")
	public void queryParamValues(Map<String, String> queryvalues) throws Throwable {
		try {
			Iterator<Entry<String, String>> it = queryvalues.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> entry = it.next();
				String key = entry.getKey();
				String value = entry.getValue();
				if (value.contains("ENV-")) {
					String placevalue = (value.split("ENV-"))[1];
					rs = rs.queryParam(key, System.getProperty(placevalue));
				
				} else {
					rs = rs.queryParam(key, value);
				}
			}
		} catch (Exception e) {
			step.write("exception occured:" + e.toString());
		}
	}

	@When("^payload is passed with the expected values$")
	public void payload_is_passed_with_the_expected_values() throws Throwable {

		
		 try { 
			 rs = rs.body(TestData.addplace()); 
			 // rs =rs.body(TestData.addplace());
		 } 
		 catch (Exception e) 
		 { 
			 step.write("exception occured:" + e.toString());
		 }
		 
	}
	
	@When("payload is passed with the expected values along with json file {string}")
	public void payload_is_passed_with_the_expected_values_along_with_json_file(String jsonpath, Map<String, String> body) throws Exception {
	     // Write code here that turns the phrase above into concrete actions
	   String expectedresponse = "";
	  expectedresponse = CommonUtils.readjsonbody(systempath+"/src/test/java/resources/"+jsonpath+".json");
	  Iterator<Entry<String,String>> it = body.entrySet().iterator();
	  while(it.hasNext())
	{
		  Entry<String,String> entry = it.next();
		  String key = entry.getKey();
		  String value = entry.getValue();
		  if (expectedresponse.contains("%"+key))			  
		  {
			expectedresponse = expectedresponse.replace("%"+key, value);
		}
	  }
	  
	  rs=rs.body(expectedresponse);
	  
	   
	}
	
	

	@When("^pass the \"([^\"]*)\" resource name$")
	public void pass_the_resource_name(String postresource) throws Throwable {
		try {
			res = rs.when().post(CommonUtils.resourceUrl(postresource));
		} catch (Exception e) {
			step.write("exception occured:" + e.toString());
		}
	}
	
	@When("^pass the \"([^\"]*)\" resource name passed$")
	public void getresource_name(String getresource) throws Throwable {
		try {
			res = rs.when().get(CommonUtils.resourceUrl(getresource));
		} catch (Exception e) {
			step.write("exception occured:" + e.toString());
		}
	}

	@Then("^validate the status as \"([^\"]*)\"$")
	public void validate_the_status_as(String arg1) throws Throwable {
		try {
			
			int status = res.getStatusCode();
			int arg = Integer.parseInt(arg1);
			if (status == arg) {
				res = res.then().assertThat().statusCode(arg).extract().response();
			} else {
				// Log.info("status is not as expected value"+status);
				
				assertEquals(status, arg);
			}
		} catch (Exception e) {
			step.write("exception occured:" + e.toString());
		}
	}

	@Then("^retrieve the \"([^\"]*)\" value$")
	public void retrieve_the_value(String arg1) throws Throwable {
		try {
			body = res.getBody().asString();
			JSONParser parser = new JSONParser(); 
			JSONObject json = (JSONObject) parser.parse(body); 
			System.out.println("json value is" +json);
			js = new JsonPath(body);
			String placeid = js.get(arg1);
			System.out.println("place id is" + placeid);
		//System.setProperty(key, value)
			System.setProperty("place_name", placeid);
		} catch (Exception e) {

			step.write("exception occured:" + e.toString());
		}
	}
	
	@Then("^verify name in post and get are same$")
	public void verify_name_in_post_and_get_are_same() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	String getname = TestData.p.getName(); 
		assertEquals(getname.toString(), "bhargav");
		
	   
	}


}
