package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class BDDExtentsReportsAndHooks extends WebdriverUtil {
	
	public static ExtentReports reports ;
	public static ExtentTest test ;
	
	@Before
	public void conigureReports()
	{
		String date = new Date().toString().replace(":", "_").replace(" " , "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport_" + date + ".html");
		reports = new ExtentReports();
		reports.attachReporter(spark);

		System.out.println("Creating Repoerts");
	}
	
	
	@After
	public void savingReports()
	{
		reports.flush();
	}

	
	@Before
	public void setupStep(Scenario sc)
	{
		test=reports.createTest(sc.getName());
	}
	
	@AfterStep
	public void cleanupScenario(Scenario sc)
	{
		System.out.println("..........................................");
		String testName = sc.getName().replace(" " , "_");
		System.out.println("Scenario Status : " + sc.getStatus());
		if(sc.isFailed())
		{
			System.out.println("********capturing Screen shots **************");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(srcFile, new File("target\\screenshots\\" + testName + "_"  + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}
	
	
	
	
	@BeforeStep
	public void stepScenario(Scenario sc)
	{
		test.log(Status.INFO, sc.getLine()+" excuting "+sc.getName());
	}
	
	@After
	public void afterScenrio(Scenario sc   )
	{
		test.log(Status.INFO, sc.getLine()+" excuting "+sc.getName());
	}

}
