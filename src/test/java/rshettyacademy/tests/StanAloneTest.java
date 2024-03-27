package rshettyacademy.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class StanAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String[] productNam={["ZARA COAT 3"],["IPHONE 13 PRO"]};
		//Stream<String> stream= Arrays.stream(productNam);
		String productName="ZARA COAT 3";
		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		//create object for LandingPage
		LandingPage landingPage=new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("gindu4445@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Gurna@1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		
		//grab all the products
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
			
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		//if lambda expression syntax error  occuring ,,,
		//Go the properties> java compiler> select version 1.8 or higher
		

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))); this will take long time so use the upper code
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		//filter returns something
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
		
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		List<WebElement> selections=driver.findElements(By.cssSelector("[class*='ta-results'] button"));
		
		WebElement selc=selections.stream().filter(selection->selection.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		
		selc.click();
		
		
		//using Action class for advanced selenium atractions
		
		/* Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		*/
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMeassage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(confirmMeassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		driver.close();
		
		
		
	}

}
