package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Acme {

	

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver drv = new ChromeDriver();
		drv.get("https://acme-test.uipath.com/login");
		drv.manage().window().maximize();
		drv.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		drv.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		drv.findElement(By.xpath("//button[@type='submit']")).click();
		String T = drv.getTitle();
		System.out.println(T);
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		drv.findElement(By.xpath("//a[text()='Log Out']")).click();
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	drv.close();

	}

}
