package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.ListenersCRM;
import pages.CRM_ContactsPage;
import pages.CRM_LeadsPage;



@Listeners(ListenersCRM.class)
public class Crm_CreateContact  extends BaseTest {

	@Test
	public void createContactsTest() throws InterruptedException {
		WebDriver driver = getBrowser(); // getBrowser() method comes from BaseTest,
		// returning the current thread’s WebDriver instance — so you don’t need to
		// initialize it here.
	 CRM_ContactsPage lp = hp.clickContacts();// navigates from home page and clicks on the click leads method and driver is
											// set to the lead page
		lp.clickCreateContactButton();
		// Clicks on the Create Lead button and waits for the title to change
		lp.enterContactID("C12345");
	lp.enterOrganization("Education Inc.");
	lp.enterTitle("Manager");
	lp.enterDepartment("Sales");
	lp.enterEmail("testuser@example.com");
	lp.enterOfficePhone("1234567890");
	lp.enterMobile("9876543210");
	lp.enterCampaign("Campaign July");
	lp.entercontactName("sridevi");
        
	lp.clickCreateContactButtonCRM();
		
		
		
		

	}
}





