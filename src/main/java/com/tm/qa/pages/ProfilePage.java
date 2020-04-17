package com.tm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tm.qa.base.BaseClass1;

public class ProfilePage extends BaseClass1{
	
	//Page Factory
	
	@FindBy(name="first_name")
	WebElement firstNameElement;
	
	@FindBy(name="last_name")
	WebElement lastNameElement;
	
	@FindBy(name="website")
	WebElement websiteElement;
	
	@FindBy(name="phone")
	WebElement phoneElement;

	@FindBy (name="address")
	WebElement addressElement;
	
	@FindBy (name="province_licensed")
	WebElement provLicensedElement;
	
	@FindBy(name="driving_licence_no")
	WebElement driveLicenseElement;
	
	@FindBy(name="sin_no")
	WebElement sinNoElement;
	
	@FindBy(name="fax")
	WebElement faxElement;
	
	@FindBy(xpath="//a[contains(text(),'Profile')]")
	WebElement profilePageLabel;
	
	@FindBy(name="licence_no")
	WebElement licenseNo;
	
	@FindBy(xpath="//input[contains(text(), 'licence_expiry_date')]")
	WebElement licenseExpDate;
	
	@FindBy(name="e_o_policy_no")
    WebElement eoPolicyNo;
	
	@FindBy(name="e_o_policy_expiry_date")
	WebElement eoPolicyExpDate;
	
	@FindBy(name="corporation_name")
	WebElement corpName;
	
	@FindBy(name="bin_no_of_corporation")
	WebElement binNoCorpElement;
	
	@FindBy (name="corporation_licence_expiry_date")
	WebElement corpLicenseExpDate;
	
	@FindBy (name="e_o_corporation_name")
	WebElement eoCorpName;
	
	@FindBy(name="corporation_e_o_policy_expiry_date")
	WebElement cropEOpolicyExpDate;
	
	@FindBy (name="reference_name_1")
	WebElement refName1;
	
	@FindBy(name="reference_name_2")
	WebElement refName2;
	
	@FindBy(name="reference_name_3")
	WebElement refName3;
	
	@FindBy(name="reference_email_1")
	WebElement refEmail1;
	
	@FindBy (name="reference_email_2")
	WebElement refEmail2;
	
	@FindBy(name="reference_email_3")
	WebElement refEmail3;
	
	@FindBy(name="reference_contact_no_1")
	WebElement refContactNo1;
	
	@FindBy(name="reference_contact_no_2")
	WebElement refContactNo2;
	
	@FindBy(name="reference_contact_no_3")
	WebElement refContactNo3;
	
	@FindBy(name="reference_address_1")
	WebElement refAddress1;
	
	@FindBy(name="reference_address_2")
	WebElement refAddress2;
	
	@FindBy(name="reference_address_3")
	WebElement refAddress3;
	
	@FindBy(xpath="//a[contains(text(), 'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath="//a[@class, 'btn btn-primary']")
	WebElement licSaveBtn;
	
	@FindBy(name="bank_name")
	WebElement bankName;
	
	@FindBy(name="account_no")
	WebElement accNo;
	
	@FindBy (name="institution_no")
	WebElement institutionNo;
	
	@FindBy(name="transit_no")
	WebElement transitNo;
	
	@FindBy(name="Provider")
	WebElement chooseBtnLic;
	
	//Initialization
	public ProfilePage() {
		PageFactory.initElements(driver, this);	
		
	}
	
// Actions (Methods)
	public boolean verifyProfileLabel() {
		return profilePageLabel.isDisplayed();
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	
	public void enterPersonalDetails(String firstName, String lastName, String website, String address, String provlic, 
			String driverlicNo, String sinno, String fax) {
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);
		websiteElement.sendKeys(website);
		addressElement.sendKeys(address);
		provLicensedElement.sendKeys(provlic);
		driveLicenseElement.sendKeys(driverlicNo);
		sinNoElement.sendKeys(sinno);
		faxElement.sendKeys(fax);
		
		
}
	public void enterReferenceDetails(String refNameOne, String refNameTwo, String refNameThree, String refEmailOne, 
			String refEmailTwo, String refEmailThree, String refContOne, String refContTwo, String refContThree, 
			String addressOne, String addressTwo, String addressThree) {
		refName1.sendKeys(refNameOne);
		refName2.sendKeys(refNameTwo);
		refName3.sendKeys(refNameThree);
		refEmail1.sendKeys(refEmailOne);
		refEmail2.sendKeys(refEmailTwo);
		refEmail3.sendKeys(refEmailThree);
		refContactNo1.sendKeys(refContOne);
		refContactNo2.sendKeys(refContTwo);
		refContactNo3.sendKeys(refContThree);
		refAddress1.sendKeys(addressOne);
		refAddress2.sendKeys(addressTwo);
		refAddress3.sendKeys(addressThree);
		
		
	}
	public void clickOnProfileTab() {
		profilePageLabel.click();
	}
	
	public void enterLicenseDetails(String licno, String licExpDate, String policyNum, String policyExpDate ) {
		licenseNo.sendKeys(licno);
		licenseExpDate.sendKeys(licExpDate);
		eoPolicyNo.sendKeys(policyNum);
		eoPolicyExpDate.sendKeys(policyExpDate);
	}
	public void clickOnLicSaveButton() {
		licSaveBtn.click();
	}

	public void fileUploadLicDetails() {
		chooseBtnLic.click();
	
		
	}
	
		
	}

