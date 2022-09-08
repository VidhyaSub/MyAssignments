package assignments.week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	
		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			//Creating instance of Chrome driver
			ChromeDriver driver = new ChromeDriver();
			//Launch URL "http://leaftaps.com/opentaps/control/login"
			driver.get("http://leaftaps.com/opentaps/control/login");
			//Maximizing window
			driver.manage().window().maximize();
			
			//Enter UserName and Password Using Id Locator
			//Click on Login Button using Class Locator		
			WebElement elementUserName = driver.findElement(By.id("username"));
			elementUserName.sendKeys("Demosalesmanager");
			WebElement elementPassword = driver.findElement(By.id("password"));
			elementPassword.sendKeys("crmsfa");
			WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
			elementLogin.click();
			
			WebElement elementWelcomeMessage = driver.findElement(By.tagName("h2"));
			String elementText = elementWelcomeMessage.getText();
			System.out.println(elementText);
			
			if(elementText.contains("Welcome")) {
				System.out.println("Successfully Login");
			}
			else {
				System.out.println("Login Case Failed");
			}
			
			//Click on CRM/SFA Link
			WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
			elementCRMSFA.click();
			Thread.sleep(1000);
			WebElement elementMyHome = driver.findElement(By.id("sectionHeaderTitle_myHome"));
			String elementHomePageText = elementMyHome.getText();
			System.out.println(elementHomePageText);	
			if(elementHomePageText.contains("My Home")) {
				System.out.println("Text 'My Home' showed successfully");
			}
			else {
				System.out.println("Text 'My Home' not showed");
			}
			
			//Click on Leads Button
			WebElement elementLeads = driver.findElement(By.linkText("Leads"));
			elementLeads.click();
			
			//Click on Create Lead
			WebElement elementCreateLeadLink = driver.findElement(By.linkText("Create Lead"));
			elementCreateLeadLink.click();
			
			//Enter CompanyName Field Using id Locator
			WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
			elementCompanyName.sendKeys("TestLeaf");
			
			//Enter FirstName Field Using id Locator
			WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
			elementFirstName.sendKeys("LeafUS");
			
			//Enter LastName Field Using id Locator
			WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
			elementLastName.sendKeys("Test");
			
			//Enter FirstName(Local) Field Using id Locator
			WebElement elementFirstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
			elementFirstNameLocal.sendKeys("LeafFNLocal");
			
			//Enter Department Field Using any Locator of Your Choice
			WebElement elementDepartment = driver.findElement(By.id("createLeadForm_departmentName"));
			elementDepartment.sendKeys("IT");
			
			//Enter Description Field Using any Locator of your choice 
			WebElement elementDescription = driver.findElement(By.id("createLeadForm_description"));
			elementDescription.sendKeys("Create Lead Description");
			
			//Enter your email in the E-mail address Field using the locator of your choice
			WebElement elementEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
			elementEmail.sendKeys("selenium2022@testleaf.com");
			
			//Select State/Province as NewYork Using Visible Text
			System.out.println("Select the State/Province DD option By VisibleText - NewYork:");
			WebElement elementStateProvinceDD = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select stateProvinceDD = new Select(elementStateProvinceDD);
			stateProvinceDD.selectByVisibleText("Indiana");
			System.out.println("Selected Value is: " +stateProvinceDD.getFirstSelectedOption().getText());
			
			 //Click on Create Button
			WebElement elementCreateLeadButton = driver.findElement(By.className("smallSubmit"));
			elementCreateLeadButton.click();
			Thread.sleep(1000);
			
	        //Get the Title of Resulting Page.
			String title = driver.getTitle();
			System.out.println(title);
			if(title.contains("View Lead | opentaps CRM")) {
				System.out.println("Title Matched");
			}
			else {
				System.out.println("Title Not Matched");
			}
			
		}


}
