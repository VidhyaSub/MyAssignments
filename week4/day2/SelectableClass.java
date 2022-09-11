package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableClass {
	public static void main(String[] args)
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/selectable/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Actions builder = new Actions(driver);
	
	WebElement frameElement = driver.findElement(By.className("demo-frame"));
	driver.switchTo().frame(frameElement);
	
	builder.keyDown(Keys.CONTROL);
	
	WebElement findElement1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
	WebElement findElement2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
	WebElement findElement3 = driver.findElement(By.xpath("//li[text()='Item 5']"));
	WebElement findElement4 = driver.findElement(By.xpath("//li[text()='Item 7']"));
	
	builder.click(findElement1);
	builder.click(findElement2);
	builder.click(findElement3);
	builder.click(findElement4);
	
	builder.keyUp(Keys.CONTROL).perform();
	
	}
}
