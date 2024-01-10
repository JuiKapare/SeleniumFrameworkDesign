package util.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.java.AbstractComponents;

public class LandingPage extends AbstractComponents
{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)//send driver from main method
	{
		super(driver);
		//initialization
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.id("userEmail")).sendKeys("bellah@gmail.com");
	
	//PageFactory is exclusively used for driver.findelements only
	
	@FindBy(id="userEmail")
	WebElement userid;
	
	@FindBy(id="userPassword")
	WebElement userpass;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	//login process by entering email pass and hitting login btn
	public void loginprocess(String email, String password) //calling this method in PageObjectModel class using object of this class
	{
		userid.sendKeys(email);
		userpass.sendKeys(password);
		loginbtn.click();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
}

/*driver.findElement(By.id("userEmail")).sendKeys("bellah@gmail.com");
driver.findElement(By.id("userPassword")).sendKeys("Bella@12");
driver.findElement(By.id("login")).click();*/
//above part is in landing page