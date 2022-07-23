package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGrndImg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.findElement(By.xpath("(//label[contains(text(),'Click on this image')]/following::img)[1]")).click();
		driver.get("http://leafground.com/pages/Image.html");
		String attribute = driver.findElement(By.xpath("(//label[contains(text(),'Am I Broken')]/following::img)[1]")).getAttribute("src");
		driver.get(attribute);
		String title = driver.getTitle();
		if (title.contains("404")) {
			System.out.println("image is broken");
		}else {
			System.out.println("image is not broken");
		}
		driver.get("http://leafground.com/pages/Image.html");
		WebElement findElement = driver.findElement(By.xpath("(//label[contains(text(),'Click me using Keybo')]/following::img)[1]"));
		Actions mou = new Actions(driver);
		mou.click(findElement).build().perform();
	}

}
