package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CRM_LoginPage extends BasePage {

	public CRM_LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//input[@id='username']")
	public WebElement userName;

	@FindBy(xpath="//input[@id='inputPassword']")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement SignInButton;

	@FindBy(xpath="//a[contains(text(),'Forgot password?')]")
	public WebElement forgotPassowrd;


    @FindBy(how = How.ID, using = "error")
	public WebElement errorMessage;

	// Additional methods specific to CRM login can be added here
    
	public void enterUsername(String username) {
		this.userName.sendKeys(username);
		logger.debug("Username is entered");
		
	}
	public void enterPassword(String passWord) {
		this.password.sendKeys(passWord);
		logger.debug("password is entered");
	}
	public void SignInButton() {
		this.SignInButton.click();
		logger.debug("Logging button clicked");
	}
	public String getErrorMessage() {
		logger.debug("Error message is fetched");
		return this.errorMessage.getText();
	}
	public CRM_HomePage loginToApp(WebDriver driver, String username, String password) throws InterruptedException {
	    logger.debug("Navigated to the login page: " + driver.getCurrentUrl());
	    this.enterUsername(username);
	    this.enterPassword(password);
	    this.SignInButton();
	  Thread.sleep(2000); // Wait for 2 seconds to ensure the login process completes
	    return new CRM_HomePage(driver);
	}
	}

	

