package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRM_CreateUsersPage extends BasePage {

	@FindBy(xpath = "//input[@name='empName']")
	WebElement userFullName;

	@FindBy(xpath = "//input[@name='mobileNo']")
	WebElement mobileNum;

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement email;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='dob']")
	WebElement dob;


	// Constructor
	public CRM_CreateUsersPage(WebDriver driver) {
		super(driver);
	}
	public void enterUserFullName(){
		userFullName.click();
	}

}
