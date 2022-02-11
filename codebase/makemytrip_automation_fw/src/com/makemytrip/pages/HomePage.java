package com.makemytrip.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	@FindBy(xpath ="//div[contains(@class, 'landingContainer')]//ul//li/div/p[text()='Login or Create Account']//ancestor::li" )
	private WebElement btnLoginOrCreateAcc;
	
	@FindBy(xpath = "//section/form//input[@id='username']")
	private WebElement txtBoxUserName;
	
	@FindBy(xpath = "//section//span[text()='Continue']/parent::button")
	private WebElement btnContinue;
	
	@FindBy(xpath = "//section//a[text()='Reset Password']/../input[@id='password']")
	private WebElement txtBoxPassword;
	
	@FindBy(xpath = "//section//span[text()='Login']/parent::button")
	private WebElement btnLogin;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	public void login(String userName, String password) {
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(btnLoginOrCreateAcc));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		
		wait.until(ExpectedConditions.visibilityOf(txtBoxUserName)).sendKeys(userName);
		btnContinue.click();
		wait.until(ExpectedConditions.visibilityOf(txtBoxPassword)).sendKeys(password);
		btnLogin.click();
	}
	
	
	
}
