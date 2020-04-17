package com.tm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tm.qa.base.BaseClass1;
import com.tm.qa.pages.HomePage;
import com.tm.qa.pages.SignUpPage;

public class SignUpPageTesting extends BaseClass1{

	HomePage homePage;
	SignUpPage signUpPage;
	SoftAssert softAssert;
	
	public SignUpPageTesting() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		homePage = new HomePage();
		
	}
	
	@Test(priority=1)
	public void signUpPageTitleTest() {
		homePage.becomeAgentLabel();
		signUpPage.validateSignUpPageTitle();
		Assert.assertEquals("Travel Medicare Sign up", "Travel Medicare Sign up");
	}
	
	@Test (priority=2)
	public void navigateToSignUpPageTest() {
		homePage.becomeAgentLabel();
		softAssert.assertAll();
	}
	
	@Test (priority=3)
	public void signUpAllFieldsValidTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.assertAll();
	}
	@Test (priority=4)
	public void allFieldsEmptyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", " ", " ", " ", " ");
		Assert.fail();
	}
	
	@Test(priority=5)
	public void firstNameOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", " ", " ", " ", " ");
		Assert.fail();
	}
	
	@Test (priority=6)
	public void lastNameOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", "Smith", " ", " ", " ");
		Assert.fail();
	}
	
	@Test(priority=7)
	public void emailOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", " ", "jsmith.op129@gmail.com", " ", " ");
		Assert.fail();
	}
	
	@Test(priority=8)
	public void passwordOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", " ", " ", "sunflower1!", " ");
		Assert.fail();
	}
	
	@Test(priority=9)
	public void confirmPaswordOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", " ", " ", " ", "sunflower1!");
		Assert.fail();
	}
	
	@Test (priority=10)
	public void invalidPasswordTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", "sunflower1!", "sunflower2!");
		softAssert.fail();
	}
	@Test (priority=11)
	public void invalidEmailTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=12)
	public void noFirstNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", "Smith", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=13)
	public void noLastNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", " ", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=14)
	public void noEmailTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", " ", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=15)
	public void noPasswordTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", " ", "sunflower1!");
		softAssert.assertAll();
	}
	
	@Test (priority=16)
	public void noConfirmPasswordTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", "sunflower1!", " ");
		softAssert.fail();
	}
	@Test (priority=17)
	public void firstNameSpecialCharcTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John!", "Smith", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=18)
	public void lastNameSpecialCharcTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith$", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=19)
	public void numberInFirstNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John68", "Smith", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test(priority=20)
	public void numberInLastNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith100", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	@Test (priority=21)
	public void numberInFullNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John99", "Smith100", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=22)
	public void specialCharcInFullNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John$", "Smith%", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=23)
	public void homePageTabTest() {
		homePage.becomeAgentLabel();
		signUpPage.clickOnHomeTab();
		softAssert.assertAll();
	}
	@Test (priority=24)
	public void loginLinkTest() {
		homePage.becomeAgentLabel();
		signUpPage.clickOnLoginLink();
		softAssert.assertAll();
	}
	@Test (priority=25)
	public void logoTest() {
		homePage.becomeAgentLabel();
		signUpPage.clickOnLogo();
		softAssert.assertAll();
	}
	
	@Test (priority=26)
	public void clickOnContactTest() {
		homePage.becomeAgentLabel();
		signUpPage.clickOnContactTab();
		softAssert.assertAll();
	}
	@Test (priority=27)
	public void clickOnAboutTest() {
		homePage.becomeAgentLabel();
		signUpPage.clickOnAboutTab();
		softAssert.assertAll();
	}
	
	@Test(priority=28)
	public void allNumbersFirstNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("7809123", "Smith", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	@Test (priority=29)
	public void allNumberLastNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "900030", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
}
	@Test(priority=30)
	public void allNumbersPasswordTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", "32545543", "32545543");
		softAssert.assertAll();
	}
	
	@Test (priority=31)
	public void allNumbersFullName() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("7809123", "90030", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=32)
	public void shortPasswordTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", "sun", "sun");
		softAssert.assertAll();
	}
	
	@Test (priority=33)
	public void allSpecialCharPassword() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", "!@#!", "!@#!");
		softAssert.fail();
	}
	
	@Test (priority=34)
	public void allNumbersEmailTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "12340987129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	@Test (priority=35)
	public void allSpecialCharEmailTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "$$&*^@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=36)
	public void onlyFirstAndLastNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", " ", " ", " ");
		softAssert.fail();
	}
	
	@Test(priority=37)
	public void onlyPasswordsTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", " ", " ", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test(priority=38)
	public void noPasswordsTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "Smith", "jsmith.op129@gmail.com", " ", " ");
		softAssert.fail();
	}
	
	@Test (priority=39)
	public void firstNameAndEmailOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", "", "jsmith.op129@gmail.com", " ", " ");
		softAssert.fail();
	}
	
	
	@Test (priority =40)
	public void lastNameAndEmailOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("", "Smith", "jsmith.op129@gmail.com", "", "");
		softAssert.fail();
	}
	
	@Test (priority=41)
	public void firstNameAndPasswordOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("John", " ", " ", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@Test (priority=42)
	public void lastNameAndPasswordOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", "Smith", " ", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	@Test (priority=43)
	public void emailAndPasswordOnlyTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser(" ", " ", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	@Test (priority=44)
	public void oneLetterFirstAndLastNameTest() {
		homePage.becomeAgentLabel();
		signUpPage.signUpNewUser("J", "S", "jsmith.op129@gmail.com", "sunflower1!", "sunflower1!");
		softAssert.fail();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
