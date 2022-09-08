package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSeleinumBasics1 {
public static void main(String[] args)
{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps");
	driver.manage().window().maximize();
	WebElement elementUsername = driver.findElement(By.id("username"));
	elementUsername.sendKeys("DemoSalesManager");
	WebElement elementPassword = driver.findElement(By.name("PASSWORD"));
	elementPassword.sendKeys("crmsfa");
	WebElement elementLogin	 = driver.findElement(By.className("decorativeSubmit"));
	elementLogin.click();
	WebElement elementSuccessfulMessage = driver.findElement(By.tagName("h2"));
	String WelcomeMessage = elementSuccessfulMessage.getText();
	System.out.println(WelcomeMessage);
}
}
