package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "//Users//gopinathbhargavvurakaranam//Documents//selenium//drivers//chromedriver");
	       WebDriver driver = new ChromeDriver();
	       driver.get("https://www.google.com/");
	       System.out.println(driver.getTitle());
	       //System.out.println(driver.getPageSource());
	       //driver.findElement(By.linkText(linkText))
	       driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
	       driver.findElement(By.id("menu1")).click();
	       List<WebElement> ls = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
	       for(WebElement w: ls)
	       {
	    	   
	    	   Thread.sleep(2000);
	    	   if(w.getText().contains("JavaScript"))
	    	   {
	    		   w.click();
	    	   Thread.sleep(5000);
	    	   break;
	    	   }
	    	   System.out.println(w.getText());
	       }
		driver.quit();

	}

}
