package org.Selenium.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils extends GlobalVariables implements ConifgReader
{
	
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	List data = null;
	File f = null;
	FileReader fr;
	BufferedReader br = null;

	
	
	static {
		System.out.println("--pre check to kill the processes ---");
		String drivers[] = {"chromedriver", "geckodriver", "edgedriver"};
		try {
			for (int i = 0; i < drivers.length; i++) 
			{
				System.out.println("checking for the processes : " + drivers[i]);
				Runtime.getRuntime().exec("taskkill /F /IM " + drivers[i] + ".exe");
			}
			
		}catch(Exception ex)
		{
			System.out.println("No process found" );
		}
		
		new WebDriverUtils().configReader();
	}
	
	
	
	public WebDriver getDriver()
	{
		System.out.println("--- Creating a Chrome Driver Object ---");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Integer.valueOf(timeout));

		return driver;
	}
	/**
	 * @author Aravind
	 * @param type - chrome, edge, ff, opera, ie
	 * @return - returns Brower object based on the type
	 * By default browser is maximized and set to a default implicit wait of 20 sec
	 */
	public WebDriver getDriver(String type) {
		System.out.println("Creating a browser of type : " + type);
		switch (type) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			driver = null;
			System.out.println("Please check the driver type, OR contact framework developers");
			break;
		}
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Integer.valueOf(timeout));

		return driver;

	}

	public WebElement getElement(String identifier, String value) {
		System.out.println("finding Element using " + identifier + " and " + value);
		WebElement ele = null;
		switch (identifier.toLowerCase()) {
		case "id":
			ele = driver.findElement(By.id(value));
			break;

		case "name":
			ele = driver.findElement(By.name(value));
			break;

		case "classname":
			ele = driver.findElement(By.className(value));
			break;

		case "tagname":
			ele = driver.findElement(By.tagName(value));
			break;

		case "linktext":
			ele = driver.findElement(By.linkText(value));
			break;

		case "partiallinktext":
			ele = driver.findElement(By.partialLinkText(value));
			break;

		case "css":
			ele = driver.findElement(By.cssSelector(value));
			break;

		case "xpath":
			ele = driver.findElement(By.xpath(value));
			break;

		default:
			System.out.println("Please check the identifier, OR contact framework developers");
			break;
		}
		
		return ele;
	}

	public void click(String identifier, String value)
	{
		System.out.println("performing click on element");
		getElement(identifier, value).click();
		System.out.println("performing click on element - Complete");
	}
	
	public void type(String identifier, String value, String texttoEnter)
	{
		System.out.println("Performing type operation on the element "  + texttoEnter);
		getElement(identifier, value).sendKeys(texttoEnter);
		System.out.println("Performing type operation on the element "  + texttoEnter + " is complete");
		
	}
	public void clearText(String identifier, String value, String texttoEnter)
	{
		System.out.println("Performing type operation on the element "  + texttoEnter);
		getElement(identifier, value).clear();
		System.out.println("Performing type operation on the element "  + texttoEnter + " is complete");
		
	}
	
	public String getAttribute(String identifier, String value, String attributeValue)
	{
		return getElement(identifier, value).getAttribute(attributeValue);
	}
	public String getText(String identifier, String value)
	{
		String text = getElement(identifier, value).getText();
		System.out.println("Returning Text : " +  text);
		return text;
	}
	
	public List<WebElement> getElements(String identifier, String value)
	{
		List<WebElement> ele = null;
		switch (identifier.toLowerCase()) {
		case "id":
			ele = driver.findElements(By.id(value));
			break;

		case "name":
			ele = driver.findElements(By.name(value));
			break;

		case "classname":
			ele = driver.findElements(By.className(value));
			break;

		case "tagname":
			ele = driver.findElements(By.tagName(value));
			break;

		case "linktext":
			ele = driver.findElements(By.linkText(value));
			break;

		case "partiallinktext":
			ele = driver.findElements(By.partialLinkText(value));
			break;

		case "css":
			ele = driver.findElements(By.cssSelector(value));
			break;

		case "xpath":
			ele = driver.findElements(By.xpath(value));
			break;

		default:
			System.out.println("Please check the identifier, OR contact framework developers");
			break;
		}
		return ele;
	}
	
	public void pauseExecution(int ms)
	{
		System.out.println("Application  execution is paused for " + ms + " ms");
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Application  execution is resumed from " + ms + " ms");
		
	}
	
	/**
	 * 
	 * @param identifier
	 * @param value
	 * @return - boolean based on the visibility of the element\
	 * @author Aravind
	 * 
	 */
	public boolean verifyElementisVisible(String identifier, String value)
	{
		boolean flag = false;
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(getElement(identifier, value)));
		if(ele.isDisplayed() && ele.isEnabled())
			flag = true;
		
		return flag;
	}
	
	
	public void verifyElementisVisibleUsingJS(String identifier, String value)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", getElement(identifier, value));
	}
	
	
	public void verifyElementIsVisibleUsingFW(String identifier, String value)
	{
		FluentWait<WebElement> wait = new FluentWait<WebElement>(
				driver.findElement(By.xpath(value)))
				.pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds(30))
				.ignoring(NoSuchElementException.class).ignoring(Exception.class);

//STEP-2
		Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>() {

			@Override
			public Boolean apply(WebElement ele) {
				boolean flag = false;
				if (!ele.isDisplayed()) {
					System.out.println("Waiting for the element!!!!");
				} else {
					flag = true;
					System.out.println("Element Displayed");
				}
				return flag;

			}
		};

		wait.until(fun);
	}
	
	
	public void closeDriver()
	{
		driver.close();
	}
	
	
	
	public List<String> readActitimeTestData() {

		try {
			data = new ArrayList<String>();
			f = new File("data/ActiTimeTestData.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				data.add(line);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

	public void configReader() {
		System.out.println("Setting Global Variables for the Project!!!");
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File("data/config.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GlobalVariables.url = props.getProperty("actitimeURL");
		GlobalVariables.userName = props.getProperty("username");
		GlobalVariables.password = props.getProperty("password");
		GlobalVariables.timeout = props.getProperty("timeout");
		GlobalVariables.browser = props.getProperty("browser");

		System.out.println("URL : " + GlobalVariables.url);
		System.out.println("UserName : " + GlobalVariables.userName);
		System.out.println("Password : " + GlobalVariables.password);
		System.out.println("TimeOut : " + GlobalVariables.timeout);
		System.out.println("Browser : " + GlobalVariables.browser);

	}

	
	public String getDateAndTime()
	{
		return new Date().toString().replace(" " , "_").replace(":", "_");
	}
	
	public void takeScreenShot(String testName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("screenshots\\" + testName + "_" + getDateAndTime() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
