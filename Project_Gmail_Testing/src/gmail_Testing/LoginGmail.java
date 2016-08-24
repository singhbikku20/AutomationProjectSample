package gmail_Testing;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginGmail {

	WebDriver driver= WebDriverClass.driver();
	WebDriverWait wait = new WebDriverWait(driver, 20);


	public void hitURL()
	{
		driver.get("http://www.gmail.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	public void login()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.txt_Email));

		driver.findElement(GmailElements.txt_Email).sendKeys(""); // NEED TO ENTER USERID
		driver.findElement(GmailElements.btn_Next).click();
		//Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.txt_Pass));
		driver.findElement(GmailElements.txt_Pass).sendKeys(""); // NEED TO ENTER PASSWORD
		driver.findElement(GmailElements.btn_SignIn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.compose));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(GmailElements.compose)));
	}

	public void verifyLoginSuccess()
	{
		if (driver.findElement(GmailElements.compose).isDisplayed())
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failure");
		}		
		//driver.close();
	}

	public void rowCount()
	{
		int row,i,lowerLimit,upperLimit, finalVal;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.tableRow));
		row = driver.findElements(GmailElements.tableRow).size();
		
		for (i=1;i<=row;i++)
		{
			driver.findElement(By.xpath("//table[@id=':3f']/tbody/tr["+i+"]/td[2]/div")).click();
		}
		
		lowerLimit = Integer.parseInt(driver.findElement(By.xpath("//div[@id=':iw']/span/b[1]")).getText());
		upperLimit = Integer.parseInt(driver.findElement(By.xpath("//div[@id=':iw']/span/b[2]")).getText());
		finalVal = (upperLimit-lowerLimit)+1;
		
		if (finalVal == row)		
		{
			System.out.println("Row Count matched with display count");
		}
		else
		{
			System.out.println("Row Count Unmatched with display count");
		}
		

		System.out.println("Size: "+driver.findElements(GmailElements.tableRow).size());
		//driver.close();
	}

	public void openMail()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.tableRow));
		driver.findElement(By.xpath("//table[@id=':3f']/tbody/tr[1]/td[5]/div[2]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.OpenEmail));
		
		if (driver.findElement(GmailElements.OpenEmail).isDisplayed())
		{
			System.out.println("MailOpened");			
		}
		else
		{
			System.out.println("Not Opened");
		}		
		
		//driver.close();
	}
	
	public void toemailID()
	{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.compose));	
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(GmailElements.compose).click();		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.toInput));
		driver.findElement(GmailElements.toInput).sendKeys("divi.it05@gmail.com");
		
		driver.findElement(GmailElements.ccLinkInput).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.ccInput));
		driver.findElement(GmailElements.ccInput).sendKeys("singhbikku20@gmail.com");
		
		driver.findElement(GmailElements.subjectInput).sendKeys("Mail from arun as test");
		driver.findElement(GmailElements.mailBody).sendKeys("Testing... Ignore please");
		
		driver.findElement(GmailElements.sendBtn).click();
		
	
		driver.close();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(GmailElements.toInput));
	}
	
	
	
}
