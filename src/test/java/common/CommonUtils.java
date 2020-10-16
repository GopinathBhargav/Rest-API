package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import stepdefinitions.MongoDBConnections;
import stepdefinitions.StepDefinitions;

public class CommonUtils {
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static String dirpath = System.getProperty("user.dir");
	
	public final URL mymongourl = getClass().getClassLoader().getResource("config.properties");
	
	public static String baseurl() {
		String url = "";
		//public URL mymongourl = getClass().getClassLoader().getResource("config.properties");
		try {
			//FileInputStream fis = new FileInputStream(mymongourl.getFile());
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
	
	public static String readjsonbody(String path) throws Exception
	{
		Path p = Paths.get(path);
		return new String(Files.readAllBytes(p));
		
	}
	
	public static String getReportConfigPath()
	{
	
		
		String reportConfigPath = dirpath + "/src/test/java/resources/extent-config.xml";
		if(reportConfigPath!= null) 
			return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	public void checkurl() throws FileNotFoundException
	{
		Map<String,String> map = System.getenv();
		Set<Entry<String,String>> set  = map.entrySet();
		Iterator<Entry<String,String>> it = set.iterator();
		while(it.hasNext())
		{
			Entry<String,String> entry = it.next();
			
			System.out.println("key is : "+entry.getKey()+" AND "+"value is :"+ entry.getValue());
			
		}
		
		//System.out.println("mymongo url value is " + mymongourl);
		//fis = new FileInputStream(mymongourl.getFile());
		//System.out.println(fis);
	}

	public static void main(String args[]) throws FileNotFoundException
	{
		CommonUtils c = new CommonUtils();
		
		//System.out.println(baseurl());
		c.checkurl();
	}
}
