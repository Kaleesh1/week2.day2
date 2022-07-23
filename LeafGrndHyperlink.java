package week2.day2;

import java.time.Duration;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGrndHyperlink {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Go to Home Page")).click();
		String title = driver.getTitle();
		String actTit="TestLeaf - Selenium Playground";
		//System.out.println(title);
		if(title.equals(actTit)) {
			System.out.println("In Home page");
		}else {
			System.out.println("Not In Home page");
		}
		driver.get("http://leafground.com/pages/Link.html");
		String attribute = driver.findElement(By.partialLinkText("Find where")).getAttribute("href");
		System.out.println(attribute);
		driver.findElement(By.partialLinkText("Verify am")).click();
		String title2 = driver.getTitle();
		String brokenPage = "404 Not Found";
		if(title2.equals(brokenPage)) {
			System.out.println("Broken Page");
		}else {
			System.out.println("Not Broken Page");
		}
		
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a")).click();
		driver.get("http://leafground.com/pages/Link.html");
		List<WebElement> noOfLink = driver.findElements(By.tagName("a"));
		System.out.println("No of links in this page is: " + noOfLink.size());
		driver.close();
	}
}
