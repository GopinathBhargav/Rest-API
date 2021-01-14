package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "//Users//gopinathbhargavvurakaranam//Documents//selenium//drivers//chromedriver");
	       WebDriver driver = new ChromeDriver();
	       
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       driver.get("https://www.google.com/");
	       System.out.println(driver.getTitle());
	       driver.get("https://www.spicejet.com/");
	       
	       
	       driver.findElement(By.xpath("//label[text()='Multicity']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//*[text()='Ok']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//*[text()=' Family and Friends']")).click();
	       Thread.sleep(1000);
	       
	       driver.findElement(By.xpath("//label[text()='One Way']")).click();
	       driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	      driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //*[text()=' Bagdogra (IXB)']")).click();
	      driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
	      driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //*[text()=' Mumbai (BOM)']")).click();
	      //driver.findElement(By.id("//*[@aria-controls='react-autowhatever-1']")).sendKeys("Hyd");
	      // driver.findElement(By.id("//*[@aria-controls='react-autowhatever-1']")).sendKeys(Keys.ARROW_DOWN);
	      driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
	      String text = driver.findElement(By.className("ui-datepicker-title")).getText();
	     
	      while(!driver.findElement(By.className("ui-datepicker-title")).getText().contains("October 2020"))
	      {
	    	  System.out.println(driver.findElement(By.className("ui-datepicker-title")).getText());
	    	  Thread.sleep(1000);
	    	  WebDriverWait wait = new WebDriverWait(driver, 3);
	    	  //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right'] //span[text()='Next']")));
	    	  driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right'] //span[text()='Next']")).click();
	    	// wait.until(ExpectedConditions.)
	      }
	      driver.findElement(By.xpath("//td[@data-month='9'] //*[text()='10']")).click();
	      
	      driver.findElement(By.xpath("//div[text()='1 Adult']")).click();
	      Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
	      s.selectByIndex(2);
	      Thread.sleep(2000);
	      s.selectByValue("5");
	      Thread.sleep(2000);
	      s.selectByVisibleText("8");
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//span[@class='btn-find-flight-home'] //input[@type='submit']")).click();
	     Thread.sleep(6000);
	      
	      driver.quit();
	      
	      //$x("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //*[text()=' Mumbai (BOM)']")
	       

	}

}
