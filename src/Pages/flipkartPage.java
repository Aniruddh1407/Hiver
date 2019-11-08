package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class flipkartPage {
	
	WebDriver driver;
	
	By loginPopup = By.xpath("//*[@class='_2AkmmA _29YdH8']");
	By mainmenu = By.xpath("//*[text()='Electronics']//ancestor::span");
	By submenu = By.xpath("//a[@href='/mobiles/~cs-r89f1eg6x1/pr?sid=tyy,4io&p%5B%5D=facets.serviceability%5B%5D%3Dfalse&p%5B%5D=facets.availability%255B%255D%3DExclude%2BOut%2Bof%2BStock&otracker=nmenu_sub_Electronics_0_Redmi%208A']");
	By phonemodel = By.xpath("//img[@src='https://rukminim1.flixcart.com/image/312/312/k0y6cnk0/mobile/u/e/p/mi-redmi-8a-mzb8458in-original-imafkmhycvhcsrzm.jpeg?q=70']");
	By addToCart = By.xpath("//*[@class='_2AkmmA _2Npkh4 _2MWPVK']");
	By increaseQuantity = By.xpath("//div[@class='_3md1dr']/button[2]");
	By amount = By.xpath("//div[@class='hJYgKM\']/span");
	
	By flipkartSearchbar = By.xpath("//*[@title='Search for products, brands and more']");
	By searchButton = By.className("vh79eN");
	By phone = By.xpath("//*[contains(text(),'Apple iPhone 6s (32GB) - Space Grey')]");
	By price = By.xpath("//div[@class='_1uv9Cb']/div[@class='_1vC4OE _2rQ-NK']");
	
	
	public flipkartPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void closeLoginPopup() throws InterruptedException
	{
		driver.findElement(loginPopup).click();
		
	}
	public void hoverOnMenu() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement mainmenu1 = driver.findElement(mainmenu);
		//WebElement mainmenu = driver.findElement(By.xpath("//*[text()='Electronics']//ancestor::span"));
		action.moveToElement(mainmenu1).build().perform();
		Thread.sleep(5000);
		
		// Since couldnt find Pixel. Took a random phone (Redmi 8)
				WebElement submenu1 = driver.findElement(submenu);
				submenu1.click();
				Thread.sleep(5000);
				WebElement phonemodel1 = driver.findElement(phonemodel);
				phonemodel1.click();
	}
	public void windowSwitch()
	{
       Set<String> allWindowHandles = driver.getWindowHandles();
		
		for (String handle : allWindowHandles)			
		{
			String parentWindowHandle = driver.getWindowHandle();
			if(!handle.equals(parentWindowHandle))
			{
				driver.switchTo().window(handle);				
			}			
			
		}
	}
	public void addToCart() throws InterruptedException
	{
        WebElement addToCart1 = driver.findElement(addToCart);		
		addToCart1.click();		
		Thread.sleep(5000);
	}
	
	public void increaseQty() throws InterruptedException
	{
		WebElement increaseQuantity1 = driver.findElement(increaseQuantity);
		increaseQuantity1.click();
		Thread.sleep(5000);
	}
	
	public void printResult()
	{
		WebElement amount1 = driver.findElement(amount);
		System.out.println("Total Payable"+amount1.getText());
	}
	
	
	
	public void searchPhone()
	{
		WebElement search = driver.findElement(flipkartSearchbar);
		search.sendKeys("Apple iPhone 6s (32GB)");		
	}
	
	public void clickSearch()
	{
		WebElement searchBtn = driver.findElement(searchButton);
		searchBtn.click();
	}
	
	public void findPhone()
	{
		WebElement findPhn = driver.findElement(phone);
		findPhn.click();
	}
	
	public void printPrice()
	{
		WebElement cost = driver.findElement(price);
		System.out.println("Price on Flipkart "+cost.getText());
	}
	
}
