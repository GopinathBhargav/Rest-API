package selenium;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumJavaCode {
	
	public static String dir = System.getProperty("user.dir");

	public static void main(String[] args) throws Exception {
		// Desired Capabilities

		/*
		 * DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		 * dc.setCapability(InternetExplorerDriver.
		 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		 * dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 * System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
		 * WebDriver driver = new ChromeDriver(dc);
		 */
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//ChromeOptions c = new ChromeOptions();
		//c.merge(capabilities);
		
		
		System.setProperty("webdriver.chrome.driver",
				"//Users//gopinathbhargavvurakaranam//Documents//selenium//drivers//chromedriver");
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		// System.out.println(driver.getPageSource());
		// driver.findElement(By.linkText(linkText))
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// below one is css direct xpath
		driver.findElement(By.cssSelector("input[class='inputs ui-autocomplete-input']")).sendKeys("VGB");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[class='inputs ui-autocomplete-input']")).clear();

		// parent-child xpath
		driver.findElement(By.xpath("//div[@class='cen-left-align'] //*[@class='inputs ui-autocomplete-input']"))
				.sendKeys("ABC");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[class='inputs ui-autocomplete-input']")).clear();

		// below is following-sibling xpath
		driver.findElement(By.xpath(
				"//*[text()='Suggession Class Example']/following-sibling::input[@class='inputs ui-autocomplete-input']"))
				.sendKeys("VGB");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[class='inputs ui-autocomplete-input']")).clear();

		System.out.println(driver.findElement(By.xpath("//*[@id='checkBoxOption1']")).isSelected());

		// check box
		driver.findElement(By.xpath("//*[@id='checkBoxOption1']")).click();
		// web tables
		WebElement element = driver.findElement(By.name("courses"));
		List<WebElement> list = element.findElements(By.tagName("tr"));
		int rowscount = list.size();
		System.out.println("rowscount is --->" + rowscount);

		for (WebElement w : list) {
			System.out.println(w.getText());
		}

		List<WebElement> tdlist = element.findElements(By.xpath("//*[@name='courses']/tbody/tr/td"));

		for (WebElement column : tdlist) {
			if (column.getText().equalsIgnoreCase("WebServices / REST API Testing with SoapUI")) {
				System.out.println("particular column value is ---> " + column.getText());
				break;
			}
		}
		
		// frames
		System.out.println("frames count is -----> "+driver.findElements(By.tagName("iframe")).size());
		 driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
		 
		 
		System.out.println(driver.findElement(By.cssSelector("[class='theme-btn register-btn']")).getText());
		Thread.sleep(2000);
     	driver.switchTo().defaultContent();
     	// screenshot code
		TakesScreenshot scrshot = ((TakesScreenshot)driver);
		File src = scrshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(dir+"/src/test/java/snapshots/snapshot.jpg");
		FileUtils.copyFile(src, dest);
		
		driver.findElement(By.xpath("//*[@id='checkBoxOption1']")).click();
		Thread.sleep(4000);
		driver.quit();
	}

}
