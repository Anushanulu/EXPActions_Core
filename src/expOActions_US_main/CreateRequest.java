package expOActions_US_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import expOActions_US.Step01_CreateRequestUS;

import java.io.IOException;

import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequest
{
	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;


	public WebDriver driver;


	@BeforeTest
	public void setup()
	{

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver","C:\\Users\\SanjayKushwaha\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 1, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 1, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 1, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC
	@Test(priority=0)
	public void RIPC_Login() throws IOException, InterruptedException 
	{

		Step01_CreateRequestUS login = new Step01_CreateRequestUS(driver);
		login.login();
	}
	@Test(priority=1)
	public void Create_Req() 
	{

		Step01_CreateRequestUS createreq = new Step01_CreateRequestUS(driver);
		createreq.Create_New_Request();
	}
	@Test(priority=2)
	public void skill_Req() 
	{

		Step01_CreateRequestUS skillreq = new Step01_CreateRequestUS(driver);
		skillreq.Skill_Request();
	}
	@Test(priority=3)
	public void select_Req() 
	{

		Step01_CreateRequestUS selectreq = new Step01_CreateRequestUS(driver);
		selectreq.Select_Requestor();
	}

	@Test(priority=4)
	public void select_jrss() 
	{

		Step01_CreateRequestUS selectreq = new Step01_CreateRequestUS(driver);
		selectreq.Select_JRSS();
	}

	@Test(priority=5)
	public void req_detail() 
	{

		Step01_CreateRequestUS reqdetail = new Step01_CreateRequestUS(driver);
		reqdetail.Request_detailpage();
	}
	@Test(priority=6)
	public void skill_loc() 
	{

		Step01_CreateRequestUS skillloc = new Step01_CreateRequestUS(driver);
		skillloc.Skill_detailLocationpage();
	}
	@Test(priority=7)
	public void alert_check() 
	{

		Step01_CreateRequestUS alertchk = new Step01_CreateRequestUS(driver);
		alertchk.isAlertPresent();
	}
	@Test(priority=8)
	public void skill_price() 
	{

		Step01_CreateRequestUS skillprice = new Step01_CreateRequestUS(driver);
		skillprice.Skill_detail_skillpricepage();
	}
	@Test(priority=9)
	public void supp() throws InterruptedException 
	{

		Step01_CreateRequestUS supplier = new Step01_CreateRequestUS(driver);
		supplier.SupplierSelectionPage();
	}

}


