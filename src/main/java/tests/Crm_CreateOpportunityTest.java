package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CRM_LeadsPage;
import pages.CRM_OpportunitiesPage;
import utils.ExcelUtils;
import utils.FileUtils;

public class Crm_CreateOpportunityTest extends BaseTest {
	public static Logger logger = LogManager.getLogger("Crm_CreateOpportunityTest");

	@DataProvider(name = "opportunityData")
	public Object[][] getOpportunityData() {
		String excelPath = "src/main/java/testData/OpportunityTestData.xlsx";
		String sheetName = "Opportunities";

		List<Map<String, String>> dataList = ExcelUtils.getTestData(excelPath, sheetName);

		Object[][] data = new Object[dataList.size()][1];
		for (int i = 0; i < dataList.size(); i++) {
			data[i][0] = dataList.get(i);
		}
		return data;
	}

	@Test(dataProvider = "opportunityData")
	public void createOpportunityWithMandatoryFields(Map<String, String> data) throws InterruptedException, FileNotFoundException, IOException {
		CRM_OpportunitiesPage oppPage = hp.clickOpportunities();

		oppPage.clickCreateOpportunity();
		logger.info("Create Opportunity button is clicked");

		String oppName = data.get("Opportunity Name");
		String amount = data.get("Amount");
		String businessType = data.get("Business Type");
		String nextStep = data.get("Next Step");
		String salesStage = data.get("Sales Stage");

		// fill the form using Page Object methods
		oppPage.enterOpportunityName(oppName);
		logger.info("Opportunity name is entered");

		oppPage.enterAmount(amount);
		logger.info("Amount is entered");

		oppPage.enterBusinessType(businessType);
		logger.info("Business type is entered");

		oppPage.enterNextStep(nextStep);
		logger.info("Next step is entered");

		oppPage.enterSalesStage(salesStage);
		logger.info("Sales stage is entered");

		String value= FileUtils.readOpportunitiesPropertiesFile("search.dropdown.value2");
		oppPage.selectLead(value);
		logger.info("lead is selected");

		oppPage.clickCreateOpportunityInForm();
		logger.info("opportunity is created");

		// validate Opportunity created
		Assert.assertTrue(oppPage.verifyOpportunityCreated(oppName), "Opportunity Creation failed.");
	}

}
