package automation.tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.java.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/client/");
		
		//LandingPage lp = new LandingPage(driver); // created object of landing class and passed driver as argument
		
		driver.findElement(By.id("userEmail")).sendKeys("bellah@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Bella@12");
		driver.findElement(By.id("login")).click();
		
		
		
	    List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	    
	   WebElement prod = products.stream().filter(s->
	   s.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null); //searching for iphone item
	   prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); //clicking on add to cart of iphone item
	    		
	    
	   /*for(int i=0; i<products.size();i++)
	    {
	    	String item = products.get(i).getText();
	    	
	    	if(item.contains("IPHONE"))
	    	{
	    		driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	    		break;
	    	}
	    }*/
	
	    
	    
	    //add explicit wait till the msg appears
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));//wait until product added toast msg displayed
	    
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));// wait till the loading time is over
	    driver.findElement(By.cssSelector("[routerlink*='cart']")).click(); // click on cart
	    
	    driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();//click on checkout
	    
	    //select expiry date
	    WebElement options = driver.findElement(By.cssSelector(".input.ddl:first-of-type"));
	    Select date = new Select(options);
	    date.selectByVisibleText("05");
	    
	    WebElement op = driver.findElement(By.cssSelector(".input.ddl:last-of-type"));
	    Select year = new Select(op);
	    year.selectByVisibleText("20");
	    
	    //select country using Action class
	    
	    Actions a = new Actions(driver);
	    a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Country']")), "India").build().perform();//taps on select country dropdown and enters India
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));//wait till the dropdown is loaded
	    
	    driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();//tap on India
	    
	    
	    driver.findElement(By.cssSelector(".action__submit")).click();//tap on place order
	    
	    
	   String actualText = driver.findElement(By.cssSelector(".hero-primary")).getText();//get text present on screen
	   Assert.assertTrue(actualText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//if the actual text is in captial on website and expected is camel case or small letters in html
	   driver.close();
	   
	    
	    
	    
	    
		
	}

}
