package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"//Users//gopinathbhargavvurakaranam//Documents//selenium//drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		// System.out.println(driver.getPageSource());
		// driver.findElement(By.linkText(linkText))
		driver.get("https://www.msn.com/en-in");
		String parenttitle = driver.getTitle();
		System.out.println("parent itle is --->" + driver.getTitle());
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@data-piitxt='facebooklite']")).click();
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator<String> it = windowhandle.iterator();
		while (it.hasNext()) {
			String child = it.next();

			if (!parent.equalsIgnoreCase(child)) {
				System.out.println("child window is" + driver.switchTo().window(child).getTitle());

				driver.close();
			}

		}

		driver.switchTo().window(parent);
		System.out.println("parent title is --->" + driver.getTitle());
		driver.quit();

	}

}
