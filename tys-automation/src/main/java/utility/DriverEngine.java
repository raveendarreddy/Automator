package utility;

import java.util.Properties;

import org.openqa.selenium.By;

public class DriverEngine extends Base
{	
	private static final String XPATH = "xpath";
	private static final String NAME = "name";
	private static final String CLASS = "class";
	private static final String CSS = "css";
	private static final String ID = "id";
	private static final String LINKTEXT = "linktext";
	private static final String TAGNAME = "tagname";
	private String locatorType;
	private String locatorValue;
	By locator;

	public static ElementControl ec = new ElementControl();
	
	/**
	 * Sets the type of the Locator based on the given input
	 * 
	 * @param element locator to be passed
	 * @return a By which locates elements by the value of the
	 *         "id/name/classname/xpath etc" attribute.
	 * @author Raveendar Reddy
	 */
	public By setLocatorType(String element) {
		String[] orTokens = ec.getObjects(element).split("#");
		this.locatorType = orTokens[0];
		this.locatorValue = orTokens[1];
		switch (locatorType) {
		case XPATH: {
			locator = By.xpath(locatorValue);
			break;
		}
		case ID: {
			locator = By.id(locatorValue);
			break;
		}
		case CSS: {
			locator = By.cssSelector(locatorValue);
			break;
		}
		case NAME: {
			locator = By.name(locatorValue);
			break;
		}
		case CLASS: {

			locator = By.className(locatorValue);
			break;
		}
		case LINKTEXT: {

			locator = By.linkText(locatorValue);
			break;
		}
		case TAGNAME: {

			locator = By.tagName(locatorValue);
			break;
		}
		default: {

			locator = null;
			break;
		}
		}
		return locator;
	}
}
