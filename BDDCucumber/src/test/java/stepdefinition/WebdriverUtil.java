package stepdefinition;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverUtil {
	public static WebDriver driver;
	public WebDriverWait wait;
	
	
	
	public  WebDriver getdriver(String type) {
		System.out.println("creating a driver object ");
		
		switch (type) {
		case "chrome" : WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
			break;
		case "ff" : WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
			break;
			
		case "edge" : WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
			break;
			

		default:
			driver=null;
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public  WebElement getElement(String identifer, String value) {
		WebElement ele= null;
		switch (identifer.toLowerCase()) {
		case "id":
			ele=driver.findElement(By.id(value));
			
			break;
			
		case "name":
		ele=	driver.findElement(By.name(value));
			
			break;
			
		case "classname":
		ele=	driver.findElement(By.className(value));
			
			break;
			
		case "partiallinktext":
			ele=driver.findElement(By.partialLinkText(value));
			
			break;
			
		case "linktext":
			ele=driver.findElement(By.linkText(value));
			
			break;
			
		case "xpath":
		ele=	driver.findElement(By.xpath(value));
			
			break;
			
		case "css":
		ele=	driver.findElement(By.cssSelector(value));
			
			break;
			
		case "tagname":
		ele=	driver.findElement(By.tagName(value));
			
			break;
			
		
		default:
			System.out.println("please select above identifier");
			break;
		}
		 return ele;
	}
	
	public  List<WebElement> getElements(String identifer, String value) {
		List<WebElement> eles= null;
		switch (identifer.toLowerCase()) {
		case "id":
			eles=driver.findElements(By.id(value));
			
			break;
			
		case "name":
		eles=	driver.findElements(By.name(value));
			
			break;
			
		case "classname":
			eles=	driver.findElements(By.className(value));
			
			break;
			
		case "partiallinktext":
			eles=driver.findElements(By.partialLinkText(value));
			
			break;
			
		case "linktext":
			eles=driver.findElements(By.linkText(value));
			
			break;
			
		case "xpath":
		eles=	driver.findElements(By.xpath(value));
			
			break;
			
		case "css":
		eles=	driver.findElements(By.cssSelector(value));
			
			break;
			
		case "tagname":
		eles=	driver.findElements(By.tagName(value));
			
			break;
			
		
		default:
			System.out.println("please select above identifier");
			break;
		}
		 return eles;
	}
	
	public void click(String identifer, String value) {
		System.out.println(" perform click on element");
		getElement(identifer, value).click();
	}
	
	public void type(String identifer, String value, String enter) {
		System.out.println("performing type operator on  the element");
		getElement(identifer, value).sendKeys(enter);
	}
	
	public void cleartext(String identifer, String value) {
		System.out.println("clearing the text");
		getElement(identifer, value).clear();
	}
	
	public void getText(String identifer, String value) {
		getElement(identifer, value).getText();
		
	}
	
	public void getTitle() {
		driver.getTitle();
		
	}
	
	public boolean visibleelement(String identifier , String value) {
		boolean flag = false;
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(getElement(identifier, value)));
		if(ele.isDisplayed() && ele.isEnabled())
			flag = true;
		
		return flag;
	}
	

	
	
	

}
