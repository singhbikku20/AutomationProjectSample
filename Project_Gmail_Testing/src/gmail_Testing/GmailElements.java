package gmail_Testing;

import org.openqa.selenium.By;

public class GmailElements {


	static By txt_Email = By.id("Email");
	static By btn_Next  = By.id("next");  
	static By txt_Pass  = By.id("Passwd");
	static By btn_SignIn  = By.id("signIn");
	static By compose 		= By.xpath("//div[@id=':j2']/div/div");
	static By tableRow		=By.xpath("//table[@id=':3f']/tbody/tr");
	static By OpenEmail    = By.xpath("//div[@class='iw ajw']/span/span");
	static By toInput  	= By.name("to");
	static By ccLinkInput  = By.xpath("//span[text()='Cc']");
	static By ccInput = By.name("cc");
	static By subjectInput = By.name("subjectbox");
	static By mailBody   = By.xpath("//div[@aria-label='Message Body']");
	static By sendBtn = By.xpath("//div[text()='Send']");

	





}
