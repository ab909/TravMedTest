package com.tm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tm.qa.base.BaseClass1;

public class SignUpPage extends BaseClass1{
	
	
	@FindBy(name="first_name")
	WebElement firstNameElement;
	
	@FindBy (name="last_name")
	WebElement lastNameElement;
	
	@FindBy(name="email")
	WebElement emailSignUpElement;
	
	@FindBy (name="password")
	WebElement passwordSignUpElement;
	
	@FindBy (name="password_confirmation")
	WebElement passwordConfirmationElement;
	
	@FindBy (xpath="//button[contains(class, 'login100-form-btn signup-btn ')]")
    WebElement signUpBtn;	
	
	@FindBy(xpath="//img[contains(text(),'http://travelmedicare.com/public/users/images/logo1.png')]")
	WebElement travelMedicareLogo;
	
	@FindBy(xpath="//a[contains(text(), 'About Us')]")
	WebElement aboutUsTab;
	
	@FindBy(xpath="//a[contains(text(), 'Contact')]")
	WebElement contactUsTab;
	
	@FindBy(xpath="//a[contains(text(), 'Home')]")
	WebElement homeTab;
	
	@FindBy(xpath="//a[contains,text(), 'login')]")
	WebElement loginToAccount;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
}
	
	public String validateSignUpPageTitle() {
		return driver.getTitle();
}
	public void signUpNewUser(String fn, String ln, String em, String pass, String conpass) {
		firstNameElement.sendKeys(fn);
		lastNameElement.sendKeys(ln);
		emailSignUpElement.sendKeys(em);
		passwordSignUpElement.sendKeys(pass);
		passwordConfirmationElement.sendKeys(conpass);
		signUpBtn.click();
	}
	
	public void clickOnHomeTab() {
		homeTab.click();
	}
	public void clickOnAboutTab() {
		aboutUsTab.click();
	}
    
	public void clickOnContactTab() {
		contactUsTab.click();
	}
	
	public void clickOnLoginLink() {
		loginToAccount.click();
	}
	
	public void clickOnLogo() {
		travelMedicareLogo.click();
	}




	}

