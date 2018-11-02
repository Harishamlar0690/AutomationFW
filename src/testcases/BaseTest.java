package testcases;

import java.io.File;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import framework.Helper;

public class BaseTest {
	
	ExtentReports extent = null;
	ExtentTest testReport = null;
	WebDriver driver = null;
	Helper helper = new Helper();
	String strReportPath= null;
	static LinkedHashMap<String, String> alldataForTest=new LinkedHashMap<String, String>();
	
	@BeforeSuite
	public LinkedHashMap<String, String> _beforeSuite() throws Exception
	{
		alldataForTest = helper.configData("QA");
		LinkedHashMap<String, String> alldataForTest1 = helper.getTestDataDetails("IntiateTracsactions_tc","testData1");
		alldataForTest.putAll(alldataForTest1);
		strReportPath = System.getProperty("user.dir")+"\\extentReports\\ExtentReport.html";
		extent = new ExtentReports (strReportPath, true);
		extent.addSystemInfo("Environment","Chrome");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		return alldataForTest;
	}
	
	@BeforeMethod
	public void beforeMethoed() throws Exception
	{
		testReport = extent.startTest(this.getClass().getSimpleName());		
		driver = helper.GetDriver("Chrome");
		driver.get("http://mp-qa.vivriti.in");
		testReport.log(LogStatus.INFO, "Testcase execution started" + this.getClass().getSimpleName());
	}
	
	
	@AfterMethod
	public void afterMethoed()
	{
		extent.endTest(testReport);	
		driver.quit();
	}

	
	@AfterSuite
	public void _afterSuite()
	{
		extent.flush();
		extent.close();	
		
	}
}
