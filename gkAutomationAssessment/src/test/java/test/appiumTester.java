package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class appiumTester {
	AppiumDriver<MobileElement> driver;

@BeforeTest
	  public void setup () throws MalformedURLException {
	  		DesiredCapabilities caps = new DesiredCapabilities();
	  		caps.setCapability("deviceName", "OnePlus ONEPLUS A6013");
	  		caps.setCapability("udid", "4e9562d0"); //Give Device ID of your mobile phone
	  		caps.setCapability("platformName", "Android");
	  		caps.setCapability("platformVersion", "10.0");
	  		caps.setCapability("appPackage", "com.example.android.uamp");
	  		caps.setCapability("appActivity", "com.example.android.uamp.ui.MusicPlayerActivity");
	  		caps.setCapability("noReset", "true");
	  		
			//Instantiate 00-Appium-00 Driver
			try {
				 driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
		
	  }
		
	  @Parameters({ "xpath" })
	  @Test
	  public void viewGenres(String xpath) {

		  //Find the Genre flat button & click on it
		  MobileElement genresFlatElement = (MobileElement) driver.findElementByXPath(xpath);
		  genresFlatElement.click();
		  
		//Make sure that Cinematic Genre is listed
		  MobileElement genresCinematicElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[2]");			 
		  genresCinematicElement.isDisplayed();
		  
		  //Make sure that Jazz Genre is listed
		  MobileElement genresJazzAndBluesElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[3]");
		  genresJazzAndBluesElement.isDisplayed();
		  
		//Make sure that Rock Genre is listed
		  MobileElement genresRockElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]");			 
		  genresRockElement.isDisplayed();
		  
		//Find & Click the back button to return to the first page
		  MobileElement backBtn = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
		  backBtn.click();
	  }
	  
	  @Parameters({ "pauseXpath" })
	  @Test
	  public void playRockSong(String pauseXpath) {
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		//Find the Genre flat button & click on it
		  MobileElement genresFlatElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout");
		  genresFlatElement.click();
		  
		  //Click the Rock Genre option
		  MobileElement genresRockElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]");			 
		  genresRockElement.click();
		  
		  //Click Play on a song
		  
		  String rockSongPlay = "(//android.widget.ImageView[@content-desc='Play item'])[2]";
		  MobileElement rockSongPlayBtn = (MobileElement) driver.findElementByXPath(rockSongPlay);
		  rockSongPlayBtn.click();
		  
		  //Listen to song
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(("com.example.android.uamp:id/fragment_playback_controls"))));
		  
		  //Expand & wait for the Play Area 
		  MobileElement playBar = (MobileElement) driver.findElementById("com.example.android.uamp:id/fragment_playback_controls");
		  playBar.click();
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(("com.example.android.uamp:id/line1"))));
		  
		  wait.until(ExpectedConditions.attributeToBe(By.id("com.example.android.uamp:id/startText"), "text", "00:10"));
		  
		  //Pause song
		  MobileElement playPauseBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\'play or pause\']");
		  playPauseBtn.click();
		  
	  }
	  
	  @Parameters({"playBtn", "backBtn"})
	  @Test
	  public void viewSongsAreDisplayed(String playBtn, String backBtn) {
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		//Find the Genre flat button & click on it
		 //App Navigation Tests items are displayed
		  
		 //Check Rock Songs
		  MobileElement genresFlatElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout");
		  genresFlatElement.click();
		  
		//Click the Rock Genre option
		  MobileElement genresRockElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]");			 
		  genresRockElement.click();
		 
		  MobileElement songPlayBtn = (MobileElement) driver.findElementByXPath(playBtn);
		  songPlayBtn.isDisplayed();
		  
		  //click back
		  MobileElement elementbackBtn = (MobileElement) driver.findElementByXPath(backBtn);
		  elementbackBtn.click();
		  
		  //Click the Cinematic Genre option
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(("com.example.android.uamp:id/list_view"))));
		  
		  MobileElement genresCinematicElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[2]");			 
		  genresCinematicElement.click();
		  
		 songPlayBtn.isDisplayed();
		  
		  //click back
		  elementbackBtn.click();
		  
		  //wait for page
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(("com.example.android.uamp:id/list_view"))));
		  
		  //Click the Cinematic Genre option
		  MobileElement genresJazzAndBluesElement = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[3]");
		  genresJazzAndBluesElement.click();
		  
		  //check song listed
		  songPlayBtn.isDisplayed();
		  
		  //click back
		  elementbackBtn.click();
	  }
}
