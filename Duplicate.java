package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Duplicate {

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
		
		
		drv.findElement(By.linkText("Duplicate Lead")).click();
		drv.findElement(By.id("createLeadForm_companyName")).clear();
		drv.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf Chennai");
		drv.findElement(By.name("submitButton")).click();
		Thread.sleep(3);
		String Title = drv.getTitle();
		System.out.println("The Title is "+ Title);
		//drv.close();
		

	}

}
