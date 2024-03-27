package rahulshettyacademy.abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.cartPage;

public class AbstractComponent {
	
	//it will be the parent class as it stores the reusable code -abstract component
	
	
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) 
	{
		//call the driver from child class
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	//wait .until()
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitForWebElementsToAppear(List<WebElement> findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));
		
	}
	
	public cartPage goToCartPage()
	{
		cartHeader.click();
		cartPage CartPage=new cartPage(driver);
		return CartPage;
	}
	
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
	
	
	
	public void waitForElementToDisappear(WebElement ele ) throws InterruptedException
	{
		
		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	
	
	
	
	

}
