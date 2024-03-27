package rshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.cartPage;
import rshettyacademy.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productName="ZARA COAT 3";
	
	
	
	@Test(dataProvider="getData", groups="Purchase")
	public void submitorder(HashMap<String,String>input) throws IOException, InterruptedException
	{
		
		
		// TODO Auto-generated method stub

		
		String password;
		//create object for LandingPage
		ProductCatalogue productCatalogue =landingPage.loginApplication(input.get("email"),input.get("password"));
		 
		
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductTocart(input.get("product"));
		cartPage CartPage=productCatalogue.goToCartPage();
		
		Boolean match= CartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);//validation should be inside test case only
		CheckoutPage checkoutPage=CartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String confirmMessage=confirmationPage.getConfirmatiomMassage();
		
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		
		
	}
	
	@Test(dependsOnMethods={"submitorder"})
	public void OrderHistoryTest()
	{
		//
		ProductCatalogue productCatalogue =landingPage.loginApplication("gindu4445@gmail.com", "Gurna@1234");
		OrderPage orderPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
		
	}
	
	
	
	

	/*@DataProvider
	public Object[][] getData(){	
		return new Object[][] {{"gindu4445@gmail.com","Gurna@1234","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
	}*/
	
	//new method to provide data
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//dataprovider is able to send hashmap
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "gindu4445@gmail.com");
//		map.put("password", "Gurna@1234");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "ADIDAS ORIGINAL");
//		 
//		
//		return new Object[][] {{map},{map1}};
		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
	}

	public static void main(String[] args) {
		

	}
	
	
	

}
