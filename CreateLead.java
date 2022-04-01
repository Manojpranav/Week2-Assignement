package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead 
{
public static void main(String[] args) 
{
	WebDriverManager.chromedriver().setup();
     ChromeDriver drv = new ChromeDriver();
	drv.manage().window().maximize();
	drv.get("http://leaftaps.com/opentaps/control/login");
	drv.manage().window().maximize();
	drv.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demosalesmanager");
	drv.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
	drv.findElement(By.className("decorativeSubmit")).click();
	drv.findElement(By.linkText("CRM/SFA")).click();
	drv.findElement(By.linkText("Contacts")).click();
	drv.findElement(By.linkText("Create Contact")).click();
	drv.findElement(By.id("firstNameField")).sendKeys("Manoj");
	drv.findElement(By.id("lastNameField")).sendKeys("J");
	
	drv.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Testleaf");
	drv.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Automation");
	drv.findElement(By.id("createContactForm_personalTitle")).sendKeys("Testing");
	drv.findElement(By.id("createContactForm_generalProfTitle")).sendKeys("Selenium");
	drv.findElement(By.id("createContactForm_departmentName")).sendKeys("Test Engineer");
	drv.findElement(By.id("createContactForm_primaryEmail")).sendKeys("manoj@gmail.com");
	drv.findElement(By.id("createContactForm_primaryPhoneNumber")).sendKeys("9955599555");
	
	 WebElement drop = drv.findElement(By.id("createContactForm_preferredCurrencyUomId"));
	Select Currecy = new Select(drop);
	Currecy.selectByValue("INR");
	

	
	WebElement drop2 = drv.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
	Select state = new Select(drop2);
	state.selectByVisibleText("Indiana");
	
	WebElement drop3 = drv.findElement(By.id("createContactForm_generalCountryGeoId"));
	Select country = new Select(drop3);
	country.selectByValue("IND"); 
	
	
	
	drv.findElement(By.name("submitButton")).click();
	System.out.println(drv.getTitle());
	
}
}
