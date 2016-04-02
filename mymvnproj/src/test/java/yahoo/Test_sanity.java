package yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Test_sanity 
{
	
  WebDriver driver;
  
  {
  	System.setProperty("atu.reporter.config", "e:\\polaris_online\\myproj\\atu.properties");
  }
  
  @Test	
  @Parameters({"browser"})
  public void sanitytest(String env) throws Exception
  {
	  if(env.matches("firefox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  if(env.matches("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		  driver=new ChromeDriver();
	  }
	  
	  //driver obj will be either Firefox or chrome
	  Home h=new Home(driver);
	  h.validate_links();
	  h.createacc();
	  h.login();
	  
	  Compose c=new Compose(driver);
	  c.sendmail();
	  c.signout();
	  
  }
}
