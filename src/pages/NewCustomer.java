package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;



public class NewCustomer {
	
	WebDriver driver;
	
	public void NewCustomer(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	@FindBy(linkText="New Customer")
	WebElement newcust;
	
	@FindBy(name="name")
	WebElement custname;
		
	@FindBy(xpath="//input[@value=\"m\"]")
	WebElement male;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement addr;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement mobile;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(name="sub")
	WebElement submit;
	
	@FindBy(xpath="//tr[4]/td[2]")
	WebElement custID;
	
	@FindBy(xpath="//tr[5]/td[2]")
	WebElement custName;
	
	public void writeexceldata(int row, int col, int value, String sheet) throws IOException {
		
		FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
		
		XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
		XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
		
		
		ws.createRow(row); //creates an entire row
		ws.getRow(row).createCell(col).setCellValue(value); //gets the row mentioned before, creates a col, sets a value
		fs.close();
		
		FileOutputStream os = new FileOutputStream(".\\DataFolder\\Book1.xlsx");
		wb.write(os);
		os.close();
		
	}
	public void newcustomer() throws IOException {
		
		newcust.click();
		custname.sendKeys("Vikram");
		male.click();
		dob.sendKeys("1402");
		dob.sendKeys(Keys.TAB);
		dob.sendKeys("1987");
		addr.sendKeys("Bejai");
		city.sendKeys("Mangalore");
		state.sendKeys("Karnataka");
		pin.sendKeys("575003");
		mobile.sendKeys("1234567890");
		email.sendKeys("vikram1@google.com");
		pass.sendKeys("12345");
		submit.click();	
		
		NewCustomer wd = new NewCustomer();	
		int customerID = Integer.parseInt(custID.getText());		
		wd.writeexceldata(7, 0, customerID, "CustDetails");		
		
	}


}
