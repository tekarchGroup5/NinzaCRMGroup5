package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import listeners.ListenersCRM;


@Listeners(ListenersCRM.class)
public class CRM_AddProductPage extends BasePage{
	
	
	@FindBy(xpath = "//h3")
	private WebElement AddProductPageHeaderEle;
	@FindBy(xpath="//input[@name='productId']")
	private WebElement ProductIDTextBxEle;
	@FindBy(xpath="//input[@name=\"productName\"]")
	private WebElement AddProductNameTxtBxEle;
	
	public CRM_AddProductPage(WebDriver driver) {
		super(driver);
	}

	public String getTextFromElement() {

		return getTextFromElement(AddProductPageHeaderEle);
	}

	public String verifyValueFromTextBox() {

		return ProductIDTextBxEle.getAttribute("value");
	}

	public void enterProductName() {
		
	}

}
