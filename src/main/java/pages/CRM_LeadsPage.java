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
//@FindBy(xpath = "//a[normalize-space()='Leads']")
//private WebElement leads;

@FindBy(xpath = "//span[normalize-space()='Create Lead']")
private WebElement createLeadButton;

@FindBy(xpath = "//input[@name='name']")
private WebElement leadNameInput;


public void clickCreateLeadButtonAndGetTitle() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOf(createLeadButton));
	wait.until(ExpectedConditions.elementToBeClickable(createLeadButton));
    createLeadButton.click();



}

}