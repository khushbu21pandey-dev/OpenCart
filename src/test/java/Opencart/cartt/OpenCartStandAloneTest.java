package Opencart.cartt;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class OpenCartStandAloneTest {
	@Test
public void standAlonetest()
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
 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement cartLink = wait2.until(ExpectedConditions.elementToBeClickable(
         By.partialLinkText("Shopping Cart")));
 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
 cartLink.click();
 System.out.println("Navigated to Shopping Cart page successfully");
 WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
//code for checkout
 WebElement chkout= wait3.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout")));
 chkout.click();
//code to fill the chekout form
 WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement bill= wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Step 2: Billing Details']")));
  bill.click();
 System.out.println("clicked on billing details");
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 try {
	    WebElement newAddr = driver.findElement(By.xpath("//input[@name='payment_address' and @value='new']"));
	    if (newAddr.isDisplayed()) newAddr.click();
	} catch (Exception e) {
	    System.out.println("Using existing address.");
	}
 driver.findElement(By.id("input-payment-firstname")).sendKeys("Khushbu");
 driver.findElement(By.id("input-payment-lastname")).sendKeys("Pandey");
 driver.findElement(By.id("input-payment-address-1")).sendKeys("Gomti Nagar");
 driver.findElement(By.id("input-payment-city")).sendKeys("Lucknow");
 driver.findElement(By.id("input-payment-postcode")).sendKeys("226010");
 Select cntry= new Select(driver.findElement(By.id("input-payment-country")));
 cntry.selectByVisibleText("India");
 Select rgn= new Select(driver.findElement(By.id("input-payment-zone")));
 rgn.selectByVisibleText("Bihar");
 driver.findElement(By.id("button-payment-address")).click();
 System.out.println("clicked on the continue button");
 System.out.println("clicked on the continue button");
 System.out.println("will start writing payments scripts");
 driver.quit();
 
 
 
 
 
 
  
}

}
