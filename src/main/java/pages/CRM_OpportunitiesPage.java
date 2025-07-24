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
	
	@FindBy(xpath = "(//button[@class='select-btn'])[1]")
	WebElement lead_selectButton;
	
	@FindBy(xpath ="//textarea[@name='description']")
	WebElement description;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement createopportunityButtonInForm;
	
	
	
	public CRM_OpportunitiesPage(WebDriver driver) {
		super(driver);
	}

	public void clickCreateOpportunity() {
		createOpportunityButton.click();
	}

	public void enterOpportunityName(String oppName) {
		opportunityName.sendKeys(oppName);
	}

	public void enterAmount(String amount) {
		Amount.sendKeys(amount);
	}

	public void enterBusinessType(String businessType) {
		business_Type.sendKeys(businessType);
	}

	public void enterNextStep(String nextStep) {
		next_Step.sendKeys(nextStep);
	}

	public void enterSalesStage(String salesStage) {
		sales_Stage.sendKeys(salesStage);
	}

	public void selectLead() {
		//Step1. store the parent window
		String parentWindow = getParentWindow();
		
		//Step2  click on the lookup button
		lead_lookupButton.click();
		
		//step3 wait and switch to the new window
		if(WaitUtils.explicitlyWaitForWindowToOpen(driver, 2)) {
			switchToChildWindow();
		}else {
			throw new RuntimeException("New Window did not open");
		}
		//step4 perform action
		lead_selectButton.click();
		//step5 switch back to parent window
		switchToParentWindow(parentWindow);
		
	}

	public void clickCreateOpportunityInForm() {
		createopportunityButtonInForm.click();
	}

//	public boolean verifyOpportunityCreated(String oppName) {
//		return false;
//	}
}
