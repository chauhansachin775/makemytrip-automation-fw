  package com.makemytrip.tests;
  
  import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
  
  public class Experiments {
	  
	  WebDriver driver = new ChromeDriver();
	  
	  
  
	  public static void main(String[] args) throws MalformedURLException {
		  
		  WebDriver driver = new ChromeDriver();
		  
		  URL url = new URL("https://www.google.com");
		  driver.navigate().to(url);
		   
		    
		        
	/*
	 * @Test(description="This is testcase1") public void testcase1() {
	 * System.out.println("HR"); }
	 * 
	 * @Test(description="This is testcase2") public void testcase2() {
	 * System.out.println("Software Developer"); }
	 * 
	 * @Test(description="This is testcase3") public void testcase3() {
	 * System.out.println("QA Analyst"); }
	 * 
	 */ 
		/*
		 * DateFormatSymbols dt = new DateFormatSymbols(); String[] months =
		 * dt.getMonths();
		 * 
		 * for(String month : months) { System.out.println(month); }
		 */
		  
		  
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\work\\codebase\\webdriverbasics\\resources\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 * String url = "https://www.makemytrip.com"; driver.get(url);
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 20); String s =
		 * "//div[contains(@class, 'landingContainer')]//ul//li/div/p[text()='Login or Create Account']//ancestor::li"
		 * ; WebElement we =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
		 * 
		 * for (int i = 0; i < 2; i++) { we.click(); }
		 * 
		 * String we1 = "//section/form//input[@id='username']";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we1))).
		 * sendKeys("test.auto924@gmail.com");
		 * 
		 * String we2 = "//section//span[text()='Continue']/parent::button";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we2))).
		 * click();
		 * 
		 * String we3 =
		 * "//section//a[text()='Reset Password']/../input[@id='password']";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we3))).
		 * sendKeys("testingtiger#321");
		 * 
		 * String we4 = "//section//span[text()='Login']/parent::button";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we4))).
		 * click();
		 * 
		 * //String we5 = "//section//div[contains(@class, 'Close')]/span";
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we5))).
		 * click();
		 * 
		 * String we6 = "//div[@id='root']//ul/li[@data-cy='account']"; WebElement usr =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we6)));
		 * JavascriptExecutor js = (JavascriptExecutor)driver; //js.executeScript(arg0,
		 * arg1) js.executeScript("arguments[0].click();", usr); //Actions action = new
		 * Actions(driver); //action.moveToElement(element1).build().perform();
		 * 
		 * 
		 * String we7 = "//p[text()='My Profile']/parent::div/parent::a";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we7))).
		 * click();
		 * 
		 * String we8 =
		 * "//h3[text()='Profile']/../following-sibling::div//button[text()='Edit']";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we8))).
		 * click();
		 * 
		 * String we9 =
		 * "//form//label[text()='Full Name']/following-sibling::div/input"; WebElement
		 * element2 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we9)));
		 * String b = element2.getTagName(); System.out.println(b);
		 * 
		 * String c = element2.getAttribute("value"); System.out.println(c);
		 * 
		 * element2.sendKeys(Keys.CONTROL, "a"); element2.sendKeys(Keys.BACK_SPACE);
		 * element2.sendKeys("testing");
		 * 
		 * String we10 =
		 * "//h3[text()='Edit Profile']/../descendant::form//div[text()='Birthday']/following-sibling::div/child::div"
		 * ; wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we10))).
		 * click();
		 * 
		 * String we11 =
		 * "//div[text()='Birthday']//following-sibling::div//form//select[@name='year']";
		 * Select sc1 = new Select(driver.findElement(By.xpath(we11)));
		 * sc1.selectByValue("1990");
		 * 
		 * String we12 =
		 * "//div[text()='Birthday']//following-sibling::div//form//select[@name='month']";
		 * Select sc2 = new Select(driver.findElement(By.xpath(we12)));
		 * sc2.selectByVisibleText("May");
		 * 
		 * String we13 =
		 * "//div[text()='Birthday']//following-sibling::div//form/following-sibling::div//div[contains(@aria-label, '14')]"
		 * ; wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we13))).
		 * click();
		 * 
		 * String we14 = "//div[text()='Gender']/following-sibling::div/div";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we14))).
		 * click(); //Select sc3 = new Select(driver.findElement(By.xpath(we14)));
		 * //sc3.selectByVisibleText("Male"); String we15 =
		 * "//div[text()='Gender']/following-sibling::div/ul/li[text()='MALE']";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we15))).
		 * click();
		 * 
		 * String we16 = "//div[text()='Marital Status']/following-sibling::div/div";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we16))).
		 * click();
		 * 
		 * String we17 =
		 * "//div[text()='Marital Status']/following-sibling::div/ul/li[text()='SINGLE']"
		 * ; wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we17))).
		 * click();
		 * 
		 * String we18 = "//form//button[text()='save']";
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we18))).
		 * click();
		 */		}
	  
  }
		  
		
		/*
		 * Workbook wrkbook = null; File file = new File(
		 * "D:\\makemytrip_automation\\codebase\\makemytrip_automation_fw\\resources\\MakemytripTestData.xlsx"
		 * ); FileInputStream fis = new FileInputStream(file);
		 * 
		 * wrkbook = new XSSFWorkbook(fis);
		 * 
		 * Sheet sheet = wrkbook.getSheet("MakemytripTestData");
		 * 
		 * for(int i = 1; i <= sheet.getLastRowNum(); i++) { for(int j = 0; j <
		 * sheet.getRow(i).getLastCellNum(); j++) { Cell cell =
		 * sheet.getRow(i).getCell(j); String cellValue = cell.getStringCellValue();
		 * System.out.println(cellValue); } System.out.println(); }
		 */  
		  //wrkbook.close();
	
	/*
	 * @BeforeSuite public void beforeSuitExample() {
	 * System.out.println("this is beforeSuit method exe. of Experiment class"); }
	 * 
	 * @BeforeTest public void beforeTest() {
	 * System.out.println("this is beforeTest method exe. of Experiment class"); }
	 * 
	 * @BeforeClass public void beforeClass() {
	 * System.out.println("this is beforeClass method exe. of Experiment class"); }
	 * 
	 * @BeforeMethod public void beforeMethod() { System.out.
	 * println("this is beforeMethod exe. it I'll exe after every @test method"); }
	 * 
	 * @Test public void test_1() {
	 * System.out.println("this is the first test case of Experiment class"); }
	 * 
	 * @Test public void test_2() {
	 * System.out.println("this is the second test case of Experiment class"); }
	 * 
	 * @Test public void test_3() {
	 * System.out.println("this is the third test case of Experiment class"); }
	 * 
	 * }
	 * 
	 * class Sample {
	 * 
	 * @BeforeTest public void beforeTest() {
	 * System.out.println("this is beforeTest method exe. of Sample class"); }
	 * 
	 * @BeforeClass public void beforeClass() {
	 * System.out.println("this is beforeClass method exe. of Sample class"); }
	 * 
	 * @BeforeMethod public void beforeMethod() { System.out.
	 * println("this is beforeMethod exe. it I'll exe after every @test method"); }
	 * 
	 * @Test public void test_1() {
	 * System.out.println("this is the first test case of Sample class"); }
	 * 
	 * @Test public void test_2() {
	 * System.out.println("this is the second test case of Sample class"); }
	 * 
	 * @Test public void test_3() {
	 * System.out.println("this is the third test case of Sample class"); }
	 */
	  
	  
	

