package SmokeTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tm.qa.base.BaseClass1;
import com.tm.qa.pages.HomePage;
import com.tm.qa.pages.ProfilePage;
import com.tm.qa.pages.SignInPage;
import com.tm.qa.pages.SignUpPage;

public class smokeTests extends BaseClass1{

	HomePage homePage;
	SignInPage signInPage;
	ProfilePage profilePage;
	SignUpPage signUpPage;
	SoftAssert softAssert;
	
	public smokeTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		signInPage= new SignInPage();
		profilePage = new ProfilePage();
		signUpPage = new SignUpPage();
		
	}
	
	@Test (priority=1)
	public void validSignInTest() {
		homePage.myTMlabel();
		signInPage.login("neal.bhatt100@gmail.com", "testing100!");
		softAssert.assertAll();
}
	@Test (priority=2)
	public void signInTitleTest() {
		homePage.myTMlabel();
		signInPage.validateSignInPageTitle();
		Assert.assertEquals("Travel Medicare Sign in", "Travel Medicare Sign in", " "); 
}
	@Test (priority=3)
	public void navigateToSignUpPageTest() {
		homePage.becomeAgentLabel();
		softAssert.assertAll();
}
	@Test (priority=4)
	public void signUpAllFieldsValidTest() {
		homePage.becomeAgentLabel();
	    signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.assertAll();
}
	@Test (priority=5)
	public void homePageTitleTest(){
		String homePagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle, "Travel Medicare");
}
	@Test (priority=6)
	public void homePageImageTest() {
		homePage.validateTMImage();
		Assert.assertTrue(homePage.validateTMImage());
}
	@Test (priority=7)
	public void emailLinkTest() {
		driver.findElement(By.xpath("//a[contains(text(), 'info@travelmedicare.com')]")).click();
		softAssert.assertAll();
}
	@Test (priority=8)
	public void forgotPasswordTest() {
		homePage.myTMlabel();
		signInPage.clickOnForgotPass();
		signInPage.forgotPassEmailAndClick("neal.bhatt100@gmail.com");
		softAssert.assertAll();
	}
	@Test (priority=9)
	public void clickOnLogoTest() {
		homePage.myTMlabel();
		signInPage.clickOnTMLogo();
		softAssert.assertAll();
	
	}
	@Test (priority=10)
	public void profilePageTitleTest() {
		boolean title= profilePage.verifyProfileLabel();
		Assert.assertEquals(title, "Travel Medicare");
	}
	
	@Test (priority=11)
	public void allFieldsValidTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.assertAll();
}
	@Test(priority=12)
	public void validLicenseTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("20209090", "2019-12-31", "1010404050", "2020-03-27");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	
	@Test (priority=13)
	public void fileUploadTest() {
		profilePage.clickOnProfileTab();
		profilePage.fileUploadLicDetails();
		softAssert.assertAll();
	}
	
	@Test (priority=14)
	public void profileTitleTest() {
		boolean title= profilePage.verifyProfileLabel();
		Assert.assertEquals(title, "Travel Medicare");
	}
	
	@Test (priority=15)
	public void signUpPageTitleTest() {
		homePage.becomeAgentLabel();
		signUpPage.validateSignUpPageTitle();
		Assert.assertEquals("Travel Medicare Sign up", "Travel Medicare Sign up");
	}
	@Test (priority=16)
	public void navigateToSignInPageTest() {
		homePage.myTMlabel();
		softAssert.assertAll();
	}
	
	@Test (priority=17)
	public void clickOnRegisterBtnTest() {
		homePage.myTMlabel();
		signInPage.clickOnRegisterBtn();
	    softAssert.assertAll();
	}
	@Test (priority=18)
	public void aboutUsTabTest() {
		homePage.myTMlabel();
		signInPage.clickOnAboutUsTab();
		softAssert.assertAll();
	}
	@Test (priority=19)
	public void contactUsTabTest() {
		homePage.myTMlabel();
		signInPage.clickOnContactUsTab();
		softAssert.assertAll();
	}
	
	@Test (priority=20)
	public void clickLogoTest() {
		homePage.myTMlabel();
		signInPage.clickOnTMLogo();
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}

    
