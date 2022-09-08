package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		//Add implicit wait
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	//create new create account button
		WebElement elementCreateNewAccount =driver.findElement(By.linkText("Create New Account"));	
		elementCreateNewAccount.click();
		
		//Enter the first name
		WebElement elementFirstName =driver.findElement(By.name("firstname"));	
		elementFirstName.sendKeys("Test");
		
		//Enter the last name
				WebElement elementLastName =driver.findElement(By.name("lastname"));	
				elementLastName.sendKeys("Leaf");
				
				//Enter the Mobile number
				WebElement elementMobileNumber =driver.findElement(By.name("reg_email__"));	
				elementMobileNumber.sendKeys("90876 54321");
				
				//Enter the password
				WebElement elementPassword =driver.findElement(By.id("password_step_input"));	
				elementPassword.sendKeys("Selenium@12");
				
				//Date of birth Dropdown
				WebElement elementday = driver.findElement(By.id("day"));
				   Select dayDOB = new Select(elementday);
				   dayDOB.selectByIndex(22);
					
				   WebElement elementmonth = driver.findElement(By.id("month"));
				  Select monthDOB = new Select(elementmonth);
				  monthDOB.selectByVisibleText("Dec");
				  
				  WebElement elementyear = driver.findElement(By.id("year"));
				 Select yearDOB = new Select(elementyear);
				 yearDOB.selectByValue("1998");
					
				 
				 //Select the radio button
				 WebElement elementRadio =driver.findElement(By.className("_58mt"));	
					elementRadio.click();
				 
				 
					WebElement elementSignup = driver.findElement(By.name("websubmit"));
					elementSignup.click();
				
		
	}

}
