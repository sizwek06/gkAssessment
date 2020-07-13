package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//initializing the webdriver
	WebDriver driver;
	
	//below, I'm finding the page elements via their attributes & @FindBy 
	//assigning a variable name to them
	@FindBy(xpath = "/html/body/div[3]/h3[1]")
	WebElement pageTitleDoge;
	
	@FindBy(linkText = "https://dog.ceo/dog-api/")
	WebElement dogLogoImg;
	
	@FindBy(xpath = "/html/body/div[2]/ul/li[1]/a")
	public
	WebElement documentationLink;
	
	@FindBy(xpath = "/html/body/div[3]/ul/li[2]/a")
	WebElement randomImageLink;
	
	@FindBy(xpath = "/html/body/div[3]/ul/li[5]/a")
	WebElement browseBreedList;
	
	@FindBy(id = "mce-EMAIL")
	WebElement emailField; 
	
	@FindBy(id = "\"mc-embedded-subscribe\"")
	WebElement joinBtn;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//this init elements creates all the webElements on the PageFactory
	}
	
	//The below are methods of actions I would like to complete on the webpage
	//setEmailAddress takes the email field above, sends the parameterized keys to the field.
	//the clickDocLink for example, will click on the element specified within i.e. documentationLink
	//finally the getPageTitle retrieves the text attribute from the specified element and uses it later on.
	public void setEmailAddress(String emailAddress) {
		emailField.sendKeys(emailAddress);
	}
	
	public void clickRandomImage() {
		randomImageLink.click();
	}
	
	public void clickDocLink() {
		documentationLink.click();
	}
	
	public void clickBrowseBreedList() {
		browseBreedList.click();
	}
	
	public void clickJoinBtn() {
		joinBtn.click();
	}
	
	public String getPageTitle() {
		return pageTitleDoge.getText();
	}
	
	
}
