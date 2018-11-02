package testcases;

import org.testng.annotations.Test;

import testSteps.NCDSteps;
import testSteps.NavigationSteps;

public class IntiateTracsactions_tc extends BaseTest  {
	
	@Test
	public void submit_NCD_Form1() throws Exception
	{
		NavigationSteps navigationStepsobj = new NavigationSteps(driver,alldataForTest,testReport);
		NCDSteps ncdStepsobj = new NCDSteps(driver,alldataForTest,testReport);
		
		navigationStepsobj.login_application();
		
		navigationStepsobj.navigateToNCDpage();
		
		ncdStepsobj.fillNCDProductType();
		
		ncdStepsobj.fillNCDPreferences();
		
	}

}
