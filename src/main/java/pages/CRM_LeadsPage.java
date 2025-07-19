package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_LeadsPage extends BasePage {

	public CRM_LeadsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath = "//a[normalize-space()='Leads']")
	private WebElement leads;

@FindBy(xpath = "//button[@cursorshover='true']")
private WebElement createLeadButton;

@FindBy(xpath = "//input[@name='name']")
private WebElement leadNameInput;


public void createLead(String leadName) {
    createLeadButton.click();
  //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    logger.debug("Lead created with name: " + leadName);
}

public void inputLeadName(String leadName) {
	leadNameInput.sendKeys(leadName);
	logger.debug("Lead name entered: " + leadName);
}
	// Method to verify if the Leads page is displayed
	public boolean isLeadsPageDisplayed() {
		return leads.isDisplayed();
	}

	

}
