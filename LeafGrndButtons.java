package week2.day2;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGrndButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("(//div[@class='row']//following::a)[2]")).click();
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("The location is:   "+location);
		String colour = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("The colour is:   "+colour);
		Dimension size = driver.findElement(By.id("size")).getSize();
		System.out.println("The size is:   "+size);
		driver.close();
	}

}
