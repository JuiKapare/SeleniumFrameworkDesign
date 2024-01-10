package automation.tests;
import java.time.Duration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.java.CartPage;
import util.java.CheckOutPage;
import util.java.ConfirmationPage;
import util.java.LandingPage;
import util.java.ProductCatolouge;

public class PageObjectmodel 
{

		public static void main(String[] args) throws InterruptedException
		
		{
			String productname = "IPHONE 13 PRO";
			String countryname = "india";
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			LandingPage lp = new LandingPage(driver); // created object of landing class and passed driver as argument
			
			lp.goTo(); //initiating website url using goTo method from LandingPage class
			
			lp.loginprocess("bellah@gmail.com", "Bella@12"); //below three lines are in this line
			

			ProductCatolouge productcat = new ProductCatolouge(driver); //creating object of ProductCatolouge class to call the methods
			List<WebElement> products = productcat.getProducts(); // calling the  list of products 
			
			
		    
		    productcat.addToCart(productname);//clicking on add to cart the desired product  by calling addToCart method from ProductCatolouge class
		    
		      
		    
		    
		    productcat.goToCartPage(); //click on Cart logo to navigate cart page
		    
		    
		    CartPage cp = new CartPage(driver);
		    cp.TapOncheckOut();
		    
	
		    
		    CheckOutPage ck = new CheckOutPage(driver);
		    ck.selectDatenYear();
		    
		   
		    ck.TaponCountry(countryname);
		    
		    
		    ck.placeOrder();
		    
		    ConfirmationPage co = new ConfirmationPage(driver);
		    String actualText = co.getConfirmationMsg(); //get text present on screen
		    Assert.assertTrue(actualText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//if the actual text is in captial on website and expected is camel case or small letters in html
		   driver.close();
		   
		    
		      
			
		}

	}


