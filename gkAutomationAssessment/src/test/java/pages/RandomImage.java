package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RandomImage {
	//initializing the webdriver
	WebDriver driver;
	
	//below, I'm finding the page elements via their attributes & @FindBy 
	//assigning a variable name to them
	@FindBy(id = "all")
	WebElement pageTitleFetch; 
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/a")
	public
	WebElement fetchBtn;

	@FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[2]/div")
	WebElement generatedDogImg;

	public RandomImage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//The below are methods of actions I would like to complete on the webpag
	public void fetchTitleDisplayed() {
		pageTitleFetch.isDisplayed();
	}
	
	public void dogImageExists() {
		generatedDogImg.isDisplayed();
	}
	
	public void fetchBtnDisplayed() {
		fetchBtn.isDisplayed();
	}
	
	public void clickFetchBtn() {
		fetchBtn.click();
	}

}
