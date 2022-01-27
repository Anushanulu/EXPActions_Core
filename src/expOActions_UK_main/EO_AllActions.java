package expOActions_UK_main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import expOActions_UK.Step05_ExO_Auth_Reject_returnUK;
import lib.Excel;


public class EO_AllActions
{


	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;
	public String id_green;
	public String paswd_green;
	public String url_green;
	public String url2;

	public WebDriver driver;


	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");

		//ProfilesIni ini = new ProfilesIni();
		//FirefoxProfile profile = ini.getProfile("default");
		//WebDriver driver =  new FirefoxDriver(profile);

		driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 20, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 20, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 8, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url); 
		driver.manage().window().maximize();
	}	


	//Test for Skill Request page
	@Test(priority=1)
	public void EO_auth() throws IOException, InterruptedException 
	{

		Step05_ExO_Auth_Reject_returnUK EO= new Step05_ExO_Auth_Reject_returnUK (driver);
		EO.login();
		//EO.EO_Review();
		EO.EO_Awaiting_action();
		//EO.EO_Auth_req();
		EO.EO_Rej_req();
		//EO.EO_Return_req();



	}




}

