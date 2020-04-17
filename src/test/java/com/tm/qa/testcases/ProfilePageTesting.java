package com.tm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tm.qa.base.BaseClass1;
import com.tm.qa.pages.HomePage;
import com.tm.qa.pages.ProfilePage;

public class ProfilePageTesting extends BaseClass1{

	ProfilePage profilePage;
	HomePage homePage;
	SoftAssert  softAssert;
	
	public ProfilePageTesting() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		profilePage= new ProfilePage();
		
	}
	
	@Test (priority=1)
	public void profilePageTitleTest() {
		boolean title= profilePage.verifyProfileLabel();
		Assert.assertEquals(title, "Travel Medicare");
	}
	
	@Test (priority=2)
	public void allFieldsValidTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.assertAll();
		
}
	@Test (priority=3)
	public void duplicateReferenceNamesTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "John Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
		softAssert.fail();
	}
	@Test (priority=4)
	public void invalidReferenceNameTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith100", "Michael Smith34", "Tom Peter67", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
		softAssert.fail();
	}
	
	@Test (priority=5)
	public void invalidReferenceEmailTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmithgmail.com", "msmithgmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.assertAll();
	}
	
	@Test (priority=6)
	public void invalidRefNameswithSpecialCharTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith!", "$Michael Smith", "Tom %Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.assertAll();
	}
	
	@Test (priority=7)
	public void duplicateEmailTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "jsmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=8)
	public void duplicateContactNoTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "4166554455", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=9)
	public void contactNoOverTenDigitsTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=10)
	public void allFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "", "", "",
				"", "", "", "", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=11)
	public void invalidRefAddressTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "$45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=12)
	public void invalidRefAddressNoProvOrPostalTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres", 
				"54 Roundhouse Cres", "99 Selenium St");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=13)
	public void noNumInAddressTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "Laketown Cres, Toronto, ON, M4E 0S7", 
				"Roundhouse Cres, Toronto, ON, M2J 7S9", "Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=14)
	public void allFieldsDuplicatedTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "John Smith", "John Smith", "jsmith@gmail.com", "jsmith@gmail.com",
				"jsmith@gmail.com", "9056789090", "9056789090", "9056789090", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"45 Laketown Cres, Toronto, ON, M4E 0S7", "45 Laketown Cres, Toronto, ON, M4E 0S7");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=15)
	public void referenceNameOneAllOtherFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "", "", "", "",
				"", "", "", "", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=16)
	public void referenceNameTwoAllOtherFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "Joe Smith", "", "", "",
				"", "", "", "", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=17)
	public void referenceNameThreeAllOtherFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "Tom Peter", "", "",
				"", "", "", "", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=18)
	public void referenceEmailOneAllOtherFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "", "jsmith@gmail.com", "",
				"", "", "", "", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=19)
	public void referenceEmailTwoAllOtherFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "", "", "msmith@gmail.com",
				"", "", "", "", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=20)
	public void referenceEmailThreeAllOtherFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "", "", "",
				"tpeter@gmail.com", "", "", "", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=21)
	public void refContactOneTest(){
	profilePage.enterReferenceDetails("", "", "", "", "",
			"", "4166554455", "", "", "", 
			"", "");
	profilePage.clickOnSaveBtn();
    softAssert.fail();
	}
	@Test (priority=22)
	public void refContactTwoTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "", "", "",
				"", "", "4379098787", "", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=23)
	public void refContactThreeTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "", "", "",
				"", "", "", "4167079090", "", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=24)
	public void refAddressOneTest() {
			profilePage.clickOnProfileTab();
			profilePage.enterReferenceDetails("", "", "", "", "",
					"", "", "", "", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
					"", "");
			profilePage.clickOnSaveBtn();
		    softAssert.fail();
	}
	@Test (priority=25)
	public void refAddressTwoTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "", "", "",
				"", "", "", "", "", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=26)
	public void refAddressThreeTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "", "", "",
				"", "", "", "", "", 
				"", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=27)
	public void referenceOneTest() {
		profilePage.clickOnProfileTab();;
		profilePage.enterReferenceDetails("John Smith", "", "", "jsmith@gmail.com", "",
				"", "4166554455", "", "", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	
	@Test (priority=28)
	public void referenceTwoTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "Michael Smith", "", "", "9056789091",
				"", "", "9056789091", "", "", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	
	@Test (priority=29)
	public void referenceThreeTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "", "Tom Peter", "", "",
				"tpeter@gmail.com", "", "", "9056789089", "", 
				"", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=30)
	public void refNameOneEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, ON, M2J 7S9", "99 Selenium St, Toronto, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=31)
	public void noPostalCodeTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, ON", 
				"54 Roundhouse Cres, Toronto, ON", "99 Selenium St, Toronto, ON");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=32)
	public void noProvinceInAddressTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, Toronto, M4E 0S7", 
				"54 Roundhouse Cres, Toronto, M2J 7S9", "99 Selenium St, Toronto, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=33)
	public void noCityOrTownInAddressTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterReferenceDetails("John Smith", "Michael Smith", "Tom Peter", "jsmith@gmail.com", "msmith@gmail.com",
				"tpeter@gmail.com", "4166554455", "9056789090", "4379098877", "45 Laketown Cres, ON, M4E 0S7", 
				"54 Roundhouse Cres, ON, M2J 7S9", "99 Selenium St, ON, M2J 9O8");
		profilePage.clickOnSaveBtn();
	    softAssert.fail();
	}
	@Test (priority=34)
	public void invalidLicenceNumberTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("HPQWERTY", "2019-12-31", "1010404050", "2020-03-27");
		profilePage.clickOnLicSaveButton();
		softAssert.fail();
	}
	@Test (priority=35)
	public void validLicenseTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("20209090", "2019-12-31", "1010404050", "2020-03-27");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=36)
	public void allFieldsEmptyLicTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("", "", "", "");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=37)
	public void invalidLicExpDateTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("34560987", "2019-10-09", "1010404050", "2020-03-27");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=38)
	public void invalidEOPolicyExpDateTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("98987878", "2019-10-09", "9090878654", "2019-10-31");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=39)
	public void eoPolicyNumberTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("98987878", "2019-10-09", "9090878654", "2020-10-31");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=40)
	public void allLicFieldsInvalid() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("123456789", "2019-01-11", "qwertyabcd", "2019-01-31");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=41)
	public void saveButtonTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("12345678", "2019-12-11", "9090121234", "2019-12-31");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=42)
	public void fileUploadTest() {
		profilePage.clickOnProfileTab();
		profilePage.fileUploadLicDetails();
		softAssert.assertAll();
	}
	@Test (priority=43)
	public void sevenDigitLicNoTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("1234567", "2019-12-11", "9090121234", "2019-12-31");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=44)
	public void invalidLicExpGreaterThanTwoYears() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("90908787", "2023-12-11", "6789012345", "2020-01-31");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=45)
	public void eoPolicyNoLongTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("90908787", "2020-12-11", "123456789009876543219078563412", "2020-01-31");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=46)
	public void validLicAllOtherFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("90908787", "", "", "");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=47)
	public void vaildLicExpDateAllOtherFieldsEmptyTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("", "2020-12-31", "", "");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=48)
	public void eoPOlicyNoTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("", "", "24232336", "");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=49)
	public void eoExpDateTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("", "", "", "2020-09-09");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=50)
	public void validLicNoAndExpDateTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("87654321", "2020-09-09", "", "");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=51)
	public void policyNumAndExpDateTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("", "", "78679090", "2020-09-08");
		profilePage.clickOnLicSaveButton();
		softAssert.assertAll();
	}
	@Test (priority=52)
	public void licNumPolicyNumTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("87654321", "", "78679090", "");
		profilePage.clickOnLicSaveButton();
		softAssert.fail();
	}
	@Test (priority=53)
	public void licExpAndPolicyExpTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("", "2020-09-09", "", "2021-09-21");
		profilePage.clickOnLicSaveButton();
		softAssert.fail();
	}
	@Test (priority=54)
	public void licNoandPolicyExpDateTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("87654321", "", "", "2021-09-21");
		softAssert.fail();
		
	}
	@Test (priority=55)
	public void licExpDateAndPolicyNoTest() {
		profilePage.clickOnProfileTab();
		profilePage.enterLicenseDetails("", "2020-09-09", "89890000", "");
		profilePage.clickOnLicSaveButton();
		softAssert.fail();
	}
	
		@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

	
