package constants;
import utils.CommonUtils;

public class FileConstants {

	public static String ROOT_PATH = System.getProperty("user.dir");

	public static final String LOGIN_TEST_DATA_FILE_PATH = ROOT_PATH + "/src/main/java/testData/crm_logintestdata.properties";
	public static final String LEADTESTDATA_FILE_UPLOAD_PATH = ROOT_PATH+"/src/main/java/testData/LeadTestData.xlsx";
	public static final String OPPORTUNITY_TEST_DATA_UPLOAD_PATH = ROOT_PATH + "/src/test/resources/testdata/Test Data.xlsx";
	public static final String TEST_PHOTO_UPLOAD_PATH = ROOT_PATH+"/src/main/resources/css.png";
	public static final String SCREENSHOTS_FOLDER_PATH = ROOT_PATH+"/src/main/resources/reports/"+CommonUtils.getTimeStamp()+"_NinzaCRM.PNG";
	public static final String REPORTS_FILE_PATH = ROOT_PATH+"/src/main/resources/reports/"+CommonUtils.getTimeStamp()+"_NinzaCRM.html";
	
}
