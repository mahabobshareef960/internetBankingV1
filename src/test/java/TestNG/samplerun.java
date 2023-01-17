package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class samplerun {

	WebDriver driver;
	 
@BeforeTest
public void Grur99() {
	//WebDriverManager.chromedriver().setup();
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	driver.get("https://demo.guru99.com/v4/");
}

@Test
public void entert_login() throws InterruptedException {
	driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mngr464196");
	driver.findElement(By.xpath("//*[@type='password']")).sendKeys("qEjEdYn");
	//driver.findElement(By.xpath("//*[@type='submit']")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@href='addcustomerpage.php']")).click();
	// driver.switchTo().alert().dismiss();
	Thread.sleep(10000);
//driver.findElement(By.xpath("//*[@type='text'][@name='name']")).sendKeys("mahaboob");
	driver.close();
}

}
