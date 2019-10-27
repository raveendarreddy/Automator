package utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public static WebDriver driver;
	public static ChromeOptions options;
	
	public static WebDriver ChooseBrowser(String browser)
	{
		try
		{
		
			if (browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				options = new ChromeOptions();
				options.addArguments("disable-infobars");
				options.addArguments("--disable-extensions");
				options.addArguments("chrome.switches", "--disable-extensions");
				options.addArguments("--test-type");
				options.addArguments("--disable-notifications");
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("password_manager_enabled", false);
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver();
				driver.manage().window().maximize();	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			else if(browser.equalsIgnoreCase("Edge"))
			{
				System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception:--"+e.getMessage());
			
		}
		
		return driver;
		
	}

}
