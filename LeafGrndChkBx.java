package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGrndChkBx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.findElement(By.xpath("(//label/following::input[1])[1]")).click();
		driver.findElement(By.xpath("(//label/following::input[3])[1]")).click();
		boolean selected = driver.findElement(By.xpath("(//label/following::input[1])[2]")).isSelected();
		System.out.println("CheckBox Selected is " + selected);
		boolean selected2 = driver.findElement(By.xpath("(//label/following::input[1])[3]")).isSelected();
		boolean selected3 = driver.findElement(By.xpath("(//label/following::input[2])[3]")).isSelected();
		if (selected2 == true) {
			driver.findElement(By.xpath("(//label/following::input[1])[3]")).click();
		}else if (selected3 == true){
			driver.findElement(By.xpath("(//label/following::input[2])[3]")).click();
		}
		driver.findElement(By.xpath("(//label/following::input[1])[4]")).click();
		driver.findElement(By.xpath("(//label/following::input[2])[4]")).click();
		driver.findElement(By.xpath("(//label/following::input[3])[4]")).click();
		driver.findElement(By.xpath("(//label/following::input[4])[4]")).click();
		driver.findElement(By.xpath("(//label/following::input[5])[4]")).click();
		driver.findElement(By.xpath("(//label/following::input[6])[4]")).click();
	}

}
