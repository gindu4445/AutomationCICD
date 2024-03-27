package rshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.cartPage;
import rshettyacademy.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
	
	

	@Test(groups = {"ErrorHandling"},retryAnalyzer=rshettyacademy.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub

		String productName="ZARA COAT 3";
		
		//create object for LandingPage
		
		landingPage.loginApplication("gindu4445@gmail.com", "Gurna@12345");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		//div[@aria-label='Incorrect email or password.']
		
	}
	
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub

		String productName="ZARA COAT 3";
		
		//create object for LandingPage
		ProductCatalogue productCatalogue =landingPage.loginApplication("gindu4445@gmail.com", "Gurna@1234");
		 
		
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductTocart(productName);
		cartPage CartPage=productCatalogue.goToCartPage();
		
		Boolean match= CartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);//validation should be inside test case only
		
	}
	

}
