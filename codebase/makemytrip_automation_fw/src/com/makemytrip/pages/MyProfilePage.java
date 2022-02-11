package com.makemytrip.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.utilities.Calendar;

public class MyProfilePage {

	
	private WebDriver driver;
	private WebDriverWait wait;
	

	@FindBy(xpath = "//h3[text()='Profile']/../following-sibling::div//button[text()='Edit']")
	WebElement buttonEditProfile;

	@FindBy(xpath = "//form//label[text()='Full Name']/following-sibling::div/input")
	WebElement txtBoxFullName;
	
	
	//birthdat calender xpaths
	@FindBy(xpath = "//h3[text()='Edit Profile']/../descendant::form//div[text()='Birthday']/following-sibling::div/child::div")
	WebElement dropdownBirthDayCalender;

	@FindBy(xpath = "//div[text()='Birthday']//following-sibling::div//form//select[@name='year']")
	WebElement dropDownBirthDayYear;

	@FindBy(xpath = "//div[text()='Birthday']//following-sibling::div//form//select[@name='month']")
	WebElement dropDownBirthDayMonth;

	// put integer value in aria-label argument
	@FindBy(xpath = "//div[text()='Birthday']//following-sibling::div//form/following-sibling::div//div[contains(@aria-label, 'int')]")
	WebElement birthdayDateSelection;
	
	
	//gender selection dropdown xpath
	@FindBy(xpath = "//div[text()='Gender']/following-sibling::div/div")
	WebElement dropDownGender;


	//anniversary calender xpaths
	@FindBy(xpath = "//h3[text()='Edit Profile']/../descendant::form//div[text()='Anniversary']/following-sibling::div/child::div")
	WebElement dropDownAnnivCalender;
	
	@FindBy(xpath = "//div[text()='Anniversary']//following-sibling::div//form//select[@name='year']")
	WebElement dropDownAnnivYear;
	
	@FindBy(xpath = "//div[text()='Anniversary']//following-sibling::div//form//select[@name='month']")
	WebElement dropDownAnnivMonth;
	
	@FindBy(xpath = "//div[text()='Anniversary']//following-sibling::div//form/following-sibling::div//div[contains(@aria-label, 'int')]")
	WebElement AnnivDateSelection;
	
	//edit profile save button xpath
	@FindBy(xpath = "//form//button[text()='save']")
	WebElement btnSaveEditProfile;
	

	public MyProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	
	// date in dd/mm/yyy format
	public void editProfile(String fullName, String dob, String gender, String anniversaryDate) {

		String[] arr = dob.split("/");

		//wait.until(ExpectedConditions.visibilityOf(buttonEditProfile)).click();

		WebElement ele = wait.until(ExpectedConditions.visibilityOf(txtBoxFullName));

		ele.sendKeys(Keys.CONTROL, "a");
		ele.sendKeys(Keys.BACK_SPACE);
		ele.sendKeys(fullName);

		wait.until(ExpectedConditions.visibilityOf(dropdownBirthDayCalender)).click();
		;

		wait.until(ExpectedConditions.visibilityOf(dropDownBirthDayYear)).click();
		Select birthYear = new Select(dropDownBirthDayYear);
		birthYear.selectByValue(arr[2]);

		wait.until(ExpectedConditions.visibilityOf(dropDownBirthDayMonth)).click();
		Select birthMonth = new Select(dropDownBirthDayMonth);
		birthMonth.selectByVisibleText(Calendar.parseMonthNumToMonthName(arr[1]));
		// s2.selectByValue(Calendar.parseMonthNumToMonthName(arr[1]));

		Integer birthDateValue = Integer.valueOf(arr[0]);
		String birthDate = "//div[text()='Birthday']//following-sibling::div//form/following-sibling::div//div[contains(@aria-label, '"
				+ birthDateValue + "')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(birthDate))).click();
		// wait.until(ExpectedConditions.visibilityOf(dateSelection)).click();

		wait.until(ExpectedConditions.visibilityOf(dropDownGender)).click();
		String genderValue = "//div[text()='Gender']/following-sibling::div/ul/li[text()='" + gender + "']";
		// Select s3 = new Select(dropDownGender);
		// s3.selectByVisibleText(genderValue);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(genderValue))).click();
		
		String[] arr2 = anniversaryDate.split("/");
		
		wait.until(ExpectedConditions.visibilityOf(dropDownAnnivCalender)).click();
		
		wait.until(ExpectedConditions.visibilityOf(dropDownAnnivYear)).click();
		Select annivYear = new Select(dropDownAnnivYear);
		annivYear.selectByValue(arr2[2]);
		
		wait.until(ExpectedConditions.visibilityOf(dropDownAnnivMonth)).click();
		Select annivMonth = new Select(dropDownAnnivMonth);
		annivMonth.selectByVisibleText(Calendar.parseMonthNumToMonthName(arr2[1]));
		
		Integer annivDateValue = Integer.valueOf(arr2[0]);
		String annivDate = "//div[text()='Anniversary']//following-sibling::div//form/following-sibling::div//div[contains(@aria-label, '"+annivDateValue+"')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(annivDate))).click();
		
		wait.until(ExpectedConditions.visibilityOf(btnSaveEditProfile)).click();
		
	}
	
	public List<String> getProfileInfo() {
		List<String> profileInfo = new ArrayList<String>();
		profileInfo.add(0, wait.until(ExpectedConditions.visibilityOf(txtBoxFullName)).getAttribute("value"));
		profileInfo.add(1, wait.until(ExpectedConditions.visibilityOf(dropdownBirthDayCalender)).getText());
		profileInfo.add(2, wait.until(ExpectedConditions.visibilityOf(dropDownGender)).getText());
		profileInfo.add(3, wait.until(ExpectedConditions.visibilityOf(dropDownAnnivCalender)).getText());
		
		System.out.println(profileInfo.get(0));
		System.out.println(profileInfo.get(1));
		System.out.println(profileInfo.get(2));
		System.out.println(profileInfo.get(3));
		return profileInfo;
		
	}
	
	public void clickOnEditProfileButton() {
		wait.until(ExpectedConditions.visibilityOf(buttonEditProfile)).click();
	}

}
