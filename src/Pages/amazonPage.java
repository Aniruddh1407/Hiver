package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonPage {

	WebDriver driver;
	
	public amazonPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By searchBar = By.id("twotabsearchtextbox");
	By searchButton = By.className("nav-input");
	// searching for Apple iPhone 6s (32GB) - Space Grey as iPhone 7 was not available
	By phone = By.xpath("//*[contains(text(),'Apple iPhone 6s (32GB) - Space Grey')]");
	By price = By.xpath("//span[@class='a-size-medium a-color-price priceBlockDealPriceString']");

	
	public void searchPhone()
	{
		WebElement search = driver.findElement(searchBar);
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
		System.out.println("Price on Amazon "+cost.getText());
	}
	
}
