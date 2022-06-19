package Reusable_Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.testproject.sdk.drivers.ios.IOSDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;

public class Generic_functions {
	public static String path;
	static File file = new File("config/config.properties");
	static Properties prop = new Properties();
	public static String platformName,text;
	protected AppiumDriver driver;
	public static Reader reader;

	/* Launch the application and provide desired capabilities of connected device.Also give the URL of the Appium server*/
	protected AppiumDriver app_launch() throws IOException, AgentConnectException, InvalidTokenException, ObsoleteVersionException  {
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
		platformName=getPlatformName();
		if (platformName.equals("iOS")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
			capabilities.setCapability(MobileCapabilityType.UDID, get_IOSUDID());
			capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getBundleId());
			driver = new IOSDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		}	
		else if (platformName.equals("Android")) {
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setCapability("deviceName",getDeviceName());
			cap.setCapability("udid", getUDID());
			cap.setCapability("platformName", getPlatformName());
			cap.setCapability("platformVersion", getPlatformVersion());
			cap.setCapability("appPackage", getAppPackage());
			cap.setCapability("appActivity", getAppActivity());
			cap.setCapability("newCommandTimeout", 1000000);
			URL url = new URL(getURL());
			driver= new AndroidDriver(url,cap);

		}
		return driver;
	}
	/* Function will fetch the platform from the config.properties file*/
	public static String getPlatformName() {
		String platformName= prop.getProperty("platformName");
		if(platformName!=null) return platformName ;
		else throw new RuntimeException ("platformName is not specified in the Config.properties");
	}

	/* Function will fetch the device name from the config.properties file*/
	public static String getToken() {
		path= prop.getProperty("Token");
		if(path!=null) return path ;
		else throw new RuntimeException ("Token is not specified in the Config.properties");
	}

	/* Function will fetch the device UDID from the config.properties file*/
	public static String getUDID() {
		String udid= prop.getProperty("udid");
		if(udid!=null) return udid ;
		else throw new RuntimeException ("udid is not specified in the Config.properties");
	}

	/* Function will fetch the platform version from the config.properties file*/
	public static String getBundleId() {
		path= prop.getProperty("app_bundleid");
		if(path!=null) return path ;
		else throw new RuntimeException ("Bundle Id is not specified in the Config.properties");
	}

	/* Refresh function to refresh the current page opened  */
	public void page_refresh() {
		driver.navigate().refresh();
	}

	/* To wait the browser till the time passed to this function */
	public void page_wait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}

	/*To get directory path of screenshots folder*/
	public static String getDir() {
		String dirpath= prop.getProperty("Dirpath");
		if(dirpath!=null) return dirpath ;
		else throw new RuntimeException ("user Dir is not specified in the Config.properties");
	}

	/* Function will fetch the device UDID from the config.properties file*/
	public static String get_IOSUDID() {
		String udid= prop.getProperty("UDID");
		if(udid!=null) return udid ;
		else throw new RuntimeException ("udid is not specified in the Config.properties");
	}

	/* Function will fetch the device name from the config.properties file*/
	public static String getDeviceName() {
		String deviceName= prop.getProperty("deviceName");
		if(deviceName!=null) return deviceName ;
		else throw new RuntimeException ("deviceName is not specified in the Config.properties");
	}
	/* Function will fetch the platform version from the config.properties file*/
	public static String getPlatformVersion() {
		String platformVersion= prop.getProperty("platformVersion");
		if(platformVersion!=null) return platformVersion ;
		else throw new RuntimeException ("platformVersion is not specified in the Config.properties");
	}
	/* Function will fetch the app package from the config.properties file*/
	public static String getAppPackage() {
		String appPackage= prop.getProperty("appPackage");
		if(appPackage!=null) return appPackage ;
		else throw new RuntimeException ("appPackage is not specified in the Config.properties");
	}
	/* Function will fetch the app activity from the config.properties file*/
	public static String getAppActivity() {
		String appActivity= prop.getProperty("appActivity");
		if(appActivity!=null) return appActivity ;
		else throw new RuntimeException ("appActivity is not specified in the Config.properties");
	}	
	/* Function will fetch the URLof the Appium server from the config.properties file*/
	public static String getURL() {
		String URL= prop.getProperty("URL");
		if(URL!=null) return URL ;
		else throw new RuntimeException ("URL is not specified in the Config.properties");
	}
	/* Reading Excel file path  from config.properties   */
	public static String getAndroidFilepath() {
		String filepath= prop.getProperty("AndroidFilepath");
		if(filepath!=null) return filepath ;
		else throw new RuntimeException ("Filepath is not specified in the Config.properties");
	}

	/* Reading Excel file path  from config.properties   */
	public static String getFilepath() {
		String filepath= prop.getProperty("Filepath");
		if(filepath!=null) return filepath ;
		else throw new RuntimeException ("Filepath is not specified in the Config.properties");
	}

	/* To find object locator value of a particular fieldname passing to this function by loading */
	public static String OR_reader(String fieldname) throws IOException {
		if (platformName.equals("iOS")) {
			reader=new BufferedReader(new InputStreamReader(new FileInputStream(getFilepath()),"utf-8"));
		}
		else if (platformName.equals("Android")) {
			reader=new BufferedReader(new InputStreamReader(new FileInputStream(getAndroidFilepath()),"utf-8"));
		}
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get(0);
			String val = csvRecord.get(2);
			if(name.equalsIgnoreCase(fieldname))
			{
				return val;
			}
		}
		return null;
	}

	/* To read test data value of a particular fieldname using index  where its values are seperated with a comma within cell in excel sheet  */
	public static String td_reader(String fieldname,int index) throws IOException {	
		reader=new BufferedReader(new InputStreamReader(new FileInputStream(getcsv()),"UTF-8"));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get(0);
			String val = csvRecord.get(1);
			if(name.equalsIgnoreCase(fieldname))
			{
				String[] values = val.split(",");
				return values[index];
			}
		}
		return null;		
	}

	/* Reading Doctor's report file path  from config.properties   */
	public static String getcsv() {
		path= prop.getProperty("Test_csv");
		if(path!=null) return path ;
		else throw new RuntimeException (" csv path is not specified in the Config.properties");
	}	

	/* Click operation for a particular fieldname that is passing to this function through finding locator value of fieldname using OR_reader function*/
	public void click(String fieldname) throws IOException {
		driver.findElement(By.xpath(OR_reader( fieldname))).click();
	}

	/* To go back to the previous page */
	public void page_back(){
		driver.navigate().back();
	}

	/*close the application*/
	protected void close() {
		driver.quit();	}

	/*  Taking Screenshot of failed test cases  */
	protected void takeScreenShot(String fileName) throws Exception {
		TakesScreenshot scrShot = driver;
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(getDir()+fileName+".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}

	/*Function to clear the value in a particular field*/
	public void field_clear(String fieldname) throws IOException {
		driver.findElement(By.xpath(OR_reader( fieldname))).clear();
	}

	/* Function to handling login. variable phonenumber is the test data value number and variable passowrd is the test data password value*/	
	public static void login(int phonenumber,int password) throws Exception {
		if (platformName.equals("iOS")) {
//			click("welcome_login");
//			click("continue");
//			page_wait(9000);
//			click("login_phone_number");
//			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",phonenumber));
//			click("login_password");
//			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",password));
//			click("login");
//			page_wait(10000);
		}
		else  {		
//			click("welcome_login");
//			page_wait(20000);
//			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",phonenumber));
//			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",password));
//			click("login");
//			page_wait(9000);
		}
	}
	/*Function for explicit wait */
	public WebElement page_explicit_wait(String ele, int time) throws IOException {
		return new WebDriverWait(driver, Duration.ofMillis(time)).until(ExpectedConditions.elementToBeClickable(By.xpath(ele)));
	}

	public void pageWait_until_visibilityOfElement(String ele, int time) throws IOException {
		WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+ele+"\")"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/* Phone number used for various screens*/
	public static void phone_number(String OR_phone_number, String sheet_ph_number, int phone_number)  {
//		driver.findElement(By.xpath(OR_reader(OR_phone_number))).sendKeys(td_reader(sheet_ph_number,phone_number));
	}


	protected  String random_number() {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return String.valueOf(number);
	}
		public void scrollAndClick(String fieldName) throws IOException {
			if (platformName.equals("Android")) {
				WebElement element =  driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))" +
								".scrollIntoView(new UiSelector().text(\""+fieldName+"\"))"));
				element.click();
			}
			else {
				click(fieldName);
				driver.findElement(By.className(OR_reader("dropdown"))).sendKeys(td_reader(fieldName,0));
				page_wait(2000);
				click("dropdown_done");
			}
	}

	public void logout() throws Exception {
			click("utilities");
			click("utilities_accountTab");
			click("logout");
			page_wait(30000);
		    Assert.assertTrue(driver.findElement(By.xpath(OR_reader("mph_image"))).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath(OR_reader("mph_logo"))).isDisplayed());
	}
}



