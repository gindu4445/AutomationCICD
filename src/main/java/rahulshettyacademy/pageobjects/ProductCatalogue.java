package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	
	WebDriver driver;
	//create constructor as it will execute first before any other method in the class
	public ProductCatalogue(WebDriver driver)
	{
		
		//all the arguments, we can catch through constructor
		super(driver);
		//constructors are used for initiation
		this.driver=driver;//make sure you assign this
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Login Page locators
	
	//PageFactory- design pattern to nicely declare the upper code-reduce the syntax
	
	
	//grab all the products
	//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
			
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	//action
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductTocart(String productName) throws InterruptedException
	{

		WebElement prod =getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
		
	}
	
	
	
	
	

}
