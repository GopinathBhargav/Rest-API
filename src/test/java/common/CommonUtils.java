package common;

import java.io.FileInputStream;
import java.util.Properties;

import stepdefinitions.StepDefinitions;

public class CommonUtils {
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static String dirpath = System.getProperty("user.dir");

	public static String baseurl() {
		String url = "";
		try {
			fis = new FileInputStream(dirpath + "/src/test/java/resources/config.properties");
			prop.load(fis);
			url = prop.getProperty("testURL");
		} catch (Exception e) {
			StepDefinitions.step.write("exception occured:" + e.toString());
		}
		return url;
	}

	public static String resourceUrl(String resource) {

		String resourceurl = "";

		try {

			fis = new FileInputStream(dirpath + "/src/test/java/resources/resource.properties");
			prop.load(fis);
			resourceurl = prop.getProperty(resource);

		} catch (Exception e) {
			StepDefinitions.step.write("exception occured:" + e.toString());
		}
		return resourceurl;
	}

}
