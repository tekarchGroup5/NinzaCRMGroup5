package pages;

import org.openqa.selenium.WebDriver;

public class CRM_UsersPage extends BasePage {

	// Constructor
	public CRM_UsersPage(WebDriver driver) {
		super(driver);
		
	}

	// Example method to add a user
	public void addUser(String username, String password) {
		// Implementation for adding a user
		logger.debug("User added with username: " + username);
	}

}
