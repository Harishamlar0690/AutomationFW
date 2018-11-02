package pageclasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitiateTransactionPage extends BasePage{
	

	public InitiateTransactionPage(WebDriver _driver) {
		super(_driver);
	}
	
	//Navigation
	@FindBy(xpath = "//h4[text()='PTC']")
	private WebElement ptc_Link;
	
	@FindBy(xpath = "//h4[text()='Non-Convertible Debenture']")
	private WebElement ncd_Link;
	
	@FindBy(xpath = "//h4[text()='CP']")
	private WebElement cp_link;
	
	@FindBy(xpath = "//h4[text()='Term Loan']")
	private WebElement termLoan_Link;
	
	@FindBy(xpath = "//h4[text()='Preference Shares']")
	private WebElement preferenceShares_Link;
	
	public void click_InitiateTransactionPTCLink() {
		ptc_Link.click();
	}
	
	public void click_InitiateTransactionNCDLink() {
		waitUntilElementVisible(ncd_Link);waitUntilElementToBeClickable(ncd_Link);
		ncd_Link.click();
	}
	
	public void click_InitiateTransactionCPLink() {
		cp_link.click();
	}
	
	public void click_InitiateTransactionTermLoanLink() {
		termLoan_Link.click();
	}
	
	public void click_InitiateTransactionPreferenceSharesLink() {
		preferenceShares_Link.click();
	}

	//NCD first page
	@FindBy(name = "issuanceSize")
	private WebElement issuance_Size_txt;
	
	@FindBy(xpath = "//*[text()='Fixed']")
	private WebElement fixed_btn;
	
	@FindBy(xpath = "//*[text()='Interest Rate']//following-sibling::div/input")
	private WebElement interestRateCoupon_txt;
	
	@FindBy(xpath = "//input[@value='floating']/parent::label")
	private WebElement floating_btn;
	
	@FindBy(xpath = "//input[@value='coupon']/parent::label")
	private WebElement coupon_btn;
	
	@FindBy(xpath = "(//div[text()='Select...'])[1]")
	private WebElement select_dropdown;
	
	@FindBy(xpath = "//*[text()='Interest Payout']//following-sibling::div//input")
	private WebElement InterestPayout_dropdownValue;
	
	@FindBy(xpath = "//*[text()='Principal Amortization']//following-sibling::div//input")
	private WebElement principalAmortization_dropdownValue;
	
	@FindBy(xpath = "//*[text()='Years']//preceding-sibling::div//Input[@aria-activedescendant]")
	private WebElement tendorYears_dropdownValue;
	
	@FindBy(xpath = "//*[text()='Months']//preceding-sibling::div//Input[@aria-activedescendant]")
	private WebElement tendorMonths_dropdownValue;
	
	@FindBy(xpath = "//*[text()='Days']//preceding-sibling::div//Input[@aria-activedescendant]")
	private WebElement tendorDays_dropdownValue;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement issueDate_txt;
	
	@FindBy(xpath = "//button")
	private WebElement proceed_btn;
	
	public void set_Issuance_Size(String data) {
		waitUntilElementVisible(issuance_Size_txt);
		issuance_Size_txt.sendKeys(data);
	}
	
	public void click_fixedInterestType() {
		
		fixed_btn.click();
	}
	
	public void set_InterestRateCoupon_txt(String data) {
		interestRateCoupon_txt.sendKeys(data);
	}
	
	public void click_floatingInterestType() {
		floating_btn.click();
	}
	
	public void click_couponInterestType() {
		coupon_btn.click();
	}
	
	public void click_InterestPayout_dropdown(String data) {
		waitUntilElementVisible(InterestPayout_dropdownValue);
		InterestPayout_dropdownValue.sendKeys(data,Keys.ENTER);
	}
	
	public void click_PrincipalAmortization_dropdown(String data){
		waitUntilElementVisible(principalAmortization_dropdownValue);
		principalAmortization_dropdownValue.sendKeys(data,Keys.ENTER);
	}
	
	public void set_issueDate(String data) {
		issueDate_txt.sendKeys(data,Keys.ENTER);
	}
	
	public void click_TendorYears_dropdown(String data){
		waitUntilElementVisible(tendorYears_dropdownValue);
	tendorYears_dropdownValue.sendKeys(data,Keys.ENTER);
	}
	
	public void click_TendorMonths_dropdown(String data){
		waitUntilElementVisible(tendorMonths_dropdownValue);
		tendorMonths_dropdownValue.sendKeys(data,Keys.ENTER);
	}
	
	public void click_TendorDays_dropdown(String data){
		waitUntilElementVisible(tendorDays_dropdownValue);
		tendorDays_dropdownValue.sendKeys(data,Keys.ENTER);
	}
	
	public void click_Proceed_btn()  {
		waitUntilElementToBeClickable(proceed_btn);
		proceed_btn.click();

	}
	
	
	
	//NCD second page
	
	@FindBy(xpath = "//*[text()='Debenture Trustee']/preceding::*[text()='Yes']")
	private WebElement haveValidRatingYes_chk;
	
	@FindBy(xpath = "//*[text()='Debenture Trustee']/preceding::*[text()='No']")
	private WebElement haveValidRatingNo_chk;
	
	@FindBy(xpath = "//*[text()='Rating Agency']//following-sibling::div//input[@aria-activedescendant]")
	private WebElement ratingAgency_drpdown;
	
	@FindBy(xpath = "//*[text()='Rating Agency']//following-sibling::div//span[@class='Select-arrow-zone']")
	private WebElement ratingAgency_drpdown1;
	
	
	@FindBy(xpath = "//*[text()='Rating']//following-sibling::div//input")
	private WebElement rating_drpdown;
	
	@FindBy(xpath = "//*[text()='Debenture Trustee']//following-sibling::div//input[@aria-activedescendant]")
	private WebElement debentureTrustee_drpdown;
	
	@FindBy(xpath = "//*[text()='Debenture Trustee']//following-sibling::div//span[@class='Select-arrow-zone']")
	private WebElement debentureTrustee_drpdown1;
	
	@FindBy(xpath = "//*[text()='Need legal Assistance']/following::*[text()='Yes']")
	private WebElement needlegalAssistanceYes_chk;
	
	@FindBy(xpath = "//*[text()='Need legal Assistance']/following::*[text()='No']")
	private WebElement needlegalAssistanceNo_chk;
	
	@FindBy(xpath = "//*[text()='Legal Counsel']//following-sibling::div//input[@aria-activedescendant]")
	private WebElement legalCounsel_drpdown;
	
	@FindBy(xpath = "//*[text()='Legal Counsel']//following-sibling::div//span[@class='Select-arrow-zone']")
	private WebElement legalCounsel_drpdown1;
	
	@FindBy(xpath = "//*[text()='Registrar & Transfer Agent']//following-sibling::div//input[@aria-activedescendant]")
	private WebElement registrarTransferAgent_drpdown;
	
	@FindBy(xpath = "//*[text()='Registrar & Transfer Agent']//following-sibling::div//span[@class='Select-arrow-zone']")
	private WebElement registrarTransferAgent_drpdown1;
	
	@FindBy(xpath = "//*[text()='Un-Secured']")
	private WebElement unSecured_chk;
	
	@FindBy(xpath = "//*[text()='Un-Listed']")
	private WebElement unListed_chk;
	
	@FindBy(xpath = "//*[text()='subordinate']")
	private WebElement subordinate_chk;
	
	@FindBy(name = "faceValue")
	private WebElement faceValue_txt;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submit_btn;
	
	@FindBy(xpath = "//button[text()='Previous']")
	private WebElement previous_btn;
	
	@FindBy(xpath = "//*[text()='Transaction']/a")
	private WebElement transcationID_txt;
	
	public void click_Done_btn() {
		waitUntilElementToBeClickable(proceed_btn);
		proceed_btn.click();
	}
	
	public void click_HaveValidRatingYes() {
		haveValidRatingYes_chk.click();
	}
	public void click_HaveValidRatingNo_chk() {
		haveValidRatingNo_chk.click();
	}
	public void set_RatingAgency_drpdown() throws InterruptedException {
		waitUntilElementToBeClickable(ratingAgency_drpdown1);
		ratingAgency_drpdown1.click();pause(4000);
		waitUntilElementToBeClickable(ratingAgency_drpdown1);
		ratingAgency_drpdown.sendKeys(Keys.ENTER);
	}
	
	public void set_Rating_drpdown(String data) {
		rating_drpdown.sendKeys(data,Keys.ENTER);
	}
	public void set_DebentureTrustee() {
		waitUntilElementToBeClickable(debentureTrustee_drpdown1);
		debentureTrustee_drpdown1.click();pause(4000);
		waitUntilElementToBeClickable(debentureTrustee_drpdown);
		debentureTrustee_drpdown.sendKeys(Keys.ENTER);
	}
	
	public void click_NeedlegalAssistanceYes_chk() {
		needlegalAssistanceYes_chk.click();
	}
	
	public void click_NeedlegalAssistanceNo_chk() {
		needlegalAssistanceNo_chk.click();
	}
	
	public void set_LegalCounsel_drpdown() {
		waitUntilElementToBeClickable(legalCounsel_drpdown1);
		legalCounsel_drpdown1.click();pause(4000);
		waitUntilElementToBeClickable(legalCounsel_drpdown);
		legalCounsel_drpdown.sendKeys(Keys.ENTER);
	}
	
	public void set_RegistrarTransferAgent_drpdown() {
		waitUntilElementToBeClickable(registrarTransferAgent_drpdown1);
		registrarTransferAgent_drpdown1.click();pause(6000);
		waitUntilElementToBeClickable(registrarTransferAgent_drpdown);
		registrarTransferAgent_drpdown.sendKeys(Keys.ENTER);
	}
	
	public void click_UnSecured_chk() {
		unSecured_chk.click();
	}
	
	public void click_UnListed_chk() {
		unListed_chk.click();
	}
	
	public void click_Subordinate_chk() {
		subordinate_chk.click();
	}
	
	public void set_FaceValue_txt(String data) {
		faceValue_txt.sendKeys(data);
	}
	
	public void click_Submit_btn() {
		waitUntilElementToBeClickable(submit_btn);
		submit_btn.click();
	}
	
	public void click_Previous_btn() {
		previous_btn.click();
	}
	public String get_transcationID_txt() {
		return transcationID_txt.getText();
	}
	
	
}

