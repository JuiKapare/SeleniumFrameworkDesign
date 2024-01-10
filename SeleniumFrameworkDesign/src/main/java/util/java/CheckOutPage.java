package util.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractcomponents.java.AbstractComponents;

public class CheckOutPage extends AbstractComponents
{
	WebDriver driver;

	    public CheckOutPage(WebDriver driver) 
	    {  
	    	//constructor of this class 
		super(driver);//since got from parent to child
		this.driver =driver;
		
		PageFactory.initElements(driver, this);
	   }
   
	    
	    @FindBy(css=".input.ddl:first-of-type")
	    WebElement options;
	    
	    @FindBy(css=".input.ddl:last-of-type")
	    WebElement op;
	    
	    @FindBy(css="input[placeholder*='Country']")
	    WebElement act;
	    
	    @FindBy(css=".ta-item:nth-child(3)")
	    WebElement tapcountry;
	    
	    @FindBy(css=".action__submit")
	    WebElement submit;

	    
	    By dropdownLoad = By.cssSelector(".ta-results");
	    
	    public void selectDatenYear()
	    {
	    	Select date = new Select(options);
	    	date.selectByVisibleText("05");
	    	
	    	 Select year = new Select(op);
	 	    year.selectByVisibleText("20");
	    }
	    
	    
	    public void TaponCountry(String countryname)
	    {
	    	Actions a = new Actions(driver);
	    	a.sendKeys(act,countryname).build().perform();
	    	waitForElementToAppear(dropdownLoad);
	    	tapcountry.click();
	    	
	    }
	    
	    
	    public void placeOrder()
	    {
	    	submit.click();
	    }
	    
	    //WebElement options = driver.findElement(By.cssSelector(".input.ddl:first-of-type"));
	    //Select date = new Select(options);
	    //date.selectByVisibleText("05");
	    
	   // WebElement op = driver.findElement(By.cssSelector(".input.ddl:last-of-type"));
	    //Select year = new Select(op);
	   // year.selectByVisibleText("20");
	    
	    //select country using Action class
	    
	    //Actions a = new Actions(driver);
	   // a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Country']")), "India").build().perform();//taps on select country dropdown and enters India
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));//wait till the dropdown is loaded
	    
	    //driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();//tap on India
	    
	    
	    //driver.findElement(By.cssSelector(".action__submit")).click();//tap on place order
	    
	
	
}
