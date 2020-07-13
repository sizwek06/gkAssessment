package pages;

import org.openqa.selenium.support.*;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BreedsListPage {
	//initializing the webdriver
	WebDriver driver;
	
	//below, I'm finding the page elements via their attributes & @FindBy 
	//assigning a variable name to them
	@FindBy(xpath = "/html/body/div[3]/h3")
	WebElement pageTitleFetch; 
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/a")
	public WebElement fetchBtn;

	@FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/img")
	public WebElement fetchedDogImg;

	@FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/span/select")
	public WebElement dropDogBreed;
	
	//The below are methods of actions I would like to complete on the webpage
	public BreedsListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fetchTitleDisplayed() {
		pageTitleFetch.isDisplayed();
	}
	
	public void dogImageExists() {
		fetchedDogImg.isDisplayed();
	}
	
	public void fetchBtnDisplayed() {
		fetchBtn.isDisplayed();
	}
	
	public void clickFetchBtn() {
		fetchBtn.click();
	}
	
	public void setSelectText(String dogBreed) {
	try {
	//create select for breed dropdown
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
    wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
        public Boolean apply(WebDriver driver)  
        {
            Select select = new Select(dropDogBreed);
            return select.getOptions().size()>1;

        }
    });
	
//	//ensure values are more than 1
    Select select = new Select(dropDogBreed); 
    select.selectByVisibleText(dogBreed);
	}catch(Throwable e){
	    System.out.println("Error found: "+e.getMessage());
	}
	}
}
