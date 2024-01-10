package util.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.java.AbstractComponents;

public class CartPage extends AbstractComponents 
{

   WebDriver driver;
	
	public CartPage(WebDriver driver)//send driver from main method
	{
		super(driver);//since got from parent to child
		//initialization
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkout;
	
	public void TapOncheckOut()
	{
		checkout.click();
	}
	
}


//driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();//click on checkout