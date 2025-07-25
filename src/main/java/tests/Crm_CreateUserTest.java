package tests;

import org.testng.annotations.Test;
import pages.CRM_CreateUsersPage;

public class Crm_CreateUserTest extends BaseTest {

    @Test
    public void CUserWithValidFields() {
        CRM_CreateUsersPage createUserPage=hp.navigateToCreateUser();
        createUserPage.enterUserFullName("Test FullName");
        createUserPage.enterMobileNum("9234567890");
        createUserPage.enterEmail("tek@arch.com");
        createUserPage.enterUserName("test123");
        createUserPage.enterPassword("test123");
        createUserPage.clickCreateUserButton();
    }
}
