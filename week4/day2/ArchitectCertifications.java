package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ArchitectCertifications {
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
		//Click  On Resources
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ls= new ArrayList<String>(windowHandles);
		driver.switchTo().window(ls.get(1));
		WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Confirm']"));
		confirmButton.click();
		WebElement resourceLink = driver.findElement(By.linkText("Resources"));
		resourceLink.click();
		//Select SalesForce Certification Under Learnings
	
		Shadow sd= new Shadow(driver);
		WebElement learning = sd.findElementByXPath("//span[text()='Learning']");
		learning.click();
		Actions builder= new Actions(driver);
		Thread.sleep(2000);
		WebElement trialHead = sd.findElementByXPath("//span[text()='Learning on Trailhead']");
		builder.moveToElement(trialHead).perform();
		//Choose Your Role as Salesforce Architect
		WebElement salesForceCertificate = sd.findElementByXPath("//a[text()='Salesforce Certification']");
		salesForceCertificate.click();
		//Choose Your Role as Salesforce Architect
		WebElement sfArchitect = driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]"));
		sfArchitect.click();
		//Get the Text(Summary) of Salesforce Architect 
		WebElement summarySFArchi = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following-sibling::div[1]"));
		System.out.println(" ");
		System.out.println(summarySFArchi.getText());
		System.out.println(" ");
		//Get the List of Salesforce Architect Certifications Available
		List<WebElement> cert = driver.findElements(By.xpath("//div[text()='Certification']/following-sibling::div[1]/a"));
		System.out.println("Below are the list of certifications for Salesforce Architect");
		System.out.println("---------------------------------------------------------------");
		for( int i=0;i<cert.size();i++)
		{
			System.out.println(cert.get(i).getText());
		}
		//Click on Application Architect 
		for( int i=0;i<cert.size();i++)
		{
		if(cert.get(i).getText().contains("Application Architect"));
		cert.get(i).click();
		//Get the List of Certifications available
		System.out.println("Below are the list of certifications for Application Architect");
		System.out.println("---------------------------------------------------------------");
		 List<WebElement> appArhCert = driver.findElements(By.xpath("//div[text()='Certification']/following-sibling::div[@class='credentials-card_title']/a"));
		for(int j=0;j<appArhCert.size();j++)
			System.out.println(appArhCert.get(j).getText());
		}
		driver.quit();
			
	}
}
