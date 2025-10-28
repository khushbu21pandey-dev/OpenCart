package Opencart.cartt;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class OpenCartStandTest {
	@Test
public  void cartStandTest()
{
	WebDriver driver=new ChromeDriver()	;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
	driver.findElement(By.linkText("Continue")).click();
	driver.findElement(By.id("input-firstname")).sendKeys("Khushbu");
	driver.findElement(By.id("input-lastname")).sendKeys("Pandey");
	driver.findElement(By.id("input-email")).sendKeys("khushi23pandey@gmail.com");
	driver.findElement(By.id("input-password")).sendKeys("khushi23@");
	driver.findElement(By.id("input-confirm")).sendKeys("khushi23@");
	driver.findElement(By.id("input-telephone")).sendKeys("7979825481");
	//driver.findElement(By.id("input-newsletter")).click();
	driver.findElement(By.cssSelector("input[name='agree']")).click();
	driver.findElement(By.cssSelector("input[type='submit']")).click();
	
//	driver.findElement(By.id("input-email")).sendKeys("Khushbu23pandey@gmail.com");
//	driver.findElement(By.id("input-password")).sendKeys("Khushbu21@");
//	driver.findElement(By.cssSelector("input[type='submit']")).click();
	
	
	

}

}
