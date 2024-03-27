package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.cartPage;
import rshettyacademy.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest{

	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	//for plain single line
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
		
	}
	
	
	// @Given("Logged_in_with_username <username> and_password <password>")
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		 productCatalogue =landingPage.loginApplication(username,password);
		
	}
	
	
	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductTocart(productName);
		
	}
	
	
	@When ("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		cartPage CartPage=productCatalogue.goToCartPage();
		
		Boolean match= CartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);//validation should be inside test case only
		CheckoutPage checkoutPage=CartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage=checkoutPage.submitOrder();
		
	}
	
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_displayed_confirmation_page(String string)
	{
		String confirmMessage=confirmationPage.getConfirmatiomMassage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
		
	}
	
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String strArg1)
	{
		Assert.assertEquals(strArg1,landingPage.getErrorMessage());
		driver.close();	
	}
	
	
}
