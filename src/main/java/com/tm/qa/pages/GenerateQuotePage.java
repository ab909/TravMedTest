package com.tm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tm.qa.base.BaseClass1;

public class GenerateQuotePage extends BaseClass1{
	
	@FindBy (xpath="//button[contains(text(), 'Calculate Premium')]")
	WebElement calcPremiumBtn;

	@FindBy (xpath="//span[@class= 'add-text']")
	WebElement addSpouseDependentBtn;
	
	@FindBy (name="first_date_of_cover")
	WebElement firstDateofCover;
	
	@FindBy(name="last_date_of_cover")
	WebElement lastDateofCover;
	
	@FindBy(name="user_name[]")
	WebElement nameElement;
	
	@FindBy(name="dob_user[]")
	WebElement dateOfBirthElement;
	
	@FindBy(name="arrival_date")
	WebElement arrivalDate;
	
	@FindBy(xpath="//a[contains(text(), 'See Benefit Comparison')]")
	WebElement seeBenefitsComparisonBtn;
	
	@FindBy(xpath="//button[contains(text(), 'Get Quote')]")
	WebElement getQuoteBtn;
	
	
	
	
}
