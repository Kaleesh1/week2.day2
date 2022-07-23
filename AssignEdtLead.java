package week2.day2;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignEdtLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[3]/a")).click();
		driver.findElement(By.xpath("//label[@class='x-form-item-label']/following::input[3][@name='firstName']")).sendKeys("Baskar");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		for (int i=0;i<=3;i++) {
			try {
				driver.findElement(By.xpath("(//td[3][@tabindex='0']/div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).click();	
				break;
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		String title = driver.getTitle();
		System.out.println("Actual page title: " + title);
		String expTit = "View Lead | opentaps CRM";
		if (title.equals(expTit)) {
			System.out.println("Title " + title + " Verified successfully after selecting first result of find lead!!");
		}
		else {
			System.out.println("Actual title " + title + " and expected title "+expTit+"  mismatch!!");
		}
		driver.findElement(By.xpath("(//a[@class='subMenuButton'])[3]")).click();
		String bfchng = driver.findElement(By.id("updateLeadForm_companyName")).getAttribute("value");
		System.out.println("Before cmpName Upd: "+bfchng);
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Formula");
		String upddCmpNme = driver.findElement(By.id("updateLeadForm_companyName")).getAttribute("value");;
		System.out.println("After cmpName Upd: "+upddCmpNme);
		driver.findElement(By.xpath("//div[@class='fieldgroup-body']/table/tbody/tr[12]/td[2]/input")).click();
		String updcmpNme = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (updcmpNme.contains(upddCmpNme)) {
			System.out.println("Company name changed to " +upddCmpNme+ " successfully!!!");
		}
		else {
			System.out.println("Company name update failed!!!");  
		}
		driver.close();

	}

}
