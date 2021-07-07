package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Logout {
	
	WebDriver driver;
	
	public void Logout(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@FindBy(linkText="Log out")
	WebElement logout;

	public void logoff() {
		logout.click();
	}

}
