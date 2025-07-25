package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;

public class CRM_OpportunitiesPage extends BasePage {

	@FindBy(xpath = "//button[@class ='btn btn-info']")
	WebElement createOpportunityButton;

	@FindBy(xpath = "//input[@name='opportunityName']")
	WebElement opportunityName;

	@FindBy(xpath = "//input[@name='amount']")
	WebElement Amount;

	@FindBy(xpath = "//input[@name='businessType']")
	WebElement business_Type;

	@FindBy(xpath = "//input[@name='nextStep']")
	WebElement next_Step;

	@FindBy(xpath = "//input[@name='salesStage']")
	WebElement sales_Stage;

	@FindBy(xpath = "//input[@name='assignedTo']")
	WebElement assignedTo;

	@FindBy(xpath = "//input[@name='expectedCloseDate']")
	WebElement expectedCloseDate;

	@FindBy(xpath = "//input[@name='probability']")
	WebElement probability;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement lead_lookupButton;

	@FindBy(xpath = "//input[@id='search-input']")
	WebElement searchTextBox;

	@FindBy(xpath = "//select[@id='search-criteria']")
	WebElement searchDropdown;

	@FindBy(xpath = "(//button[@class='select-btn'])[1]")
	WebElement lead_selectButton;

	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement createopportunityButtonInForm;

	public CRM_OpportunitiesPage(WebDriver driver) {
		super(driver);
	}

	public void clickCreateOpportunity() {
		createOpportunityButton.click();
	}

	public void enterOpportunityName(String oppName) {
		enterText(opportunityName, oppName);

	}

	public void enterAmount(String amount) {
		enterText(Amount, amount);

	}

	public void enterBusinessType(String businessType) {
		enterText(business_Type, businessType);

	}

	public void enterNextStep(String nextStep) {
		enterText(next_Step, nextStep);
	}

	public void enterSalesStage(String salesStage) {
		enterText(sales_Stage, salesStage);

	}

	public void selectLead(String value) {
		// Step1. store the parent window
		String parentWindow = getParentWindow();

		// Step2 click on the lookup button
		lead_lookupButton.click();

		// step3 wait and switch to the new window
		if (WaitUtils.explicitlyWaitForWindowToOpen(driver, 2)) {
			switchToChildWindow();
		} else {
			throw new RuntimeException("New Window did not open");
		}
		// step4 perform action
		searchDropdown.click();
		selectValue(searchDropdown, value);
		lead_selectButton.click();

		// step5 switch back to parent window
		switchToParentWindow(parentWindow);

	}

	public void clickCreateOpportunityInForm() {
		createopportunityButtonInForm.click();
	}

	public boolean verifyOpportunityCreated(String oppName) {

		return driver.getPageSource().contains(oppName);
	}
}
