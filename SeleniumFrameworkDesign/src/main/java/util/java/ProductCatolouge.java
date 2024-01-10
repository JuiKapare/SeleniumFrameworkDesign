package util.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.java.AbstractComponents;

public class ProductCatolouge extends AbstractComponents
{

	WebDriver driver;
	
	public ProductCatolouge(WebDriver driver)//send driver from main method
	{
		super(driver); //since got from parent to child
		//initialization
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By listaddress = By.cssSelector(".mb-3");
	By prodaddress = By.cssSelector("b");
	By addprod     = By.cssSelector(".card-body button:last-of-type");
	By toastMsg    = By.cssSelector("#toast-container");
	
	public List<WebElement> getProducts() // method to get list of all the products pr items
	{
		waitForElementToAppear(listaddress);
		return products;
	}
	
	public WebElement getProductName(String productname)
	{
		WebElement prod = products.stream().filter(s->
		   s.findElement(prodaddress).getText().equals(productname)).findFirst().orElse(null); //searching for iphone item
		return prod;
	}
	
	public void addToCart(String productname) throws InterruptedException
	{
		WebElement prod = getProductName(productname); //called the method which gives actual product in this method 
		prod.findElement(addprod).click(); //clicking on add to cart of iphone item
		waitForElementToAppear(toastMsg); //wait until product added toast msg displayed 
		waitForElementToDisappear(spinner);
		
	}
	
	
	
}

//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

/*WebElement prod = products.stream().filter(s->
s.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null); //searching for iphone item
prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); //clicking on add to cart of iphone item */
  		
//add explicit wait till the msg appears
/* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //in AbstractComponents
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));//wait until product added toast msg displayed
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));// wait till the loading time is over*/
//all above code is done by line no.48