package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {
	
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
		//Switch to the next window using Windowhandles.
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> listwindow=new ArrayList<String>(windowHandles);
				driver.switchTo().window(listwindow.get(1));
		//click on the confirm button in the redirecting page
				WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Confirm']"));
				confirmButton.click();
		//Click Resources and mouse hover on Learning On Trailhead
				driver.findElement(By.linkText("Resources")).click();
				System.out.println(driver.getCurrentUrl());
Actions builder= new Actions(driver);

Shadow sd= new Shadow(driver);
WebElement learning = sd.findElementByXPath("//span[text()='Learning']");
learning.click();
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
Thread.sleep(5000);
WebElement learningTrail = sd.findElementByXPath("//span[text()='Learning on Trailhead']");

builder.moveToElement(learningTrail).build().perform();

//Clilck on Salesforce Certifications
sd.findElementByXPath("//a[text()='Salesforce Certification']").click();

//Click on Ceritification Administrator
driver.findElement(By.xpath("//a[text()='Administrator']")).click();

//Navigate to Certification - Administrator Overview window
//Verify the Certifications available for Administrator Certifications should be displayed


 List<WebElement> cert = driver.findElements(By.xpath("//div[text()='Certification']/following-sibling::div/a"));
for(int i=0;i<cert.size();i++)
{
	System.out.println(cert.get(i).getText());
}






				
		
}
}
