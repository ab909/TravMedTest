package com.tm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.tm.qa.base.BaseClass1;

public class HomePage extends BaseClass1{

	//Page Factory (Object Repository)
	@FindBy(xpath="//a[contains(text(), 'My TM')]")
	WebElement myTMlabel;
	
	@FindBy(xpath="//a[contains(text(), 'Become an Agent')]")
	WebElement becomeAgentLabel;
	
	@FindBy(xpath="//img[contains(text(),'http://travelmedicare.com/public/users/images/logo1.png')]")
	WebElement travelMedicareLogo;
	
	@FindBy(xpath="//a[contains(text(), ' Home ')]")
	WebElement homePageLabel;
	
	@FindBy(xpath="//a[contains(text(),'Profile')]")
	WebElement profilePageLabel;
	
//Initializing Page Objects
public HomePage() {
	PageFactory.initElements(driver, this);

}
// Actions
public String verifyHomePageTitle() {
	return driver.getTitle();
}
public SignUpPage becomeAgentLabel() {
	becomeAgentLabel.click();
	return new SignUpPage();

}

public SignInPage myTMlabel() {
	myTMlabel.click();
	return new SignInPage();
}

public boolean validateTMImage() {
	return travelMedicareLogo.isDisplayed();


}

public void  clickOnTravelMedicareLogo() {
	travelMedicareLogo.click();
	 
}

public void clickOnProfileTab() {
	profilePageLabel.click();
}
}