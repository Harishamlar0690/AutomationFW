package testSteps;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import framework.Helper;
import pageclasses.HomePage;
import pageclasses.InitiateTransactionPage;
import pageclasses.LoginPage;

public class NavigationSteps extends Helper {
	
	public NavigationSteps(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}
	
	public void login_application( ) throws Exception
	{
		LoginPage loginpageObj = new LoginPage(driver);
		loginpageObj.set_Email(data("CLIENT_USER_NAME"));
		loginpageObj.set_Password(data("CLIENT_PASSWORD"));
		loginpageObj.click_Login();
		report.log(LogStatus.PASS, "Login is succesful");
		
	}

	public void navigateToNCDpage()
	{
		HomePage homePageObj = new HomePage(driver);
		homePageObj.click_InitiateTransaction();
		InitiateTransactionPage initiateTransactionPageObj = new InitiateTransactionPage(driver);
		initiateTransactionPageObj.click_InitiateTransactionNCDLink();
		report.log(LogStatus.PASS, "Navigating to Non-Convertible Debenture page");
	}
	
	
	
}
