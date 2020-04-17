package com.tm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.tm.qa.base.BaseClass1;

public class SignInPage extends BaseClass1{
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'submit')]")
	WebElement loginBtn;

	@FindBy(xpath="//a[contains(text(),'https://www.travelmedicare.com/register')]")
	WebElement registerBtn;
	
	@FindBy(xpath="//a[contains(text(), 'My TM)')]")
	WebElement myTMTab;
	
	@FindBy (id="openInputBox")
	WebElement forgotPassLink;
	
	@FindBy(xpath="//input[@class, 'login100-form-btn resetPassword']")
	WebElement resetPassBtn;
	
	@FindBy(xpath="//img[contains(text(),'logo')]")
	WebElement travelMedicareLogo;
	
	@FindBy(xpath="//a[contains(text(),'About Us')]")
	WebElement aboutUsTab;
	
	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicyTab;
	
	@FindBy(xpath="//a[contains(text(), 'Terms & Condition')]")
	WebElement termsAndConditionsTab;
	
	
	
	public SignInPage () {
		PageFactory.initElements(driver, this);
	}

	public String validateSignInPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String em, String pwd) {
		email.sendKeys(em);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
}
	public void goToSignUpPage() {
		registerBtn.click();
	}
	
	public void goToSignInPage() {
		myTMTab.click();
		
	}
	
	public void clickOnForgotPass() {
		forgotPassLink.click();
	}
	
	public void forgotPassEmailAndClick(String forgotpassemail) {
		email.sendKeys(forgotpassemail);
		resetPassBtn.click();
		
	}
	
	public void clickOnTMLogo() {
		travelMedicareLogo.click();
	}
	
	public void clickOnRegisterBtn() {
		registerBtn.click();
	}
	
	public void clickOnAboutUsTab() {
		aboutUsTab.click();
	}
	public void privacyPolicyTab() {
		privacyPolicyTab.click();
	}

    public void termsAndCondtionsLink() {
    	termsAndConditionsTab.click();
    }
		
	}
