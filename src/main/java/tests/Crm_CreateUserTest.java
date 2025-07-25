package tests;

import org.testng.annotations.Test;
import pages.CRM_CreateUsersPage;

public class Crm_CreateUserTest extends BaseTest {

    @Test
    public void createUserTest() {
        CRM_CreateUsersPage createUserPage=hp.navigateToCreateUser();
        createUserPage.enterUserFullName();
    }
}
