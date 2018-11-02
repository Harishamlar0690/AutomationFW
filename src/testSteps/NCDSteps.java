package testSteps;


import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import framework.Helper;
import pageclasses.InitiateTransactionPage;


public class NCDSteps extends Helper {
	
	public NCDSteps(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}
	
	public void fillNCDProductType() throws Exception
	{
		
		InitiateTransactionPage initiateTransactionPageObj = new InitiateTransactionPage(driver);
		initiateTransactionPageObj.set_Issuance_Size(data("ISSUANCE SIZE"));
		initiateTransactionPageObj.click_fixedInterestType();
		initiateTransactionPageObj.set_InterestRateCoupon_txt(data("INTEREST RATE"));
		initiateTransactionPageObj.click_InterestPayout_dropdown(data("INTEREST PAYOUT"));
		initiateTransactionPageObj.click_PrincipalAmortization_dropdown(data("PRINCIPAL AMORTIZATION"));
		initiateTransactionPageObj.set_issueDate(data("ISSUE DATE"));
		initiateTransactionPageObj.click_TendorYears_dropdown(data("TENOR_YEAR"));
		initiateTransactionPageObj.click_TendorMonths_dropdown(data("TENOR_MONTH"));
		initiateTransactionPageObj.click_TendorDays_dropdown(data("TENOR_DATE"));
		initiateTransactionPageObj.click_Proceed_btn();
		report.log(LogStatus.PASS, "Non-Convertible Debenture Product Type submitted successfully");
		
	}
	
	public void fillNCDPreferences() throws Exception 
	{
		
		InitiateTransactionPage initiateTransactionPageObj = new InitiateTransactionPage(driver);
		initiateTransactionPageObj.click_HaveValidRatingYes();
		initiateTransactionPageObj.set_RatingAgency_drpdown();
		initiateTransactionPageObj.set_Rating_drpdown(data("RATING"));
		initiateTransactionPageObj.set_DebentureTrustee();
		initiateTransactionPageObj.click_NeedlegalAssistanceYes_chk();
		initiateTransactionPageObj.set_LegalCounsel_drpdown();
		initiateTransactionPageObj.set_RegistrarTransferAgent_drpdown();
		initiateTransactionPageObj.click_UnSecured_chk();
		initiateTransactionPageObj.click_UnListed_chk();
		initiateTransactionPageObj.click_Subordinate_chk();
		initiateTransactionPageObj.set_FaceValue_txt(data("FACEVALUE"));
		initiateTransactionPageObj.click_Submit_btn();
		report.log(LogStatus.PASS, "Non-Convertible Debenture Preferences submitted successfully");
		report.log(LogStatus.INFO, "Transcation ID: "+initiateTransactionPageObj.get_transcationID_txt());
		initiateTransactionPageObj.click_Done_btn();
		
		
	}

}
