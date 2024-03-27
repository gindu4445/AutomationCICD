package rahulshettyacademy.pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	
	WebDriver driver;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	
	
	
	
	
	//create constructor as it will execute first before any other method in the class
	public OrderPage(WebDriver driver)
	{
		
		//all the arguments, we can catch through constructor
		super(driver);
		//constructors are used for initiation
		this.driver=driver;//make sure you assign this
		PageFactory.initElements(driver, this);
	}
	
	
	
	//action
	public Boolean VerifyOrderDisplay(String productName)
	{
		waitForWebElementsToAppear(productNames);
		Boolean match=productNames.stream().anyMatch(product->product.getText().equals(productName));
		
		return match;
	}
	
	
	

}
