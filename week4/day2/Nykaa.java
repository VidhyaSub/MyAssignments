package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver= new ChromeDriver();
     	//Load the url as https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Mouseover on Brands and Search L'Oreal Paris
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder= new Actions(driver);
		builder.moveToElement(brand).perform();		
		WebElement searchBrand = driver.findElement(By.id("brandSearchBox"));
		searchBrand.sendKeys("L'Oreal Paris");
		
		//Click L'Oreal Paris
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		
		//Check the title contains L'Oreal Paris(Hint-GetTitle)
		if(driver.getTitle().contains("L'Oreal Paris"))
		{
			System.out.println("Title has L'Oreal Paris");
		}
		
		//Click sort By and select customer top rated
		 driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//Click Category and click Hair->Click haircare->Shampoo
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5000));
	
		WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Category']")));
		wait.until(ExpectedConditions.elementToBeClickable(category));
		category.click();
		Thread.sleep(3000);
		WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Hair']")));
		wait.until(ExpectedConditions.elementToBeClickable(hair));		
		hair.click();

		WebElement hairCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Hair Care']")));
		wait.until(ExpectedConditions.elementToBeClickable(hairCare));
		hairCare.click();
		WebElement Shampoo = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Shampoo']")));
		wait.until(ExpectedConditions.elementToBeClickable(Shampoo));
		Shampoo.click();
		
		//Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Concern']")));
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Color Protection']")));
		
		//check whether the Filter is applied with Shampoo
		List<WebElement> filterlist = driver.findElements(By.xpath("//span[@class='filter-value']"));
		for(int i=0;i<filterlist.size();i++)
		{
			if(filterlist.get(i).getText().contains("Shampoo"))
			{
				System.out.println("Filter Shampoo is applied");
			}
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();
		
		//GO to the new window and select size as 360ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wh=new ArrayList<String>(windowHandles);
		driver.switchTo().window(wh.get(1));
		WebElement sizeSelect = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select sel= new Select(sizeSelect);
		sel.selectByIndex(2);
		
		//Print the MRP of the product
		String mrp = driver.findElement(By.xpath("//span[text()='MRP:']//following-sibling::span")).getText();
		System.out.println("MRP is:"+mrp);
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		
		//Go to Shopping Bag 
		WebElement shoppingBag = driver.findElement(By.xpath("//span[@class='cart-count']"));
		shoppingBag.click();
		
		//Print the Grand Total amount
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(frame1);
		WebElement grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']//following-sibling::div"));
     	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Grand Total']//following-sibling::div")));
     	String gt=grandTotal.getText();
		System.out.println("Total price with shipping cost is "+ grandTotal.getText());
		
		//driver.switchTo().defaultContent();
		
		//Click Proceed
		WebElement proceedButton = driver.findElement(By.xpath("//button[contains(@class,'no-radius proceed ')]"));
		proceedButton.click();
		
		//Click on Continue as Guest
		WebElement guest = driver.findElement(By.xpath("//button[contains(@class,'btn full big')]"));
		guest.click();
		
		//Check if this grand total is the same in step 14
		if(mrp.equals(gt))
		{
			System.out.println("Price matches in Initial Page and in Bag Page");
		}
		else
			System.out.println("Price not matching");
		
		//Close all windows
		//driver.quit();
		
	}

}
