package myrunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import utility.Base;

@CucumberOptions(
		features = "classpath:features",
		glue = {"stepdefinition"},
		tags = {"@Regression"},plugin = { "pretty",
				"json:target/cucumber-report/cucumber.json" }, monochrome = true)

public class TestRunner
{
	public static TestNGCucumberRunner testNGCucumberRunner;
	public String browser;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber scenarios", description = "Run Cucumber Feature", dataProvider = "scenarios")
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable
	 { 
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent()); 
		
	/*	File reportOutputDirectory = new File(System.getProperty("user.dir") + "/target/cucumber-reports");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target\\cucumber.json");

		String buildNumber = "101";
		String projectName = "Automation";
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setBuildNumber(buildNumber);

		configuration.addClassifications("Browser", browser);
//		configuration.addClassifications("Branch", "release/1.0");
		configuration.setSortingMethod(SortingMethod.NATURAL);
		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		 */
	 }
	
	@DataProvider
	public Object[][] scenarios()
	{
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass(alwaysRun = true)
	public void teaDownClass() throws Exception
	{		
		testNGCucumberRunner.finish();
	}
	
	@Parameters({"Browser"})
	@BeforeTest
	public void initializeTest(String browser) 
	{
		this.browser=browser;
		Base.ChooseBrowser(browser);
	}		
	
	
	@AfterTest
	public void endTest()
	{
		Base.driver.quit();
	}


}
