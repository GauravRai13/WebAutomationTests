package serviceNsw.serviceNsw;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NumberPlateTest {

	String ChromeDriverPath = "..\\serviceNsw\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeTest
	public void BeforeTest()
	{
		//Invoke chrome Browser and navigate to www.service.com.au web site
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath); 
		driver= new ChromeDriver();
		driver.get("https://www.service.nsw.gov.au/");			
		driver.manage().window().fullscreen();
	}

	@Test
	public void ApplyForNumberPlate()
	{
		//Search for 'apply for a number plate'
		driver.findElement(By.xpath("//*[@id='homeAutosuggest']/input")).sendKeys("apply for a number plate");
		driver.findElement(By.xpath("//*[@id='homeAutosuggest']/following-sibling::*/*")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.service.nsw.gov.au/search-results?q=apply+for+a+number+plate");

	}


	@Test(dataProvider="InputData", dataProviderClass=Data.class)
	public void FindLocations(String location, String ServiceCentre)
	{
		//Click on Find Locations and select the desired service center
		driver.findElement(By.linkText("Find locations")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='locatorTextSearch']")).sendKeys(location);
		driver.findElement(By.xpath("//*[@id='locatorTextSearch']/parent::*/following-sibling::*/*")).click();
		driver.findElement(By.linkText(ServiceCentre)).click();

	}

	@AfterTest
	public void AfterTest()
	{
		//Close the browser after test
		driver.close();

	}

}
