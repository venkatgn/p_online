package yahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Compose 
{

	WebDriver driver;
	
	{
    	System.setProperty("atu.reporter.config", "e:\\polaris_online\\myproj\\atu.properties");
    }
	
	public Compose(WebDriver driver)
	{
		this.driver=driver;
	}
	public void sendmail() throws Exception
	{
		Thread.sleep(5000);
		System.out.println("sending mails");
		driver.findElement(By.xpath("//input[@class='composeicon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("to")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("Subj")).sendKeys("hi");
		driver.findElement(By.name("Content")).sendKeys("this is test mail");
		driver.findElement(By.id("send_top")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inbox_back")).click();
		
	}
	public void signout()
	{
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
