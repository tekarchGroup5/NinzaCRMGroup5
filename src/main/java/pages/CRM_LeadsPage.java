package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class CRM_LeadsPage extends BasePage {

	public CRM_LeadsPage(WebDriver driver) {
		super(driver);
	}
		
@FindBy(xpath = "//a[normalize-space()='Leads']")
private WebElement leads;	


@FindBy(xpath = "//span[normalize-space()='Create Lead']")
private WebElement createLeadButton;

@FindBy(xpath = "//input[@name='name']")
private WebElement inputleadName;

@FindBy(xpath = "//input[@name='company']")
private WebElement inputCompany;

@FindBy(xpath = "//input[@name='leadSource']")	
private WebElement inputLeadSource;

@FindBy(xpath = "//input[@name='industry']")
private WebElement inputIndustry;

@FindBy(xpath = "//input[@name='phone']")
public WebElement inputPhone;

@FindBy(xpath = "//input[@name='leadStatus']")
private WebElement inputLeadStatus;

@FindBy(xpath = "//*[@id=\"content\"]/div[2]/form/div/div/div[2]/div[9]/div/button")
private WebElement lookupCampaignButton;

@FindBy(xpath = "//button[//button[@type=\"submit\"and text()=\"Create Lead\"]]")
private WebElement saveLeadButton;

@FindBy(xpath="//input[@id=\"search-input\"]")
WebElement inputSearchCampaign;

@FindBy(xpath = "//input[@name=\"annualRevenue\"]")
private WebElement inputAnnualRevenue;

@FindBy(xpath = "//input[@name=\"noOfEmployees\"]")
private WebElement inputNoOfEmployees;

@FindBy(xpath = "//input[@name=\"email\"]")
private WebElement inputEmail;

@FindBy(xpath = "//input[@name=\"secondaryEmail\"]")
private WebElement inputSecondaryEmail;

@FindBy(xpath = "//input[@name=\"rating\"]")
private WebElement inputRating;

@FindBy(xpath = "//input[@name=\"assignedTo\"]")
private WebElement inputAssignedTo;

@FindBy(xpath = "//textarea[@name=\"address\"]")
private WebElement inputAddress;

@FindBy(xpath = "//input[@name=\"city\"]")
private WebElement inputCity;

@FindBy(xpath= "//input[@name=\"country\"]")
private WebElement inputCountry;

@FindBy(xpath = "//input[@name=\"postalCode\"]")
private WebElement inputPostalCode;

@FindBy(xpath = "//input[@name=\"website\"]")
private WebElement website;

@FindBy(xpath = "//input[@name=\"description\"]")
private WebElement inputDescription;


public void clickCreateLeadButtonAndGetTitle() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOf(createLeadButton));
	wait.until(ExpectedConditions.elementToBeClickable(createLeadButton));
    createLeadButton.click();

}

public void enterLeadName(String string) {
	inputleadName.sendKeys(string);
	
}

public void enterCompany(String string) {
    inputCompany.sendKeys(string);
}


public void enterLeadSource(String string) {
    inputLeadSource.sendKeys(string);
	
}


public void enterIndustry(String string) {
    inputIndustry.sendKeys(string);
	
}


public String enterPhone(String string) {
	inputPhone.clear();
    inputPhone.sendKeys(string);
    return inputPhone.getAttribute("value");
	
}


public void enterLeadStatus(String string) {
	inputLeadStatus.sendKeys(string);
}
public void inputSearchCampaignmethod(String string) {
	inputSearchCampaign.sendKeys(string);
	
}

public String enterAnnualRevenue(String string) {
	inputAnnualRevenue.clear();
	inputAnnualRevenue.sendKeys(string);
	String annualRevenue = inputAnnualRevenue.getAttribute("value");
	return annualRevenue;
}


public void lookupCampaign(String string) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", lookupCampaignButton);	
	wait.until(ExpectedConditions.elementToBeClickable(lookupCampaignButton)).click();
	//maximize the window to ensure the element is visible
	driver.manage().window().maximize();
	String parentWindow = driver.getWindowHandle();
	for (String windowHandle : driver.getWindowHandles()) {
	    if (!windowHandle.equals(parentWindow)) {
	        driver.switchTo().window(windowHandle);
	        break;
	    }
	}
	WaitUtils.explicitlyWaitForVisibility(driver, By.xpath("//input[@id='search-input']"));

	WebElement campaignOption = WaitUtils.explicitlyWaitForClickableElement(driver, By.xpath("//*[@id=\"campaign-table\"]/tbody/tr/td/button[contains(@onclick,'" + string + "')]"));
	if (campaignOption != null) {
		campaignOption.click();
	} else {
		throw new RuntimeException("Campaign option not found: " + string);
	}
}

public void SaveLeadButton() {
	// TODO Auto-generated method stub
	saveLeadButton.click();
}
public String getLeadId(String leadName) {
    leads.click(); // navigate to leads page

    List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/table/tbody/tr"));

    for (WebElement row : rows) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        if (columns.size() >= 2) { // Ensure there is at least Lead ID and Lead Name
            String currentLeadName = columns.get(1).getText().trim(); // Lead Name in 2nd column
            if (currentLeadName.equalsIgnoreCase(leadName)) {
                String leadId = columns.get(0).getText().trim(); // Lead ID in 1st column
                System.out.println("Found Lead ID: " + leadId + " for Lead Name: " + leadName);
                return leadId;
            }
        }
    }

    throw new RuntimeException("Lead with name '" + leadName + "' not found in the table.");
}
}