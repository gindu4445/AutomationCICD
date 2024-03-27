package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super(driver);
		this.driver=driver;//make sure you assign this
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmatiomMassage()
	{
		return confirmationMessage.getText();
		
	}
	
	
	
}
