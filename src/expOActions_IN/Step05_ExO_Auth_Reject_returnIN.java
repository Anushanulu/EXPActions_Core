package expOActions_IN;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step05_ExO_Auth_Reject_returnIN {
 
private WebDriver driver;
public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
public String sheet="Login";

// Define the element 
/*@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
@FindBy ( id="btn_signin") private WebElement Signin_Button ;
@FindBy ( xpath=".//*[@id='desktop']") private WebElement Username_Box ;
@FindBy ( xpath=".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement Password_Box ;*/

@FindBy (xpath = ".//*[@id='left-nav']/div/a[9]") private WebElement Awaiting_EO_action ;
@FindBy (xpath = ".//*[@id='left-nav']/div/a[5]") private WebElement Awaiting_EO_review ;
@FindBy (xpath =".//*[@id='content-main']/form/table[2]/tbody/tr[2]/td[4]/a" ) private WebElement CandLink_Under_Review ;
@FindBy (name="txtRunningCommentsSubmitBtn") private WebElement Submit_Comment ;
@FindBy (name="FLD_NEW_COMMENT") private WebElement New_Comment ;

//New login code
@FindBy ( xpath= "//span[@id='credentialSignin']") private WebElement cred_login;
//@FindBy ( xpath= "//input[@id='otp-input']") private WebElement otp_box;
//@FindBy(id = "submit_btn")    private WebElement otp_submit_btn;
@FindBy ( xpath= "//input[@name='username']") private WebElement login_username;
@FindBy ( xpath= "//input[@name='password']") private WebElement login_password;
@FindBy ( id="login-button") private WebElement login_Button ;
@FindBy(id = "otp-input")	private WebElement passcodeBox;
@FindBy(id = "submit_btn")	private WebElement SubmitPasscode;
@FindBy (xpath = "//label[@id='totp_label']") private WebElement Authenticator_App_option;
@FindBy (xpath = "//input[@id='newTotp-otp-input']") private WebElement EnterAccessCode_Box;
@FindBy (xpath = "//button[contains(text(),'Next: Verify')]") private WebElement Verify_Button;
@FindBy (xpath = "//div[@id='totp_item']") private WebElement Totp_Link;
@FindBy (xpath = "//input[@id='otp-input']") private WebElement OTP_TextBox;
@FindBy (xpath = "//button[@id='submit_btn']") private WebElement OTP_Submit_Button;

@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;

@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Candidates')]") private WebElement Candidates ;
@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
@FindBy (name="btnGo") private WebElement GO_reqnum ;

@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a" ) private WebElement Request_Number_Under_Action ;
//@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
//@FindBy (xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[5]/a" ) private WebElement Resp_identification1 ;
/*@FindBy (xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[3]/td[5]/a" ) private WebElement Resp_identification2 ;
@FindBy (xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[4]/td[5]/a" ) private WebElement Resp_identification3 ;
@FindBy (xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[5]/td[5]/a" ) private WebElement Resp_identification4 ;*/
@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[6]/a" ) private WebElement Resp_identification ;

@FindBy (name="btnAuthCandidate") private WebElement Auth_Button ;
@FindBy (name="btnRejectCandidate") private WebElement Reject_Button ;
@FindBy (name="btnReturnAsFinalistCandidate") private WebElement Return_as_finalist_Button ;
@FindBy (name="txtSaveAndReturnAsFinalist") private WebElement SaveAndReturn_as_finalist_Button ;
@FindBy (name="FLD_CMTS_TO_REQSTR") private WebElement CommentsToRequester ;

@FindBy (name="FLD_REJ_REASON") private WebElement Reject_Reason ;
@FindBy (name="btnRejectSel") private WebElement Reject_Selected_Button ;

@FindBy (id="FLD_SUPP_NUMBER") private WebElement SupplierNum ;
@FindBy (name="btnSearch") private WebElement SearchBtn  ;
@FindBy (name="butSaveAndContinue") private WebElement SaveAndContinue ;
@FindBy (id="FLD_SUPP_NUMBER" ) private WebElement SuppNum ;
@FindBy (id="FLD_FAIR_VALUE_ANALYSIS" ) private WebElement FairValueAnalysis ;
@FindBy (name="btnAuthSel") private WebElement AuthSelected_Button ;

@FindBy (name="btnSaveAndAuth") private WebElement SaveAndAuth ;
@FindBy (name="BTN_GO") private WebElement ButtonGO ;
@FindBy (xpath =" .//*[@id='content-main']/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement SupplierID ;
@FindBy (id ="FLD_MSTR_AGRMNT_NUMBER") private WebElement MastrNum ;
@FindBy (id="content-main']/form/div[2]/span/span/input") private WebElement ExitReq;


// Initialize the web elements 
public Step05_ExO_Auth_Reject_returnIN(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


// Function to login to the application

public void login() throws IOException, InterruptedException{

//	WebDriverWait wait = new WebDriverWait(driver, 180);
//	wait.until(ExpectedConditions.visibilityOf(loginToContractor_Link));
//
//	loginToContractor_Link.click();
	WebDriverWait wait00 = new WebDriverWait(driver, 180);
	wait00.until(ExpectedConditions.visibilityOf(cred_login));
	cred_login.click();
	
	//new login changes
	WebDriverWait wait01 = new WebDriverWait(driver, 180);
	wait01.until(ExpectedConditions.visibilityOf(login_Button));
	wait01.until(ExpectedConditions.elementToBeClickable(login_Button));
	login_username.clear();
	login_username.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 15, 0));
	Thread.sleep(1000);
	login_password.clear();
	login_password.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 15, 1));

	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\US");
	login_Button.click();
	try{
		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.visibilityOf(Authenticator_App_option));
		
		Authenticator_App_option.click();
		System.out.println("Authenticator option is selected for authentication");
	}catch(NoSuchElementException | TimeoutException e)
	{
		System.out.println("Page to select Authenticator app option is not displayed");
		e.printStackTrace();
	}
	
	try {

		//Totp_Link.click();
		String otpKeyStr = "WTDVIBXIJR5WRXX4";// bennett19@c25a0161.toronto.ca.ibm.com 
		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now();
		
		

		OTP_TextBox.sendKeys(twoFactorCode);
		System.out.println("value fetched from box= "+OTP_TextBox.getAttribute("value"));
	
		OTP_Submit_Button.click();
		System.out.println("clicked on OTP submit button");
		WebDriverWait wait02 = new WebDriverWait(driver, 100);
		wait02.until(ExpectedConditions.visibilityOf(Create_New_Request));
		System.out.println("Title of page= "+driver.getTitle());
	}
	catch (Exception e) {
		System.out.println("no OTP screen");
		e.printStackTrace();
		WebDriverWait wait02 = new WebDriverWait(driver, 100);
		wait02.until(ExpectedConditions.visibilityOf(Create_New_Request));
		System.out.println("Title of page= "+driver.getTitle());
	}	
	
}

// method for review of candidate
public void EO_Review ()
{

	WebDriverWait wait01 = new WebDriverWait(driver, 180);
	wait01.until(ExpectedConditions.visibilityOf(Awaiting_EO_review));

	Awaiting_EO_review.click();

	WebDriverWait wait02 = new WebDriverWait(driver, 180);
	wait02.until(ExpectedConditions.visibilityOf(CandLink_Under_Review));

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).highlight(CandLink_Under_Review).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	CandLink_Under_Review.click();

	WebDriverWait wait03 = new WebDriverWait(driver, 160);
	wait03.until(ExpectedConditions.visibilityOf(Submit_Comment)); 

	New_Comment.sendKeys("Reviewed");
	Submit_Comment.click();

	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).highlight(Submit_Comment).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

}



// method for Export office auth.


public void EO_Awaiting_action()
{

	WebDriverWait wait01 = new WebDriverWait(driver, 180);
	wait01.until(ExpectedConditions.visibilityOf(Awaiting_EO_action));

	Awaiting_EO_action.click();

	WebDriverWait wait02 = new WebDriverWait(driver, 300);
	wait02.until(ExpectedConditions.visibilityOf(Req_Num_Search));

	Req_Num_Search.clear();
	Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15));
/*	GO_reqnum.click();

	WebDriverWait wait03 = new WebDriverWait(driver, 160);
	wait03.until(ExpectedConditions.visibilityOf(Request_Number_Under_Action));

	/* code to capture screenshot 
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).highlight(Request_Number_Under_Action).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	Request_Number_Under_Action.click();*/

}

// Auth 1st response

public void EO_Auth_req()
{

	WebDriverWait wait04 = new WebDriverWait(driver, 300);
	wait04.until(ExpectedConditions.visibilityOf(Resp_identification)); 

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).highlight(Resp_identification2).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	Resp_identification.click();

	WebDriverWait wait05 = new WebDriverWait(driver, 300);
	wait05.until(ExpectedConditions.visibilityOf(Auth_Button));

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).highlight(Auth_Button).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	Auth_Button.click();

	WebDriverWait wait06 = new WebDriverWait(driver, 300);
	wait06.until(ExpectedConditions.visibilityOf(AuthSelected_Button));

	//SuppNum.sendKeys("1000118974");
	//MastrNum.sendKeys("MA Test");
	//FairValueAnalysis.sendKeys("Approve");

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	AuthSelected_Button.click();


}

//Reject 2nd response

public void EO_Rej_req ()
{

	WebDriverWait wait04 = new WebDriverWait(driver, 300);
	wait04.until(ExpectedConditions.visibilityOf(Resp_identification)); 

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).highlight(Resp_identification3).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	Resp_identification.click();
	WebDriverWait wait05 = new WebDriverWait(driver, 300);
	wait05.until(ExpectedConditions.visibilityOf(Reject_Button));

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).highlight(Reject_Button).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	Reject_Button.click();

	WebDriverWait wait06 = new WebDriverWait(driver, 300);
	wait06.until(ExpectedConditions.visibilityOf(Reject_Selected_Button));


	Select st = new Select(Reject_Reason);
	st.selectByVisibleText("Does not meet requirement"); 

	//SuppNum.sendKeys("1000118974");
	//MastrNum.sendKeys("MA Test");
	//FairValueAnalysis.sendKeys("Rejected");

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	Reject_Selected_Button.click();

}


//return 3rd response

public void EO_Return_req ()
{

	WebDriverWait wait04 = new WebDriverWait(driver, 300);
	wait04.until(ExpectedConditions.visibilityOf(Resp_identification)); 


	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).highlight(Resp_identification4).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	Resp_identification.click();

	WebDriverWait wait05 = new WebDriverWait(driver, 300);
	wait05.until(ExpectedConditions.visibilityOf(Return_as_finalist_Button));

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).highlight(Return_as_finalist_Button).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	Return_as_finalist_Button.click();

	WebDriverWait wait06 = new WebDriverWait(driver, 300);
	wait06.until(ExpectedConditions.visibilityOf(SaveAndReturn_as_finalist_Button));

	CommentsToRequester.sendKeys("Returned as finalist");

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");

	SaveAndReturn_as_finalist_Button.click();
	
	//WebDriverWait wait07 = new WebDriverWait(driver, 300);
	//wait07.until(ExpectedConditions.visibilityOf(Resp_identification4));

	/* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\EO\\US\\");


}

}