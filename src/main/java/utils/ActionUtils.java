package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionUtils {
	
	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void selectDropDownValue(WebDriver driver, WebElement dropdownElement, String value) {
		Select city = new Select(dropdownElement);
		city.selectByValue(value);
	}
	
	public static String getTextFromElement(WebElement ele) {//priyanka
		String data = ele.getText();
		return data;
	}
	public String getPageTitle(WebDriver driver) { //priyanka
		return driver.getTitle();
	}
	
}
