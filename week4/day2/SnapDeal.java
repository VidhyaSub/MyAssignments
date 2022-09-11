package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		String result = null;
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Go to Mens Fashion
		WebElement menFashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder= new Actions(driver);
		builder.moveToElement(menFashion).perform();
		
		// Go to Sports Shoes
	    WebElement sportsShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
	    sportsShoes.click();
	    
	    //Get the count of the sports shoes
	    WebElement countSportsShoe = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]"));
		String count=countSportsShoe.getText();
		System.out.println(count+" is the count of Sports shoe");
		
		// Click Training shoes
	    WebElement trainingShoe = driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]"));
	    trainingShoe.click();
	    
	    //Sort by Low to High
	    WebElement sortPrice = driver.findElement(By.xpath("(//i[contains(@class,'sd-icon-expand-arrow')])[1]"));
	    sortPrice.click();
	    WebElement lowToHighPrice = driver.findElement(By.xpath("(//ul[@class='sort-value']//li)[2]"));
	    lowToHighPrice.click();
	    
	    //Check if the items displayed are sorted correctly
	    Thread.sleep(3000);
	 
	    List<WebElement> shoePrice = driver.findElements(By.xpath("//span[contains(@class,'lfloat product-price')]"));
	 
	    /*
	 Map<String,String> mp= new LinkedHashMap<String,String>();
		for(int i=0;i<shoePrice.size();i++)
		{
		String a=driver.findElement(By.xpath("(//p[@class='product-title'])["+(i+1)+"]")).getText();
		String b=driver.findElement(By.xpath("(//span[contains(@class,'lfloat product-price')])["+(i+1)+"]")).getText();
		mp.put(a,b);
		}
		
		
		System.out.println(mp);
		*/

	 
	    List<String> shoeNoRsPrice = new ArrayList<String>();
	for(int i=0;i<shoePrice.size();i++)
	{
		String[] a=(shoePrice.get(i).getText()).split(" ");
		shoeNoRsPrice.add(a[1].replace(",",""));
		
	}


	//System.out.println(shoeNoRsPrice);

	int last=Integer.parseInt(shoeNoRsPrice.get(0));

		
		for(int i=1;i<shoeNoRsPrice.size();i++)
		{
		int	current =Integer.parseInt(shoeNoRsPrice.get(i));

				
		if(last<=current)
			{
			
				 result= "true";
				 last=current;
			}
			else 
				result= "false";
		}

	if (result.equals("true"))
		System.out.println("Shoes are sorted corectly from Low Price to Hig Price");

	//Select the price range (900-1200)

	WebElement rangeFrom = driver.findElement(By.name("fromVal"));
	rangeFrom.clear();
	rangeFrom.sendKeys("300");

	WebElement rangeTo = driver.findElement(By.name("toVal"));
	rangeTo.clear();
	rangeTo.sendKeys("1200");

	WebElement goButton = driver.findElement(By.xpath("//div[contains(text(),'GO')]"));
	goButton.click();

	//Filter with color Navy 
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	Thread.sleep(2000);
	WebElement filterNavy = driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Color_s-Navy']")));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='Color_s-Navy']")));

	filterNavy.click();

	//verify the all applied filters 
	Thread.sleep(1000);
	List<WebElement> filter = driver.findElements(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill']"));
	System.out.println("Please find below the filters applied");
	for(int i=0;i<filter.size();i++)
	{
		System.out.println(filter.get(i).getText());
	}
	System.out.println("--------------------");
		
	// Mouse Hover on first resulting Training shoes
	Thread.sleep(1000);
		WebElement firstShoe = driver.findElement(By.xpath("(//picture[@class='picture-elem'])[1]"));
		
		builder.moveToElement(firstShoe).perform();
		//click QuickView button


	WebElement quickView = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(text(),'Quick View')])[1]")));
	Thread.sleep(5000);
	builder.click(quickView).perform();


	//Print the cost and the discount percentage
	String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	String discountedPercentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
	System.out.println("The cost of the selected Shoe is :"+ cost+ " and discounted Price is "+discountedPercentage) ;

	//Take the snapshot of the shoes.
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest= new File("./Screenshot/snap/Image001.png");
	FileUtils.copyFile(source, dest);

	//Close the current window
	driver.findElement(By.xpath("(//i[contains(@class,'sd-icon-delete-sign')])[4]")).click();

	//Close the main window
	//driver.close();
	}

}
