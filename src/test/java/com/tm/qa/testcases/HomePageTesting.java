package com.tm.qa.testcases;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;
import com.tm.qa.base.BaseClass1;
import com.tm.qa.pages.HomePage;
import com.tm.qa.pages.ProfilePage;
import com.tm.qa.pages.SignInPage;
import com.tm.qa.pages.SignUpPage;
import com.tm.qa.util.TestUtils;



public class HomePageTesting extends BaseClass1{
	
        HomePage homePage;
		SignInPage signInPage;
		SignUpPage signUpPage;
		ProfilePage profilePage;
	    TestUtils testUtils; 
	    SoftAssert softAssert;
	    ExtentHtmlReporter htmlReporter; // relates to the look and feel of the report
		ExtentReports extent; // information that will populate the report
		
	    
		public HomePageTesting () {
			super();
		}
		
		@BeforeMethod
		public void setting(){
		initialization();
		signInPage = new SignInPage();
		homePage = new HomePage();
		testUtils= new TestUtils();
		}
		
		@BeforeSuite
		public void setUp() {
			// start reporters
	        htmlReporter = new ExtentHtmlReporter("TMHomePage.html");
	    
	        // create ExtentReports and attach reporter(s)
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
		
		
		}
		
		@Test (priority=1)
		public void homePageTitleTest(){
			extent.createTest("First Test");
	    	ExtentTest test = extent.createTest("Home Page First Test", "Validating Home Page Title");
			String homePagetitle = homePage.verifyHomePageTitle();
			Assert.assertEquals(homePagetitle, "Travel Medicare");
			
		
		}
		@Test (priority=2)
		public void myTMButtonTest() {
			String myTMtitle= homePage.myTMlabel().validateSignInPageTitle();
			Assert.assertEquals(myTMtitle, "Travel Medicare Sign in", "Test Case Result");
		}

		@Test (priority=3)
		public void validEmailAndPasswordTest() throws InterruptedException {
			driver.get("https://travelmedicare.com");
			driver.findElement(By.xpath("//a[contains(text(),'My TM')]")).click();
			driver.findElement(By.name("email")).sendKeys("neal.bhatt100@gmail.com");
			driver.findElement(By.name("password")).sendKeys("testing100!");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'submit')]")).click();
			softAssert.assertAll();
			
		}
		@Test(priority=4)
		public void becomeAgentBtnTest() {
			driver.findElement(By.xpath("//a[contains(text(), 'Become an Agent')]")).click();
			driver.getTitle();
			Assert.assertEquals("Travel Medicare Sign up", "Travel Medicare Sign up");
			
		}
		
		@Test (priority=5)
		public void emailLinkTest() {
			driver.findElement(By.xpath("/html/body/footer/div/div[1]/div[2]/div[2]/ul/li[3]/a")).click();
			softAssert.assertAll();
		}
		
		@Test (priority=6)
		public void getAQuoteBtnTest() {
			driver.findElement(By.xpath("//a[@class='btn-default ti-arrow-right']")).click();
			softAssert.assertAll();
		}
		
		
       @AfterMethod
   	public void tearDown(){
   		
   		driver.close();
   	}
       @AfterSuite
   	public void tearDown2() {
   	extent.flush();
   }
       
     
    			
    	   
}

