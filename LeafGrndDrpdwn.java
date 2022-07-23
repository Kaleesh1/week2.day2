package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGrndDrpdwn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		WebElement drpd1 = driver.findElement(By.id("dropdown1"));
		Select sel1 = new Select(drpd1);
		sel1.selectByIndex(1);
		
		WebElement drpd2 = driver.findElement(By.name("dropdown2"));
		Select sel2 = new Select(drpd2);
		sel2.selectByVisibleText("Appium");
		
		WebElement drpd3 = driver.findElement(By.id("dropdown3"));
		Select sel3 = new Select(drpd3);
		sel3.selectByValue("3");
		
		WebElement drpd4 = driver.findElement(By.xpath("//div[4]/select"));
		String text = drpd4.getText();
		System.out.println("Options in dropdown are: " + text);
		
		WebElement noOf = driver.findElement(By.xpath("//div[4]/select"));	
		List<WebElement> totalOpts = noOf.findElements(By.tagName("option"));
		int size = totalOpts.size();
		System.out.println("No. of options is: " + size);
		
		driver.findElement(By.xpath("//div[5]/select")).sendKeys("Loadrunner");
		
		WebElement drpd6 = driver.findElement(By.xpath("//div[6]/select"));
		Select sel6 = new Select(drpd6);
		sel6.selectByValue("3");
		
		}

}
