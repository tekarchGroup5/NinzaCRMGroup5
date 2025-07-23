package tests;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CRM_LeadsPage;
import pages.CRM_OpportunitiesPage;

public class Crm_CreateOpportunityTest extends BaseTest{
	
	@Test
	public void createOpportunityWithMandatoryFields() throws InterruptedException {
		CRM_OpportunitiesPage oppPage = hp.clickOpportunities();
		oppPage.clickCreateOpportunity();
		String oppName = "Opportunity" + System.currentTimeMillis();
//		oppPage.enterOpportunityName(oppName);
//		oppPage.enterAmount();
//		oppPage.enterBusinessType();
//		oppPage.enterNextStep();
//		oppPage.enterSalesStage();
//		oppPage.selectLead();
//		oppPage.clickCreateOpportunityInForm();
		
		// validate Opportunity created
//		Assert.assertTrue(oppPage.verifyOpportunityCreated(oppName), "Opportunity Creation failed.");
		
		
		
		
	}
	

}
