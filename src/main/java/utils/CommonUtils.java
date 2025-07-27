package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import constants.FileConstants;

public class CommonUtils {
	static String excelPath = FileConstants.OPPORTUNITY_TEST_DATA_UPLOAD_PATH;
	static String sheetName = "Opportunities";

	
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	}
	
	public static String captureScreenshot(WebDriver driver) {
		String filePath = FileConstants.SCREENSHOTS_FOLDER_PATH;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(filePath);
		src.renameTo(dst);
		return filePath;
	}
	
//	@DataProvider(name = "ValidAccounts")
//	public Object loginTestDataValid() {
////		To read those user accounts logic
//		return new Object[][] { {"mithun@tek.com", "12345" }, { "deek@tek.com", "12345" },
//				{ "dean@tek.com", "12345" } };
//	}

	@DataProvider(name = "tc1Data")
	public static Object[][] getTC1Data() {
	    Map<String, String> data = ExcelUtils.getTestDataByRowIndex(excelPath,sheetName,0);
	    return new Object[][] { { data } };
	}

	@DataProvider(name = "tc2Data")
	public static Object[][] getTC2Data() {
	    Map<String, String> data = ExcelUtils.getTestDataByRowIndex(excelPath,sheetName,1);
	    return new Object[][] { { data } };
	}
	@DataProvider(name = "allOpportunitiesData")
	public static Object[][] getAllOpportunityData() {
	    List<Map<String, String>> dataList = ExcelUtils.getTestData(excelPath, sheetName);

	    // Send the entire list as one object
	    return new Object[][] { { dataList } }; 
	}

	@DataProvider(name = "opportunityData")
	public Object[][] getOpportunityData() {
		String excelPath = FileConstants.OPPORTUNITY_TEST_DATA_UPLOAD_PATH;
		String sheetName = "Opportunities";

		List<Map<String, String>> dataList = ExcelUtils.getTestData(excelPath, sheetName);

		Object[][] data = new Object[dataList.size()][1];
		for (int i = 0; i < dataList.size(); i++) {
			data[i][0] = dataList.get(i);
		}
		return data;
	}
}
