package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {
	public static void main(String[] args) {
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
		//Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(listwindow.get(1));
	//click on the confirm button in the redirecting page
		WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Confirm']"));
		confirmButton.click();
		//Get the title
		System.out.println(driver.getTitle());
		driver.close();
	//Get back to the parent window
		driver.switchTo().window(listwindow.get(0));
		System.out.println(driver.getTitle());
		//close the browser
		driver.close();
	
	}
}
