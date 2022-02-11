//author : sachin singh chauhan


package com.makemytrip.tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.makemytrip.pages.AccountHomePage;
import com.makemytrip.pages.HomePage;
import com.makemytrip.pages.MyProfilePage;
import com.makemytrip.utilities.Utility;

public class HomePageTest extends BaseTest {
	
	//readTestData() is a static method in Utility class to read
	//the test data form excel file it consist one integer type argument.
	//this integer type argument represent testcase number.
	@Test(priority=1)
	public void toVerifyLoginFunctionality() throws IOException, InterruptedException{
		HomePage homePage = new HomePage(getDriver());
		homePage.login(Utility.readTestData_1(1), Utility.readTestData_2(1));
		AccountHomePage accHomePage = new AccountHomePage(getDriver());
		//accHomePage.getUserName();
		
		Utility.writeActualResult(accHomePage.getUserName(), 1);
		Assert.assertEquals(accHomePage.getUserName(), Utility.readExpectedResult(1),"Result is:");
	}
	
	@Test
	public void toVerifyHotelBookingFunctionality() throws IOException, InterruptedException{
		HomePage homePage = new HomePage(getDriver());
		homePage.login(Utility.readTestData_1(3), Utility.readTestData_2(3));
		
		AccountHomePage accHomePage = new AccountHomePage(getDriver());
		accHomePage.clickOnMenuHotel();
		accHomePage.searchHotel();
		
	}

}
