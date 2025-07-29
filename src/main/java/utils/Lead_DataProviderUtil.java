package utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import constants.FileConstants;

public class Lead_DataProviderUtil {
	
	@DataProvider(name = "createLeadwithOptionalFeilds")
	public Object[][] getLeadData_optional() {
		String excelPath = "src/main/java/testData/LeadTestData.xlsx";
		String sheetName = "leadDataWithOptionalFields";

		List<Map<String, String>> dataList = ExcelUtils.getTestData(excelPath, sheetName);

		Object[][] data = new Object[dataList.size()][1];
		for (int i = 0; i < dataList.size(); i++) {
			data[i][0] = dataList.get(i);
		}
		return data;
	}
	
	@DataProvider(name = "LeadMandatoryFeild")
	public Object[][] getLeadData() {
		String excelPath = "src/main/java/testData/LeadTestData.xlsx";
		String sheetName = "LeadMandatoryFeilds";

		List<Map<String, String>> dataList = ExcelUtils.getTestData(excelPath, sheetName);

		Object[][] data = new Object[dataList.size()][1];
		for (int i = 0; i < dataList.size(); i++) {
			data[i][0] = dataList.get(i);
		}
		return data;
	}
}