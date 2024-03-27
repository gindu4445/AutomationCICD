 package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReporterNG {
	
	
	public static ExtentReports getReportObject()
	{
		//matadata
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//ExtentReports-main class// it will resposible to try all our repoerting executions
		ExtentReports  extent = new ExtentReports();
		//now you have to attach the reports whatever you created with ExtentSparkReporter 
		//as extent will responsibile to create and consolidate all test execution
		//so ExtentSparkReporter is just a helper call which will report to extent main class
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Guri");
		return extent;
	
	}
	
	

}
