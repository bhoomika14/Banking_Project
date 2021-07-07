package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Edit {
  	WebDriver driver;
  	
  	public void Edit(WebDriver driver) {
  		this.driver = driver;
  	}
  
  	@FindBy(linkText="Edit Customer")
	WebElement edcust;
  	
  	@FindBy(name="cusid")
  	WebElement custid;
  	
  	@FindBy(name="AccSubmit")
  	WebElement sub;
  	
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
	
//	@FindBy(name="emailid")
//	WebElement email;
//	
//	@FindBy(name="password")
//	WebElement pass;
	
	@FindBy(name="sub")
	WebElement submit;
	
	public static CharSequence readexceldata(int row, int col, String sheet) throws IOException {
			
			FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
			
			XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
			XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
			XSSFCell cell = ws.getRow(row).getCell(col); //object for cells(row and column)
			
			cell.setCellType(CellType.STRING); //convert cells value to string
			String data = cell.toString(); //to hold the string value in excel cell
			
			return data;
			
		}
	  	
  	public void editcust() throws IOException {
  		edcust.click();
  		
  		custid.sendKeys(readexceldata(7,0,"CustDetails"));
  		sub.click();  
  		
  		addr.clear();
//  		city.clear();
//  		state.clear();
//  		pin.clear();
//  		mobile.clear();
  		
  		addr.sendKeys("Ladyhill");
//		city.sendKeys("Mangalore");		
//		state.sendKeys("Karnataka");
//		pin.sendKeys("575003");
//		mobile.sendKeys("1234567890");
//		email.sendKeys("jps@yahoo.com");
//		pass.sendKeys("12345");
		
		submit.click();
  	}
  	
}

//Edit Customer