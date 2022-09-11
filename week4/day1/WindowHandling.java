package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class WindowHandling {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
	//1.Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//2. Enter UserName and Password Using Id Locator
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesmanager");
		
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("crmsfa");
		  
		//3. Click on Login Button using Class Locator
		WebElement loginButton=driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		  
		//4. Click on CRM/SFA Link
		WebElement crmLink=driver.findElement(By.partialLinkText("CRM/SFA"));
		crmLink.click();
		  
		// 5. Click on contacts Button
		WebElement contactButton=driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactButton.click();
		  	
		//  6. Click on Merge Contacts using Xpath Locator
		WebElement mergeButton=driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
		mergeButton.click();
		  
		//  7. Click on Widget of From Contact
		WebElement contactWidget=driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]"));
		contactWidget.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(listwindow.get(1));
		
		  
		//  8. Click on First Resulting Contact
		WebElement newWindowFirstContactResult=driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner')]//a)[1]"));
		newWindowFirstContactResult.click();
		
		//  9. Click on Widget of To Contact
		driver.switchTo().window(listwindow.get(0));
		WebElement toContactWidget=driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
		toContactWidget.click();
		Thread.sleep(3000);
		  
		// 10. Click on Second Resulting Contact
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listwindow2=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(listwindow2.get(1));		
		WebElement newWindowSecondContactResult=driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner')]//a)[6]"));
		newWindowSecondContactResult.click();
		  
		// 11. Click on Merge button using Xpath Locator
		driver.switchTo().window(listwindow2.get(0));
		WebElement mergeButton2=driver.findElement(By.xpath("//a[text()='Merge']"));
		mergeButton2.click();
		
		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		  
		//  13. Verify the title of the page
		System.out.println(driver.getTitle());
		
		if ((driver.getTitle()).contains("View Contact"))
			System.out.println("Control is shifted to expected window");
		else
			System.out.println("Failed");
		
		driver.close();
		
	}

}
