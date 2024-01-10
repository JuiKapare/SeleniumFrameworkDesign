package abstractcomponents.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents 
{
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) //initializing driver from main method or test file
	{
        
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForElementToAppear(By findele) //here it was just By.
	{
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findele)); //variable to avoid hardcode
	
    }
	
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException// here it was driver.findBy ( WebElement ele)
	{
		//4-5 second wait --due to application issue
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOf(ele));////variable to avoid hardcode
		Thread.sleep(5000);
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartadder;
	
	public void goToCartPage()
	{
		cartadder.click();
	}
}


//driver.findElement(By.cssSelector("[routerlink*='cart']")).click(); // click on cart logo