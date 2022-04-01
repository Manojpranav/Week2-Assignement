package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException 
	{
WebDriverManager.chromedriver().setup();
		
		ChromeDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.get("http://leaftaps.com/opentaps/control/login");
		drv.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demosalesmanager");
		drv.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		drv.findElement(By.className("decorativeSubmit")).click();
		drv.findElement(By.linkText("CRM/SFA")).click();
		drv.findElement(By.linkText("Leads")).click();
		drv.findElement(By.linkText("Create Lead")).click();
		drv.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		drv.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Selenium Testing");
		drv.findElement(By.id("createLeadForm_firstName")).sendKeys("Manoj");
		drv.findElement(By.id("createLeadForm_lastName")).sendKeys("J");
		drv.findElement(By.id("createLeadForm_departmentName")).sendKeys("Automation Testing");
		drv.findElement(By.id("createLeadForm_description")).sendKeys("Selenium Testing");
		drv.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("manoj@gmail.com");
		drv.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9955995599");
		
		WebElement country = drv.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select drop = new Select(country);
		drop.selectByValue("IND");
		
		drv.findElement(By.name("submitButton")).click();
		System.out.println(drv.getTitle());
		
		drv.findElement(By.linkText("Delete")).click();
		drv.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(100);
drv.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		drv.findElement(By.xpath("//input[@name='id']")).sendKeys("10500");
		
		drv.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
				
		String title = drv.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		
		if (title.contains("No records to display")) {
			System.out.println("Lead Deleted");
		}
		else {
			System.out.println("Lead not deleted");
		}
		drv.close();

	}

}
