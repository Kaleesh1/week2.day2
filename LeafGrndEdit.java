package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGrndEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.id("email")).sendKeys("123@abc.com");
		driver.findElement(By.xpath("(//label/following::input)[2]")).click();
		driver.findElement(By.xpath("(//label/following::input)[2]")).sendKeys("Appended");
		String deftext = driver.findElement(By.xpath("(//label/following::input)[3]")).getAttribute("value");
		System.out.println(deftext);
		driver.findElement(By.xpath("(//label/following::input)[4]")).clear();
		String disabled = driver.findElement(By.xpath("(//label/following::input)[5]")).getAttribute("disabled");
		String tr="true";
		if (disabled.equals(tr)) {
			System.out.println("Field is disabled");
		}else {
			System.out.println("Field is enabled");
		}
		driver.close();
		
		
	}

}
