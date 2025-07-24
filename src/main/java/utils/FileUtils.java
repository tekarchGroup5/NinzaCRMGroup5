package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {
	
	public static String readCommonPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.COMMON_TEST_DATA_FILE_PATH));
		return p.getProperty(key);
	}
	public static String readAdminPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.ADMIN_TEST_DATA_FILE_PATH));
		return p.getProperty(key);
	}
	public static String readUserPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.USER_TEST_DATA_FILE_PATH));
		return p.getProperty(key);
	}

//	public static String readHomePropertiesFile(String key) throws FileNotFoundException, IOException {
//		Properties p = new Properties();
//		p.load(new FileReader(FileConstants.HOME_TEST_DATA_FILE_PATH));
//		return p.getProperty(key);
//	}
}
