package rahulshettyacademy.pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent{
	
	
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	
	
	//create constructor as it will execute first before any other method in the class
	public cartPage(WebDriver driver)
	{
		
		//all the arguments, we can catch through constructor
		super(driver);
		//constructors are used for initiation
		this.driver=driver;//make sure you assign this
		PageFactory.initElements(driver, this);
	}
	
	
	
	//action
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match=productTitles.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
		
		return match;
	}
	
	public CheckoutPage goToCheckout()
	{
		checkoutEle.click();

		return new CheckoutPage(driver);
	}
		
	
	
	
	

}
