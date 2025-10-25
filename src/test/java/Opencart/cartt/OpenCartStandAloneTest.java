package Opencart.cartt;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class OpenCartStandAloneTest {
public static void main(String[] args)
{
	String prodName="MacBook";
  WebDriver driver=new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
  driver.findElement(By.id("input-email")).sendKeys("khushi23pandey@gmail.com");
  driver.findElement(By.id("input-password")).sendKeys("khushi23@");
  driver.findElement(By.cssSelector("input[type='submit']")).click();
  WebElement ele= driver.findElement(By.linkText("Laptops & Notebooks"));
  Actions a =new Actions(driver);
  a.moveToElement(ele).build().perform();
  driver.findElement(By.linkText("Show All Laptops & Notebooks")).click();
  WebDriverWait  wait =new WebDriverWait(driver,Duration.ofSeconds(5));
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-thumb")));
 List<WebElement> products= driver.findElements(By.cssSelector(".product-thumb"));
 System.out.println(products.size());
 for (WebElement product:products)
 {
	String name=product.findElement(By.tagName("h4")).getText();
	if(name.equalsIgnoreCase(prodName))
	{
		System.out.println("Product Found"+name);
		 product.findElement(By.cssSelector("button[onclick*='cart']")).click();
		 System.out.println("Product added to the cart");
	}
	
 }
 
 
  
}

}
