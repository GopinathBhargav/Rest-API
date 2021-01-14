package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"//Users//gopinathbhargavvurakaranam//Documents//selenium//drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		// System.out.println(driver.getPageSource());
		// driver.findElement(By.linkText(linkText))
		driver.get("https://www.amazon.ae/");

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[text()='Hello, Sign in']"))).build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("//*[text()='Hello, Sign in']"))).contextClick().build().perform();
		Thread.sleep(2000);
		a.click(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))).keyDown(Keys.SHIFT).sendKeys("Vvgb")
				.build().perform();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).clear();
		a.keyDown(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")), Keys.LEFT_SHIFT).sendKeys("myNAME")
				.keyUp(Keys.LEFT_SHIFT).sendKeys("vgbh").build().perform();
		Thread.sleep(2000);

		// a.contextClick(driver.findElement(By.xpath("//*[text()='Hello, Sign
		// in']"))).build().perform();
		Thread.sleep(2000);
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		Thread.sleep(2000);
		a.dragAndDrop(driver.findElement(By.xpath("//*[text()='Draggable 3']")),
				driver.findElement(By.xpath("//*[@dropzone='move']"))).build().perform();
		Thread.sleep(2000);

		driver.quit();
	}

}
