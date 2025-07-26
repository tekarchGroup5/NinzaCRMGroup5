package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CRM_CreateUsersPage;
import utils.ExcelUtils;

import java.util.List;
import java.util.Map;

public class Crm_CreateUserTest extends BaseTest {
    @DataProvider(name = "CreateUserData")
    public Object[][] getCreateUserData() {
        String excelPath = "src/main/java/testData/CreateUserTestData.xlsx";
        String sheetName = "CreateUser";

        List<Map<String, String>> dataList = ExcelUtils.getTestData(excelPath, sheetName);

        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }
        return data;
    }

    @Test(dataProvider = "CreateUserData")
    public void CUserWithValidFields(Map<String, String> data) throws InterruptedException{
        logger.info("Create User with valid fields testcase 1 Started");
        CRM_CreateUsersPage createUserPage=hp.navigateToCreateUser();

        String userFullName = data.get("UserFullName1");
        String mobileNum = data.get("MobileNumber");
        String emailId = data.get("Email");
        String userName = data.get("UserName");
        String password = data.get("Password");
        String message = data.get("Message");

        createUserPage.enterUserFullName(userFullName);
        createUserPage.enterMobileNum(mobileNum);
        createUserPage.enterEmail(emailId);
        createUserPage.enterUserName(userName);
        createUserPage.enterPassword(password);
        createUserPage.clickCreateUserButton();
        String actualMsg = createUserPage.verifyUserCreated();

        Assert.assertTrue(actualMsg.contains("User created successfully"), "User creation failed!");
        System.out.println("====Successfull+=="+ message);
       // logger.info("Create User Successfull testcase1");
    }

}

