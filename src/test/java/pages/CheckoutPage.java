package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	@FindBy(id="s-name")
	WebElement name ;
	
	@FindBy(id="s-surname")
	WebElement surname;
	
	@FindBy(id="s-address")
	WebElement address;
	
	@FindBy(id="s-zipcode")
	WebElement zipcode;
	
	@FindBy(id ="s-city")
	WebElement city;
	
	@FindBy(id="s-company")
	WebElement company;
	
	@FindBy(id="asap")
	WebElement asap;
	
	@FindBy(xpath = "//button[contains(text(),'Buy')]")
	WebElement buy;
	
	@FindBy(xpath="//h1[text()='Checkout']")
	WebElement chk;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkHeading()
	{
		 return chk.getText();
	}
	
	
	public void buyItems()
	{
		name.sendKeys("Nandhana");
		surname.sendKeys("N");
		address.sendKeys("OMR");
		zipcode.sendKeys("628504");
		city.sendKeys("Chennai");
		company.sendKeys("zuci");
		asap.click();
		
		
		buy.click();
		
		
		
	}
	
}
