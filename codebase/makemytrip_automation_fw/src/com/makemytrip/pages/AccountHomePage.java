//author : sachin singh chauhan

package com.makemytrip.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccountHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(xpath ="//div[@id='root']//ul/li[@data-cy='account']//p")
	WebElement linkUserName;
	
	@FindBy(xpath = "//p[text()='My Profile']/parent::div/parent::a")
	WebElement linkMyprofile;
	
	@FindBy(xpath = "//div[contains(@class, 'landingContainer')]//li//preceding::a/img[contains(@alt, 'Make My Trip')]")
	WebElement linkAccountHomePage;
	
	@FindBy(xpath = "//span[@class='logoContainer']//following-sibling::nav//span[text()='Hotels']")
	WebElement linkMenuHotel;
	
	@FindBy(xpath = "//div[@id='root']//input[@id='city']/..")
	WebElement linkMenuCity;
	
	@FindBy(xpath = "//input[@id='city']/../following-sibling::div//input")
	WebElement searchBoxCitySelection;
	
	@FindBy(xpath = "//input[@id='checkin']/..")
	WebElement dropDownCheckin;
	
	
	public AccountHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	public String getUserName() throws InterruptedException{
		//Thread.sleep(3000);
		//WebElement userName = driver.findElement(By.xpath("//div[contains(@class, 'landingContainer')]//li//div/p[contains(text(),'Hi')]"));
		String userName = "//div[contains(@class, 'landingContainer')]//li//div/p[contains(text(),'Hi')]";
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userName))).getText();
		
	}
	
	public void goToMyProfile() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(linkUserName));
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.moveToElement(linkUserName).build().perform();
		wait.until(ExpectedConditions.visibilityOf(linkMyprofile)).click();
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", linkUserName);
		//js.executeScript(, arg1)
		//js.executeScript("arguments[0].click();", usr);
		//wait.until(ExpectedConditions.visibilityOf(linkMyprofile)).click();
		
	}
	
	public void clickOnHomeButton() {
		wait.until(ExpectedConditions.visibilityOf(linkAccountHomePage)).click();
	}
	
	public void clickOnMenuHotel() throws InterruptedException{
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.elementToBeClickable(linkMenuHotel)).click();
		wait.until(ExpectedConditions.visibilityOf(linkMenuHotel)).click();
	}
	
	public void searchHotel() {
		wait.until(ExpectedConditions.visibilityOf(linkMenuCity)).click();
		wait.until(ExpectedConditions.visibilityOf(searchBoxCitySelection)).sendKeys("Gwalior");
		
		String cityName= "//span[text()='City']/preceding-sibling::div/p[contains(text(), 'Gwalior')]/../..";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityName))).click();
		
		//wait.until(ExpectedConditions.visibilityOf(dropDownCheckin)).click();
		
		
		
	}
	
}
