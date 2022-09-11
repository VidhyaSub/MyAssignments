package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class WindowLeafGrouds {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//i[contains(@class,'layout-menuitem-icon')])[4]")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'layout-menuitem-icon')])[7]")).click();
		
		//Click and Confirm new Window Opens		
		WebElement openWindow = driver.findElement(By.xpath("//span[text()='Open']//parent::button"));
		openWindow.click();
		
		
		Set<String> windowhand1=driver.getWindowHandles();
		List<String> windowhandone=new ArrayList<String>(windowhand1);
		driver.switchTo().window(windowhandone.get(1));
		if(driver.getTitle().equals("Dashboard"))
System.out.println("I confirm that the new window has opened on clicking 1st button in WebPage");
		driver.close();
		driver.switchTo().window(windowhandone.get(0));
		
		//Find the number of opened tabs
		WebElement openWindow2 = driver.findElement(By.xpath("//span[text()='Open Multiple']//parent::button"));
		openWindow2.click();
		
		
		Set<String> windowhand2=driver.getWindowHandles();
		List<String> windowhandtwo=new ArrayList<String>(windowhand2);
		System.out.println(windowhandtwo.size()+" is the count of the total tabs/window opened on clicking 2nd button in WebPage");
		System.out.println("The number of Opened tab's reference are as below");
		System.out.println(windowhandtwo);
		for(int i=1;i<windowhandtwo.size();i++)
		{
			driver.switchTo().window(windowhandtwo.get(i));
			driver.close();
		}
		driver.switchTo().window(windowhandtwo.get(0));
		
		//Close all windows except Primary
		WebElement openWindow3 = driver.findElement(By.xpath("//span[text()='Close Windows']//parent::button"));
		openWindow3.click();
		Set<String> windowhand4=driver.getWindowHandles();
		List<String> windowhandfour=new ArrayList<String>(windowhand4);
		driver.switchTo().window(windowhandfour.get(1));
		driver.close();
		driver.switchTo().window(windowhandfour.get(0));
		
		//Wait for 2 new tabs to open
		WebElement openWindow4 = driver.findElement(By.xpath("//span[text()='Open with delay']//parent::button"));
		openWindow4.click();
		Thread.sleep(2000);
		Set<String> windowhand3=driver.getWindowHandles();
		List<String> windowhandthree=new ArrayList<String>(windowhand3);
		System.out.println(windowhandthree.size()+" is the count of the total tabs/window opened on clicking 4th button in WebPage");
		for(int i=1;i<windowhandthree.size();i++)
		{
			driver.switchTo().window(windowhandthree.get(i));
			driver.close();
		}
	
		
}

}
