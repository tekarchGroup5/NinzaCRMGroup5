package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.ListenersCRM;


import pages.CRM_LeadsPage;

@Listeners(ListenersCRM.class)
public class Crm_CreateLeadTest  extends Crm_BaseTest {
	
	
	@Test
    public void createLeadTest() throws InterruptedException {
       WebDriver driver = getBrowser(); // getBrowser() method comes from Crm_BaseTest, 
        //returning the current thread’s WebDriver instance — so you don’t need to initialize it here.
      CRM_LeadsPage lp = hp.clickLeads();//navigates from hme page and clicks on the click leads method and driver is set to the lead page
      lp.clickCreateLeadButtonAndGetTitle(); // Clicks on the Create Lead button and waits for the title to change
     
 
    }
}

