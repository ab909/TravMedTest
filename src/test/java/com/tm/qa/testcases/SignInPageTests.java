package com.tm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tm.qa.base.BaseClass1;
import com.tm.qa.pages.HomePage;
import com.tm.qa.pages.SignInPage;

public class SignInPageTests extends BaseClass1{
	
	SignInPage signInPage;
	HomePage homePage;
	SoftAssert softAssert;

	public SignInPageTests() {
		super();
	}
	
	@BeforeMethod
	public void settings(){
		initialization();
		signInPage = new SignInPage();
		homePage= new HomePage();
	}
	
	@Test (priority=1)
	public void validSignInTest() {
		homePage.myTMlabel();
		signInPage.login("jsmith.op129@gmail.com", "qwerty100!");
		softAssert.assertAll();
	}
	
	@Test (priority=2)
	public void signInTitleTest() {
		signInPage.validateSignInPageTitle();
		Assert.assertEquals("Travel Medicare Sign in", "Travel Medicare Sign in", " ");
	}
	
	@Test (priority=3)
	public void signInTestAllEmptyTest() {
		homePage.myTMlabel();
		signInPage.login(" ", " ");
		Assert.fail("Test not passed");
	}
	
	@Test (priority=4)
	public void invalidEmailValidPasswordTest() {
		homePage.myTMlabel();
		signInPage.login("jsmith.op129@gmail.com", "testing100!");
		Assert.fail("Invalid Password");
	}
	
	@Test (priority=5)
	public void validEmailInvalidPasswordTest() {
		homePage.myTMlabel();
		signInPage.login("neal.bhatt100@gmail.com", "hello1234!");
		Assert.fail("Invalid Password");
	}
	
	@Test (priority=6)
	public void forgotPasswordTest() {
		homePage.myTMlabel();
		signInPage.clickOnForgotPass();
		signInPage.forgotPassEmailAndClick("neal.bhatt100@gmail.com");
		softAssert.assertAll();
	}
	@Test (priority=7)
	public void forgorPasswordInvalidEmailTest() {
		homePage.myTMlabel();
		signInPage.clickOnForgotPass();
		signInPage.forgotPassEmailAndClick("jsmith.op129@gmail.com");
		softAssert.assertAll();
	}
	
	@Test (priority=8)
	public void forgotPasswordNoEmailTest() {
		homePage.myTMlabel();
		signInPage.clickOnForgotPass();
		signInPage.forgotPassEmailAndClick(" ");
		Assert.fail("No Email Provided");
	}
	
	@Test (priority=9)
	public void clickOnLogoTest() {
		homePage.myTMlabel();
		signInPage.clickOnTMLogo();
		softAssert.assertAll();
	}
	
	@Test (priority=10)
	public void clickOnRegisterBtnTest() {
		homePage.myTMlabel();
		signInPage.clickOnRegisterBtn();
	    softAssert.assertAll();
	}
	
	@Test (priority=11)
	public void aboutUsTabTest() {
		homePage.myTMlabel();
		signInPage.clickOnAboutUsTab();
		softAssert.assertAll();
	}
	
	@Test (priority=12)
	public void privacyPolicyTabTest() {
		homePage.myTMlabel();
		signInPage.privacyPolicyTab();
		softAssert.assertAll();
	}
	@Test (priority=13)
	public void termsAndConditionTest() {
		homePage.myTMlabel();
		signInPage.termsAndCondtionsLink();
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

