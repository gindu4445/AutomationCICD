package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	
	WebDriver driver;
	//create constructor as it will execute first before any other method in the class
	public LandingPage(WebDriver driver)
	{
		//all the arguments, we can catch through constructor
		super(driver);
		//constructors are used for initiation
		this.driver=driver;//make sure you assign this
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Login Page locators
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	//PageFactory- design pattern to nicely declare the upper code-reduce the syntax
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//WebElement userPassword=driver.findElement(By.id("userPassword"));
	@FindBy(id="userPassword")
	WebElement userPassword;
	

	//WebElement driver.findElement(By.id("login"));
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
		
	
	//Action methods
	//explaing what the method does and reduce the sysntax
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue =new  ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	
	
	

}
