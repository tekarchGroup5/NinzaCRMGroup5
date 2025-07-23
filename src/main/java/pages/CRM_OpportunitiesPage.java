package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRM_OpportunitiesPage extends BasePage {

	@FindBy(xpath = "//button[@class ='btn btn-info']")
	WebElement createOpportunityButton;

	public CRM_OpportunitiesPage(WebDriver driver) {
		super(driver);
	}

	public void clickCreateOpportunity() {
		createOpportunityButton.click();
	}

	public void enterOpportunityName(String oppName) {
		// TODO Auto-generated method stub
		
	}

	public void enterAmount() {
		// TODO Auto-generated method stub
		
	}

	public void enterBusinessType() {
		// TODO Auto-generated method stub
		
	}

	public void enterNextStep() {
		// TODO Auto-generated method stub
		
	}

	public void enterSalesStage() {
		// TODO Auto-generated method stub
		
	}

	public void selectLead() {
		// TODO Auto-generated method stub
		
	}

	public void clickCreateOpportunityInForm() {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyOpportunityCreated(String oppName) {
		// TODO Auto-generated method stub
		return false;
	}
}
