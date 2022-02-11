package com.makemytrip.tests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.makemytrip.pages.AccountHomePage;
import com.makemytrip.pages.HomePage;
import com.makemytrip.pages.MyProfilePage;
import com.makemytrip.utilities.Utility;

public class MyProfilePageTest extends BaseTest {
	

	@Test(priority=2)
	public void toVerifyEditProfileFunctionality() throws IOException, InterruptedException {
		HomePage homePage = new HomePage(getDriver());
		homePage.login(Utility.readTestData_1(2), Utility.readTestData_2(2));
		AccountHomePage accHomePage = new AccountHomePage(getDriver());
		accHomePage.goToMyProfile();
		
		
		MyProfilePage profilePage = new MyProfilePage(getDriver());
		profilePage.clickOnEditProfileButton();
		List<String> earlierProfileInfo = profilePage.getProfileInfo();
		profilePage.editProfile(Utility.readTestData_3(2), Utility.readTestData_4(2), Utility.readTestData_5(2), Utility.readTestData_6(2));
		
		accHomePage.clickOnHomeButton();
		accHomePage.goToMyProfile();
		
		profilePage.clickOnEditProfileButton();
		List<String> editedProfileInfo = profilePage.getProfileInfo();
		
		Boolean b = earlierProfileInfo.equals(editedProfileInfo);
		System.out.println("Result: "+b);
		
	}

}
