package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
		public HomePage(WebDriver _driver) {
			super(_driver);
		}
		
		@FindBy(xpath = "//a[text()='Initiate Transaction']")
		private WebElement initiateTransaction_btn;
		

		public void click_InitiateTransaction() {
			waitUntilElementVisible(initiateTransaction_btn);
			initiateTransaction_btn.click();
		}
		
}
