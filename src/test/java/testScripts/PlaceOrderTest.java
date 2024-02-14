package testScripts;
 
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import base.TestBase;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;
 
public class PlaceOrderTest {
	WebDriver driver;
	HomePage homePage;
	SearchResultPage resultPage;
	ShoppingCartPage cartPage;
	CheckoutPage chkoutpage;
	
 
  public  PlaceOrderTest() {
	  TestBase.initDriver();
	  driver = TestBase.getDriver();
	  homePage = new HomePage(driver);
	  resultPage = new SearchResultPage(driver);
	  cartPage = new ShoppingCartPage(driver);
	  chkoutpage = new CheckoutPage(driver);
  }
  @BeforeTest
  public void setup()
  {
	  TestBase.openUrl("http://danube-webshop.herokuapp.com/");
  }
  @Test(priority = 1)
  public void addToCartTest()
  {
	  homePage.searchItem("Parry Hotter");
	  resultPage.viewItemDetail();
	  resultPage.addToCart();
	  boolean isAdded = cartPage.isItemAdded();
	  Assert.assertTrue(isAdded);
 
  }
  @Test(priority = 2)
  public void checkoutTest()
  {
	  cartPage.addCoupon();
	  cartPage.doCheckout();
	  
  }
  
  @Test(priority = 3)
  public void checkoutForm()
  {
	  String s = chkoutpage.checkHeading();
	  Assert.assertEquals(s,  "Checkout");
	  
	  
	  chkoutpage.buyItems();
	  
	  Assert.assertEquals(driver.getTitle(),"Danube WebShop");
  }
  
}