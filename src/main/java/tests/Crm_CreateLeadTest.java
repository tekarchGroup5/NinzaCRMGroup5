package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.CRM_HomePage;
import pages.CRM_LeadsPage;
import pages.CRM_LoginPage;
import utils.FileUtils;

public class Crm_CreateLeadTest  extends Crm_BaseTest {
	
	 WebDriver driver = getBrowser();

	 @Test
	    public void createLeadTest() {
	        // Navigate to Leads Page
	        CRM_LeadsPage leadsPage = hp.clickLeads();
	        String leadName = "Test Lead " + System.currentTimeMillis();
	        leadsPage.createLead(leadName);

}
}