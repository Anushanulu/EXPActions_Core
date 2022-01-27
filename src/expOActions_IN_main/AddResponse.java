package expOActions_IN_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import expOActions_IN.Step02_AddResponseIN;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import lib.Excel;


public class AddResponse
{
	// TestNG logger

	
	
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
		driver = new FirefoxDriver();
		//to display  browser logs in console
        ((RemoteWebDriver) driver).setLogLevel(Level.INFO);
        
		//System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		url = Excel.getCellValue(xlsFilePath, sheet, 2, 2);
		driver.get(url);   
		driver.manage().window().maximize();
	}	



	// Test to add response
	@Test(priority=0)
	public void add_response() throws IOException, InterruptedException
	{
	
		Step02_AddResponseIN addresp = new Step02_AddResponseIN(driver); 
		addresp.login();
		addresp.openRequest();
		
		/*for (int i=1; i<5; i++)
		{
			if(i==1)
			{

				addresp.FillRespdetails("fResp"+i , "Canada" , "lResp"+i , "Canada" , "30", "10");
			}  
			else if(i==2)
			{

				addresp.FillRespdetails("fResp"+i ,  "Cuba" , "lResp"+i , "Cuba" ,  "30", "10");
			}
			else if(i==3)
			{

				addresp.FillRespdetails("fResp"+i , "Armenia" , "lResp"+i, "Armenia" , "30", "10");

			}
			else
			{

				addresp.FillRespdetails("fResp"+i , "Canada" , "lResp"+i, "Canada" , "30", "10");


			}
		}*/
		
		//Cand2 : Embargoed country
		//addresp.FillRespdetails("fResp", "mResp" , "lResp", "Cuba" , "10", "10","RefNum1"); 
		//Cand3 : Contolled country
		addresp.FillRespdetails("fResp" , "Armenia" , "lResp", "Armenia" , "10", "10","RefNum1");
		//Cand1 & 4 :Non-Embargoed and Non-Contolled
		//addresp.FillRespdetails("fResp" , "Canada" , "lResp", "Canada" , "10", "10","RefNum1");

		addresp.Submit();
	}
}




