package Test1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homePage {

	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/aniruddhkumar.a/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}
	
	@Test(priority=1)
	public void addToCart() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();
		
		Actions action = new Actions(driver);
		WebElement mainmenu = driver.findElement(By.xpath("//*[text()='Electronics']//ancestor::span"));
		action.moveToElement(mainmenu).build().perform();
		Thread.sleep(5000);
		
		// Since couldnt find Pixel. Took a random phone (Redmi 8)
		WebElement submenu = driver.findElement(By.xpath("//a[@href='/mobiles/~cs-r89f1eg6x1/pr?sid=tyy,4io&p%5B%5D=facets.serviceability%5B%5D%3Dfalse&p%5B%5D=facets.availability%255B%255D%3DExclude%2BOut%2Bof%2BStock&otracker=nmenu_sub_Electronics_0_Redmi%208A']"));
		submenu.click();
		Thread.sleep(5000);
		WebElement phonemodel = driver.findElement(By.xpath("//img[@src='https://rukminim1.flixcart.com/image/312/312/k0y6cnk0/mobile/u/e/p/mi-redmi-8a-mzb8458in-original-imafkmhycvhcsrzm.jpeg?q=70']"));
		
		phonemodel.click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		for (String handle : allWindowHandles)			
		{
			String parentWindowHandle = driver.getWindowHandle();
			if(!handle.equals(parentWindowHandle))
			{
				driver.switchTo().window(handle);				
			}					
			
		}
		WebElement addToCart = driver.findElement(By.xpath("//*[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
		
		addToCart.click();
		Thread.sleep(5000);
		WebElement increaseQuantity = driver.findElement(By.xpath("//div[@class='_3md1dr']/button[2]"));
		increaseQuantity.click();
		Thread.sleep(5000);
		WebElement amount = driver.findElement(By.xpath("//div[@class='hJYgKM\']/span"));
		System.out.println("Total Payable"+amount.getText());		
	}
	
	
}
