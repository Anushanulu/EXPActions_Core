package expOActions_IN_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import expOActions_IN.Step04_CRB_IN;

import lib.Excel;


public class CRB_Auth
{

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;

	WebDriver driver;


	@BeforeTest
	public void setup()
	{
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Jar files for Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		//ProfilesIni ini = new ProfilesIni();
		//FirefoxProfile profile = ini.getProfile("default");
		//WebDriver driver =  new FirefoxDriver(profile);

		//driver = new FirefoxDriver();

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 3, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 3, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 10, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url); 
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC

	@Test(priority=0)
	public void CRB_login() throws InterruptedException 
	{

		Step04_CRB_IN login = new Step04_CRB_IN(driver);
		login.login();
	}

	
	@Test(priority=1)
	public void AllStatus() 
	{

		Step04_CRB_IN status = new Step04_CRB_IN(driver);
		status.switch_instance();
	}
	
	@Test(priority=2)
	public void CRB_auth() 
	{

		Step04_CRB_IN crbauth = new Step04_CRB_IN(driver);
		crbauth.CRB_Auth();
	}



}


