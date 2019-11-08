package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.amazonPage;
import Pages.flipkartPage;

public class comparePrice {
	
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
		driver.get("https://www.amazon.in/");
		amazonPage amazonpage = new amazonPage(driver);
		amazonpage.searchPhone();
		amazonpage.clickSearch();
		Thread.sleep(10000);
		amazonpage.findPhone();
		
		flipkartPage flipkartpage = new flipkartPage(driver);
		flipkartpage.windowSwitch();
		
		amazonpage.printPrice();
		
		
		driver.get("https://www.flipkart.com/");
		flipkartpage.closeLoginPopup();
		flipkartpage.searchPhone();
		//Thread.sleep(10000);
		flipkartpage.clickSearch();
		Thread.sleep(10000);
		//flipkartpage.findPhone();
		flipkartpage.printPrice();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
