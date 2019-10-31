package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.flipkartPage;

public class verifyTotalPrice {

WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/aniruddhkumar.a/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}
	
	@Test
	public void verifyPrice() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		
		flipkartPage flipkartpage = new flipkartPage(driver);
		flipkartpage.closeLoginPopup();
		flipkartpage.hoverOnMenu();
		flipkartpage.windowSwitch();
		flipkartpage.addToCart();
		flipkartpage.increaseQty();
		flipkartpage.printResult();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
