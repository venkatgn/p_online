package yahoo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Home 
{
    WebDriver driver;
    
    {
    	System.setProperty("atu.reporter.config", "e:\\polaris_online\\myproj\\atu.properties");
    }
	public Home(WebDriver driver)
	{
		this.driver=driver;
	}
	public void open()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://www.yahoomail.com");		
	}
	public void validate_links()
	{
		open();
		String arr[]={"About Mail","Features","Get the App","Help"}; //expected links
		
		//links get from the webpage
		WebElement toplink=driver.findElement(By.xpath("//ul[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px)']"));
		List<WebElement> lst=toplink.findElements(By.xpath("li/a/b"));
		//compare each link
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].matches(lst.get(i).getText()))
				ATUReports.add("Link is matching",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			else
				ATUReports.add("Link is not matching",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
		}		
	}
	public void createacc()
	{
		   ATUReports.add("Script for creating account",true);
	}
	public void login() throws Exception
	{
		open();
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("passwd")).sendKeys("mq123456");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		
	}
}

