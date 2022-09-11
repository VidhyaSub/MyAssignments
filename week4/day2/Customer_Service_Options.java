package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Customer_Service_Options {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver= new ChromeDriver();
     	//Load the url as https://login.salesforce.com/
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter the username as ramkumar.ramaiah@testleaf.com
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("ramkumar.ramaiah@testleaf.com");
		//Enter the password as Password#123
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("Password#123");
		//click on the login button
		WebElement loginButton = driver.findElement(By.id("Login"));
		loginButton.click();
		//Click on the learn more option in the Mobile publisher
		WebElement mobPub = driver.findElement(By.xpath("//span[text()='Learn More']"));
		mobPub.click();
		Thread.sleep(5000);
		//Click on Products and Mousehover on Service 
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ls= new ArrayList<String>(windowHandles);
		driver.switchTo().window(ls.get(1));
		WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Confirm']"));
		confirmButton.click();
		Shadow sd= new Shadow(driver);
		WebElement products = sd.findElementByXPath("//span[text()='Products']");
	
		products.click();
	Thread.sleep(2000);
		WebElement service = sd.findElementByXPath("//span[text()='Service']");
		Actions builder=new Actions(driver);
		builder.moveToElement(service).build().perform();
		//Click on Customer Services
		Thread.sleep(2000);

		WebElement custSrvice = sd.findElementByXPath("//a[text()='Customer Service']");
		custSrvice.click();
		System.out.println("check");
		//Get the names Of Services Available 
		System.out.println("Please find below the List of services available");
		List<WebElement> serviceAvai = driver.findElements(By.xpath("//span[contains(text(),'earn more')]//ancestor::div[5]//span[contains(@class,'header-text')]"));
		for(int i=0;i<serviceAvai.size();i++)
		{
		System.out.println(serviceAvai.get(i).getText());
		}
		//Verify the title
		if (driver.getTitle().contains("Service"))
		{
			System.out.println(driver.getTitle());
		}
		else
		System.out.println("Error");
		
}

}
