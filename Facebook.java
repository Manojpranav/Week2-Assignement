package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook 

{
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver dvr = new ChromeDriver();
		dvr.manage().window().maximize();
		dvr.get("https://en-gb.facebook.com/");
		dvr.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		dvr.findElement(By.linkText("Create New Account")).click();
		dvr.findElement(By.name("firstname")).sendKeys("Manoj");
		dvr.findElement(By.xpath("//input[@name='lastname']")).sendKeys("J");
		dvr.findElement(By.name("reg_email__")).sendKeys("9595959595");
		dvr.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("manoj123");
		dvr.findElement(By.id("day")).click();
		
		WebElement day = dvr.findElement(By.id("day"));
		Select drop1 = new Select(day);
		drop1.selectByValue("30");
		
		WebElement month = dvr.findElement(By.id("month"));
		Select drop2 = new Select(month);
		drop2.selectByVisibleText("Nov");
		
		WebElement year = dvr.findElement(By.id("year"));
		Select drop3 = new Select(year);
		drop3.selectByValue("1986");
	dvr.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	
	dvr.findElement(By.xpath("//*[contains(text(),'Male')]")).click();
	dvr.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	
		dvr.close();
	}

}
