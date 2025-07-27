package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_ContactsPage  extends BasePage {

	public CRM_ContactsPage(WebDriver driver) {
		super(driver);
		
	}
// Define locators for the Contacts pag//span[normalize-space()='Create Contact']

	@FindBy(xpath = "//h3[normalize-space()='Create Contact']")
	private WebElement Createcontact_button;

@FindBy(xpath = "//label[normalize-space()='Contact ID:']")
private WebElement ContactID;

@FindBy(xpath = "//input[@name='organizationName']")
private WebElement MF_Organization; 

@FindBy(xpath = "//input[@name='title']")
private WebElement MF_Title; 

@FindBy(xpath = "//input[@name='department']")
private WebElement Department;

@FindBy(xpath = "//input[@name='officePhone']")
private WebElement OfficePhone;


@FindBy(xpath = "//input[@name='contactName']")
private WebElement MF_ContactName;

@FindBy(xpath = "//input[@name='mobile']")
private WebElement MF_Mobile;

@FindBy(xpath = "//input[@name='email']")
private WebElement Email;

@FindBy(xpath = "//div[@class='form-group']//div//input[@type='text']")
private WebElement MF_Campaign;


@FindBy(xpath = "//button[normalize-space()='Create Contact']")
private WebElement Createcontactfor_CRM;


public void clickCreatecontact_buttonAndGetTitle() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(Createcontact_button));
	wait.until(ExpectedConditions.elementToBeClickable(Createcontact_button));
	Createcontact_button.click();
}

public void Enter_ContactID(String ID) 
      {
	ContactID.click();
      }


public void Ener_MF_Organization(String organization) 
{
	MF_Organization.sendKeys("education");
}

public void Enter_MF_Title(String Title) 
{
	MF_Title.sendKeys("abc");
}

public void	Enter_Department(String department )
{
	Department.sendKeys("Tekarch");
}

	public void	Enter_Email(String email)
	{
		Email.sendKeys("sridevi@gmail.com");
	}
	
	public void	Enter_OfficePhone(String officePhone)
	{
		OfficePhone.sendKeys("123456789");
	}
	
	public void	Enter_MF_Mobile(String mobile)
	{
	MF_Mobile.sendKeys("678645678");
	}
	
	
	public void Enter_MF_Campaig(String Campaign)
	{
		MF_Campaign.sendKeys();
	}
	
	public void	Createcontactfor_CRM()
	{
		Createcontactfor_CRM.click();
	}

}

