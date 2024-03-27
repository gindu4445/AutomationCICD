package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber can not by itself own
@CucumberOptions(features="src/test/java/cucumber",glue="rahulshettyacademy.stepDefinitions",
monochrome=true,tags= "@Regression" ,plugin= {"html:target/cucumber.html"})


//monohrome will convert the ouput in readable form
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	//here you have to give information to run your cucumber feature files
	

}
