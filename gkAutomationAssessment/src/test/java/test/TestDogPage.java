package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class TestDogPage {
	
	String driverLocation = "C:\\chromedriver.exe";
	
	WebDriver driver;
	
	HomePage objHomePage;
	RandomImage objRandomPage;
	BreedsListPage objBreedsList;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dog.ceo/dog-api/");
		
	}
	//TEST O1 HOME PAGE OPENS SUCCESSFULLY HEADER LOADED
	@Test(priority = 0)
	public void goToHomePage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		objHomePage = new HomePage(driver);

		//wait for page
		wait.until(ExpectedConditions.elementToBeClickable(objHomePage.documentationLink));
		objHomePage.clickDocLink();
		
		String pageTitleDoge = objHomePage.getPageTitle();
		
		Assert.assertTrue(pageTitleDoge.toUpperCase().contains("ENDPOINTS"));
		
	}
	//TEST 02 CLICK RANDOM IMAGE LINK
	// CLICK FETCH & WAIT FOR IMAGE TO LOAD
	
	@Test(priority = 1)
	public void retrieveRandomImage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		objHomePage = new HomePage(driver);
		objRandomPage = new RandomImage(driver);
		//wait for page
		wait.until(ExpectedConditions.elementToBeClickable(objHomePage.documentationLink));
		objHomePage.clickDocLink();
		
		objHomePage.clickRandomImage();
		
		wait.until(ExpectedConditions.elementToBeClickable(objRandomPage.fetchBtn));
		objRandomPage.clickFetchBtn();
		
		objRandomPage.dogImageExists();
		
	}
	
	//TEST 03 CLICK BROWSE BREED LIST
	//SEND TEXT TO BREED SECTION
	//CLICK FETCH & WAIT FOR THE IMAGE TO LOAD
	
	@Test(priority = 2)
	public void retrieveDesiredBreed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		objHomePage = new HomePage(driver);
		objBreedsList = new BreedsListPage(driver);
		//wait for page
		wait.until(ExpectedConditions.elementToBeClickable(objHomePage.documentationLink));
		
		objHomePage.clickDocLink();
		objHomePage.clickBrowseBreedList();
		
		wait.until(ExpectedConditions.elementToBeClickable(objBreedsList.dropDogBreed));
		//set variable for dogBreed
		String dogBreed = "Shiba";
		
		objBreedsList.setSelectText(dogBreed);
		
		objBreedsList.dogImageExists();
		
		objBreedsList.clickFetchBtn();
	}
	
	//TEST 04 enter and submit email address
		
	@Test(priority = 3)
	public void enterAnEmailAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		objHomePage = new HomePage(driver);

		//wait for page
		wait.until(ExpectedConditions.elementToBeClickable(objHomePage.documentationLink));
		objHomePage.clickDocLink();
		
		String pageTitleDoge = objHomePage.getPageTitle();
		
		objHomePage.setEmailAddress("test@test.com");
//		objHomePage.clickJoinBtn();
	}

		@AfterTest
		public void closeDriver() {
		driver.close();
	}
	
	//Enter email address in home
}
