package objects;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class baseclass {
  
	WebDriver driver;
	
  @BeforeSuite
  public void beforeSuite() {
	  
	  System.setProperty("webdriver.chrome.driver", "./DriverFolder/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://www.demo.guru99.com/V4/index.php");
	  driver.manage().window().maximize();
	  
  }

}
