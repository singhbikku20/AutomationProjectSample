          package clearTrip_Testing;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionCleartrip {
	
	WebDriver driver = WebDriverClass.driver();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Actions actions = new Actions(driver);
	
	protected void driverKill()
	{
		driver.quit();
	}
	
	protected void hitURL ()
	{
		driver.get("http://www.cleartrip.com/");
		System.out.println("Current URL: "+(driver.getCurrentUrl()));
		System.out.println("Title: "+(driver.getTitle()));		
	}
	
	protected void login()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClearTripElements.UserAccLink));
		driver.findElement(ClearTripElements.UserAccLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClearTripElements.signINBtn));
		driver.findElement(ClearTripElements.signINBtn).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ClearTripElements.loginframe));			
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClearTripElements.emailInput));
		driver.findElement(ClearTripElements.emailInput).sendKeys("singhbikku20@gmail.com");
		driver.findElement(ClearTripElements.PassInput).sendKeys("cleartrip@12345");
		driver.findElement(ClearTripElements.signInFrameBtn).click();
		//driver.switchTo().defaultContent();		
		//System.out.println("Value1: "+ driver.findElement(ClearTripElements.UserAccLink).getAttribute("title"));
	}
	
	protected void verifyLogin()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ClearTripElements.signInFrameBtn));	
		driver.switchTo().defaultContent();	
		String LoginText = driver.findElement(ClearTripElements.UserAccLink).getAttribute("title");
		
		if (LoginText.equalsIgnoreCase("singhbikku20@gmail.com"))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("login Failed !!!");
		}			
		
	}
	
	protected void oneWaySearch()
	{
		int monthNum;
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClearTripElements.searchForm));
		driver.findElement(ClearTripElements.oneWayRadio).click();
		driver.findElement(ClearTripElements.fromInput).click();
		driver.findElement(ClearTripElements.fromInput).sendKeys("PUNE");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Pune")));
        actions.click(driver.findElement(By.partialLinkText("Pune"))).perform();
        driver.findElement(ClearTripElements.toInput).click();
		driver.findElement(ClearTripElements.toInput).sendKeys("BANGALORE");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Bangalore")));
        actions.click(driver.findElement(By.partialLinkText("Bangalore"))).perform();
        
        DateFormat monthFormat2 = new SimpleDateFormat("M"); 
        DateFormat dateFormat2 = new SimpleDateFormat("d");
        Date date2 = new Date();
        String month = monthFormat2.format(date2);
        String day = dateFormat2.format(date2);
        monthNum = Integer.parseInt(month)-1;
        //System.out.println(day);
        driver.findElement(ClearTripElements.departDate).click();   
        driver.findElement(By.xpath("//td[@data-month='6']/a[text()="+day+"]")).click();  //"+monthNum+"
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClearTripElements.searchBtn));
        driver.findElement(ClearTripElements.searchBtn).click();           
        
	}
	
	protected void HighLowPrice()
	{
		int result, i;															  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='flightForm']/section[2]/div[4]/div/nav/ul/li")));
		result = driver.findElements(By.xpath("//form[@id='flightForm']/section[2]/div[4]/div/nav/ul/li")).size();
		int array[] = new int[result];
		String arrayFlightName[] = new String[result];
		//System.out.println(driver.findElement(By.xpath("//form[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[6]")).getAttribute("class"));
		for (i=1;i<=result;i++)
		{
			if (!"listUnit flightHotelSRPUpsells".equals(driver.findElement(By.xpath("//form[@id='flightForm']/section[2]/div[4]/div/nav/ul/li["+i+"]")).getAttribute("class")))
			{				
				array[i-1]= Integer.parseInt(driver.findElement(By.xpath("//form[@id='flightForm']/section[2]/div[4]/div/nav/ul/li["+i+"]/table/tbody/tr[1]/th[6]/span")).getAttribute("data-pr"));
				arrayFlightName[i-1] = driver.findElement(By.xpath("//form[@id='flightForm']/section[2]/div[4]/div/nav/ul/li["+i+"]/table/tbody/tr[1]/th[1]/span/img")).getAttribute("title");
			}			
		}
		
		Arrays.sort(array);
		System.out.println("low to high:" + Arrays.toString(array));
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(arrayFlightName));
		
		System.out.println("Names: "+Arrays.toString(set.toArray()));
		
		//for (j=0;j<=result-2;)
		
	}
	

}
